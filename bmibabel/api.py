#! /usr/bin/env python
"""Work with api.yaml files from a BMI description."""

import os

import yaml

from .utils import cd, check_output
from .errors import ParseError, MissingKeyError, UnknownKeyError
from . import build
from .utils import read_first_of


_API_FILES = [os.path.join('.bmi', 'api.yaml'),
              os.path.join('.bmi', 'api.yml')]

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
    ParseError
        If the description object is invalid.
    MissingKeyError
        If a required key is missing
    UnknownKeyError
        If an unknown key is found
    """
    if not isinstance(api, dict):
        raise ParseError('object is not a dictionary')

    found_keys = set(api.keys())

    if not found_keys.issuperset(_REQUIRED_KEYS):
        raise MissingKeyError(_REQUIRED_KEYS - found_keys)

    if not found_keys.issubset(_VALID_KEYS):
        raise UnknownKeyError(found_keys - _VALID_KEYS)

    return True


def prepend_env_path(path_var, path, env=None):
    """Prepend a path to and environment variable.

    Parameters
    ----------
    path_var : str
        Environment variable.
    path : str
        Path to prepend.
    env : dict, optional
        Environment to use, otherwise the current environment.
    """
    env = env or os.environ

    try:
        env[path_var] = os.path.sep.join([path, env[path_var]])
    except KeyError:
        env[path_var] = path


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
    import copy

    assert(opt in ['--cflags', '--libs'])

    env = copy.copy(os.environ)
    if 'CSDMS_PREFIX' in env:
        pkg_config_path = os.path.join(env['CSDMS_PREFIX'], 'lib', 'pkgconfig')
        prepend_env_path('PKG_CONFIG_PATH', pkg_config_path, env=env)

    return check_output(['pkg-config', opt, package], env=env).strip()


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
    ParseError
    MissingKeyError
    UnknownKeyError
        If the description is invalid.
    MissingFileError
        If an api file cannot be read.
    """
    with cd(dir):
        api = yaml.load(read_first_of(_API_FILES))

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


def execute_api_build(dir='.', prefix='/usr/local'):
    """Build an API from a file.

    Parameters
    ----------
    dir : str, optional
        Path to folder that contains description file.
    """
    build.execute_build(build.load_script(dir=dir), prefix=prefix)
