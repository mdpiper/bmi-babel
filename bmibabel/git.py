#! /usr/bin/env python
"""Git-related utility functions."""

import os

from .utils import which, check_output, system, cd, status


def git_repo_name(url):
    """Get the name of a git repository.

    Parameters
    ----------
    url : str
        URL of a git repository.

    Returns
    -------
    str
        Name of the repository.
    """
    (base, _) = os.path.splitext(os.path.basename(url))
    return base


def git_repo_sha(url, git=None, branch='master'):
    """Get the SHA for a git repository.

    Parameters
    ----------
    url : str
        URL of a git repository.
    git : str, optional
        Path to the git program.
    branch : str, optional
        Branch of the git repository.

    Returns
    -------
    str
        First 10 characters of the SHA.
    """
    git = git or which('git')

    lines = check_output([git, 'ls-remote', url]).strip().split(os.linesep)
    shas = dict()
    for line in lines:
        (sha, name) = line.split()
        shas[name] = sha

    return shas['refs/heads/{branch}'.format(branch=branch)][:10]


def git_clone(url, git=None, dir='.', branch='master'):
    """Clone a git repository.

    Parameters
    ----------
    url : str
        URL of a git repository.
    git : str, optional
        Path to the git program.
    dir : str, optional
        Path to a folder to clone into.
    branch : str, optional
        Branch of the git repository.
    """
    git = git or which('git')

    with cd(dir):
        system([git, 'init', '-q'])
        system([git, 'config', 'remote.origin.url', url])
        system([git, 'config', 'remote.origin.fetch',
                '+refs/heads/*:refs/remotes/origin/*'])
        system([git, 'fetch', 'origin',
                '{branch}:refs/remotes/origin/{branch}'.format(branch=branch),
                '-n', '--depth=1'])
        system([git, 'reset', '--hard',
                'origin/{branch}'.format(branch=branch)])


def git_pull(dir='.', branch='master', git=None):
    """Pull from a git repository.

    Parameters
    ----------
    git : str, optional
        Path to the git program.
    dir : str, optional
        Path to a folder that contains the git repository.
    branch : str, optional
        Branch of the git repository.
    """
    git = git or which('git')

    with cd(dir):
        system(['git', 'checkout', '-q', branch])
        system(['git', 'pull', 'origin', '-q',
                ':'.join([
                    'refs/heads/{branch}',
                    'refs/remotes/origin/{branch}']).format(branch=branch)])


def git_clone_or_update(url, dir='.', branch='master', git=None):
    """Clone (or update) a git repository .

    If the repository doesn't not exists locally, clone it from *url*.
    Otherwise, simply update it.

    Parameters
    ----------
    url : str
        URL of a git repository.
    git : str, optional
        Path to the git program.
    dir : str, optional
        Path to a folder that contains the git repository.
    branch : str, optional
        Branch of the git repository.
    """
    if os.path.isdir(os.path.join(dir, '.git')):
        status('Updating %s' % url)
        git_pull(dir=dir, branch=branch, git=git)
    else:
        status('Cloning %s' % url)
        git_clone(url, dir=dir, branch=branch, git=git)
