#! /usr/bin/env python
"""Work with api.yaml files from a BMI description."""

import os
import types

import yaml

from .utils import cd, check_output, system
from .git import git_repo_name, git_clone_or_update, git_repo_sha
from .errors import (MissingFileError, ParseError, MissingKeyError,
                     UnknownKeyError)
from . import build


_REQUIRED_KEYS = set(['language', 'build', ])
_OPTIONAL_KEYS = set(['name', 'type', 'register', 'class', 'package',
                      'libs', 'cflags', 'includes'])
_VALID_KEYS = _REQUIRED_KEYS | _OPTIONAL_KEYS


def validate_api(api):
    """Validate API description or raise an exception.

    Parameters
    ----------
    api : dict_like
        Description of a BMI.

    Raises
    ------
    ParseError on an invalid description.
    MissingKeyError if a required key is missing
    UnknownKeyError if an unknown key is found
    """
    if not isinstance(api, dict):
        raise ParseError('object is not a dictionary')

    found_keys = set(api.keys())

    if not found_keys.issuperset(_REQUIRED_KEYS):
        raise MissingKeyError(_REQUIRED_KEYS - found_keys)

    if not found_keys.issubset(_VALID_KEYS):
        raise UnknownKeyError(found_keys - _VALID_KEYS)

    return True


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

    validate_api(api)

    api.pop('build')

    if api['language'] == 'c':
        cflags = api['cflags']
        if isinstance(cflags, dict) and 'pkgconfig' in cflags:
            api['cflags'] = pkg_config(cflags['pkgconfig'], '--cflags')

        libs = api['libs']
        if isinstance(libs, dict) and 'pkgconfig' in libs:
            api['libs'] = pkg_config(cflags['pkgconfig'], '--libs')
    elif api['language'] == 'python':
        pass

    return api


def execute_api_build(dir='.'):
    """Build an API from a file.

    Parameters
    ----------
    dir : str, optional
        Path to folder that contains description file.
    """
    build.execute_build(build.load_script(dir=dir))
