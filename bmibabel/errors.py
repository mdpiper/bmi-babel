"""Define errors for the bmibabel package."""

import types


class Error(Exception):

    """Base exception class for this module."""

    pass


class ProjectExistsError(Error):

    """Raise this exception for an already existing project."""

    def __init__(self, name):
        self._name = name

    def __str__(self):
        return self._name


class MissingFileError(Error):

    """Raise this exception if a required file is missing."""

    def __init__(self, fname):
        self._fname = fname

    def __str__(self):
        return self._fname


class ParseError(Error):

    """Raise this exception if unable to parse a file."""

    def __init__(self, msg):
        self._msg = msg

    def __str__(self):
        return self._msg


class MissingKeyError(ParseError):

    """Raise this exception if a required key is missing."""

    def __init__(self, key):
        if not isinstance(key, types.StringTypes):
            key = ', '.join(key)
        self._key = key

    def __str__(self):
        return 'missing keys: %s' % self._key


class UnknownKeyError(MissingKeyError):

    """Raise this exception if an unknown key is present."""

    def __str__(self):
        return 'unknown keys: %s' % self._key
