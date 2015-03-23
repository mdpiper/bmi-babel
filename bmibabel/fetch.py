#! /usr/bin/env python
"""Fetch remote BMI models."""

import os
import subprocess
import re
import types

import yaml
from distutils.dir_util import mkpath

from .utils import cd, check_output, system, read_first_of
from .git import git_repo_name, git_clone_or_update, git_repo_sha
from .project import empty_bmi_project, add_bmi_component
from . import api


def load_bmi_info(dir):
    """Load a BMI info file.

    Parameters
    ----------
    dir : str
        Path to model that contains a BMI description.

    Returns
    -------
    dict
        Description of the BMI model.
    """
    with cd(dir):
        with open(os.path.join('.bmi', 'info.yaml'), 'r') as fp:
            info = yaml.load(fp)

        if 'summary' not in info:
            info['summary'] = read_first_of(['README.md', 'README',
                                             'README.txt']).strip()

        if 'license' not in info:
            info['license'] = read_first_of(['LICENSE', 'LICENSE.txt']).strip()

    return info


def load_bmi_api(dir='.'):
    """Load an API description file.

    Parameters
    ----------
    dir : str, optional
        Path to model that contains a BMI description.

    Returns
    -------
    dict
        Description of the model API.
    """
    with cd(dir):
        with open(os.path.join('.bmi', 'api.yaml'), 'r') as fp:
            api = yaml.load(fp)
    api.pop('build')

    if isinstance(api['cflags'], dict) and 'pkgconfig' in api['cflags']:
        api['cflags'] = check_output(['pkg-config', '--cflags',
                                      api['cflags']['pkgconfig']]).strip()

    if isinstance(api['libs'], dict) and 'pkgconfig' in api['libs']:
        api['libs'] = check_output(['pkg-config', '--libs',
                                    api['libs']['pkgconfig']]).strip()

    return api


def load_build_script(dir='.'):
    """Load a BMI build script.

    Parameters
    ----------
    dir : str, optional
        Path to model that contains a BMI description.

    Returns
    -------
    dict
        Build description.
    """
    with cd(dir):
        with open(os.path.join('.bmi', 'api.yaml'), 'r') as fp:
            api = yaml.load(fp)
    return api['build']


def build_api(build):
    """Build the API from a script.

    Parameters
    ----------
    build : dict
        Build description.
    """
    if isinstance(build, dict) and 'brew' in build:
        brew = build['brew']
        opts = brew.get('options', [])
        if isinstance(opts, types.StringTypes):
            opts = [opts]
        system(['brew', 'install', brew['formula']] + opts)
    else:
        raise RuntimeError('only building with homebrew is supported')


def cache_dir_from_repo(repo, branch='master'):
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


def component_name_from_repo(repo, name=None):
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


def parse_repo_line(line):
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

def main():
    import argparse
    parser = argparse.ArgumentParser()

    parser.add_argument('repo', type=str, nargs='+',
                        help='GitHub repository for BMI implementation')

    args = parser.parse_args()

    proj = empty_bmi_project()
    for repo in args.repo:
        repo, branch = parse_repo_line(repo)

        cache_dir = cache_dir_from_repo(repo, branch=branch)

        git_clone_or_update(repo, dir=cache_dir, branch=branch)

        with cd(cache_dir) as _:
            bmi = api.load()
            api.execute_api_build()

        bmi['name'] = component_name_from_repo(repo, bmi.get('name', None))

        add_bmi_component(proj, bmi)

    print yaml.dump(proj, default_flow_style=False)


if __name__ == '__main__':
    main()
