#! /usr/bin/env python
"""Work with api.yaml files from a BMI description."""

import os
import types

import yaml

from .utils import cd, check_output, system
from .git import git_repo_name, git_clone_or_update, git_repo_sha
from .errors import MissingFileError


_REQUIRED_KEYS = set(['language', 'build', 'includes', 'cflags', 'libs'])
_OPTIONAL_KEYS = set(['name', 'type', 'register'])
_VALID_KEYS = _REQUIRED_KEYS | _OPTIONAL_KEYS


def is_valid_api(api):
    """Validate API description.

    Parameters
    ----------
    api : dict_like
        Description of a BMI.

    Returns
    -------
    boolean
        True if a valid description, otherwise False.

    See Also
    --------
        is_valid_api_or_raise
    """
    if not isinstance(api, dict):
        return False

    found_keys = set(api.keys())

    if not found_keys.issuperset(_REQUIRED_KEYS):
        return False

    if not found_keys.issubset(_VALID_KEYS):
        return False

    return True


def is_valid_api_or_raise(api):
    """Validate API description or raise an exception.

    Parameters
    ----------
    api : dict_like
        Description of a BMI.

    Raises
    ------
    RuntimeError on an invalid description.

    See Also
    --------
    is_valid_api
    """
    if not is_valid_api(api):
        raise RuntimeError('invalid api yaml')


def pkg_config(package, opt):
    """Use pkg-config to get compile options.

    Parameters
    ----------
    package : str
        Name of pkg-config package.
    opt : {'--cflags', '--libs'}
        Options for pkg-config.

    Returns
    -------
    str
        Compiler flags.
    """
    assert(opt in ['--cflags', '--libs'])

    return check_output(['pkg-config', opt, package]).strip()


def load(dir='.'):
    """Load an api description from a file.

    Parameters
    ----------
    dir : str, optional
        Path to folder that contains description file.

    Returns
    -------
    dict
        Description of the API.

    Raises
    ------
    RuntimeError is the description is invalid.
    """
    with cd(dir):
        try:
            with open(os.path.join('.bmi', 'api.yaml'), 'r') as fp:
                api = yaml.load(fp)
        except IOError:
            raise MissingFileError('api.yaml')

    is_valid_api_or_raise(api)

    api.pop('build')

    cflags = api['cflags']
    if isinstance(cflags, dict) and 'pkgconfig' in cflags:
        api['cflags'] = pkg_config(cflags['pkgconfig'], '--cflags')

    libs = api['libs']
    if isinstance(libs, dict) and 'pkgconfig' in libs:
        api['libs'] = pkg_config(cflags['pkgconfig'], '--libs')

    return api


def load_build_script(dir='.'):
    """Load a build script for an API description file.

    Parameters
    ----------
    dir : str, optional
        Path to folder that contains description file.

    Returns
    -------
    dict
        Build description

    Raises
    ------
    RuntimeError is the build is not a supported build type.
    """
    with cd(dir):
        with open(os.path.join('.bmi', 'api.yaml'), 'r') as fp:
            api = yaml.load(fp)

    is_valid_api_or_raise(api)

    if isinstance(api['build'], dict) and 'brew' in api['build']:
        return api['build']
    else:
        raise RuntimeError('only building with homebrew is supported')


def execute_build(build):
    """Build an API from a description.

    Parameters
    ----------
    build : dict
        Build description.
    """
    brew = build['brew']
    opts = brew.get('options', [])

    if isinstance(opts, types.StringTypes):
        opts = [opts]

    system(['brew', 'install', brew['formula']] + opts)


def execute_api_build(dir='.'):
    """Build an API from a file.

    Parameters
    ----------
    dir : str, optional
        Path to folder that contains description file.
    """
    build = load_build_script(dir=dir)
    execute_build(build)
