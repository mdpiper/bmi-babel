#! /usr/bin/env python
"""Fetch remote BMI models."""
from __future__ import print_function

import os
import sys
import re

import yaml

from ..utils import cd, check_output, read_first_of
from ..git import git_repo_name, git_clone_or_update, git_repo_sha
from ..project import empty_bmi_project, add_bmi_component
from .. import api
from ..errors import MissingFileError, ParseError


def _cache_dir_from_repo(repo, branch='master'):
    """Name of cache directory for a git repository.

    Parameters
    ----------
    repo : str
        URL of git repository.
    branch : str, optional
        Branch of the git repository.

    Returns
    -------
    str
        Name of the directory to use for the cache.
    """
    return os.path.join('cache', git_repo_name(repo) +
                                 '-%s' % git_repo_sha(repo, branch=branch))


def _component_name_from_repo(repo, name=None):
    """Get fully-qualified component name from repository name.

    Parameters
    ----------
    repo : str
        Name of a repository.
    name : str, optional
        Name of component.

    Returns
    -------
    str
        Fully-qualified component name.
    """
    name = name or re.sub('-', '', os.path.basename(repo).title())

    return '.'.join(['model', name])


def _parse_repo_line(line):
    """Parse a line containing the location of a BMI repository.

    Parameters
    ----------
    line : str
        Location of repository.

    Returns
    -------
    (repo, branch)
        Tuple of repository url, and a branch name.
    """
    if ',' in line:
        repo, branch = line.split(',')
    else:
        repo, branch = line, 'master'

    return repo.strip(), branch.strip()


def _get_bmi_from_repo(repo, prefix='/usr/local'):
    if repo.startswith('http'):
        repo, branch = _parse_repo_line(repo)

        cache_dir = _cache_dir_from_repo(repo, branch=branch)

        git_clone_or_update(repo, dir=cache_dir, branch=branch)
    else:
        cache_dir = repo

    with cd(cache_dir) as _:
        api.execute_api_build(prefix=prefix)
        bmi = api.load()

    bmi['name'] = _component_name_from_repo(repo, bmi.get('name', None))

    return bmi


def main():
    import argparse
    parser = argparse.ArgumentParser()

    parser.add_argument('repo', type=str, nargs='+',
                        help='GitHub repository for BMI implementation')
    parser.add_argument('--prefix', type=str, default='/usr/local/csdms',
                        help='Prefix for installation')

    args = parser.parse_args()

    proj = empty_bmi_project()
    for repo in args.repo:
        try:
            add_bmi_component(proj, _get_bmi_from_repo(repo,
                                                       prefix=args.prefix))
        except MissingFileError as err:
            print('Skipping %s: missing file (%s)' % (repo, err),
                  file=sys.stderr)
        except ParseError as err:
            print('Skipping %s: parse error (%s)' % (repo, err),
                  file=sys.stderr)

    print('%s' % yaml.dump(proj, default_flow_style=False), file=sys.stdout)


if __name__ == '__main__':
    main()
