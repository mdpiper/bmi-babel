"""Define errors for the bmibabel package."""

import types


class Error(Exception):

    """Base exception class for this module."""

    pass


class ProjectExistsError(Error):

    """Raise this exception for an already existing project."""

    def __init__(self, name):
        """Initialize with project name.

        Parameters
        ----------
        name : str
            Name of project.
        """
        self._name = name

    def __str__(self):
        """Convert to string.
        
        Returns
        -------
        str
            Name of existing project.
        """
        return self._name


class MissingFileError(Error):

    """Raise this exception if a required file is missing."""

    def __init__(self, fname):
        """Initialize if missing file name.

        Parameters
        ----------
        fname : str
            Name of missing file.
        """
        self._fname = fname

    def __str__(self):
        """Convert to string.
        
        Returns
        -------
        str
            Name of the missing file.
        """
        return self._fname


class ParseError(Error):

    """Raise this exception if unable to parse a file."""

    def __init__(self, msg):
        """Initialize with error message.

        Parameters
        ----------
        msg : str
            Error message.
        """
        self._msg = msg

    def __str__(self):
        """Convert to string.
        
        Returns
        -------
        str
            Error message.
        """
        return self._msg


class MissingKeyError(ParseError):

    """Raise this exception if a required key is missing."""

    def __init__(self, key):
        """Initialize with missing key.

        Parameters
        ----------
        key : str or iterable
            Missing key or keys.
        """
        if not isinstance(key, types.StringTypes):
            key = ', '.join(key)
        self._key = key

    def __str__(self):
        """Convert to string.
        
        Returns
        -------
        str
            Error message with the missing key or keys.
        """
        return 'missing keys: %s' % self._key


class UnknownKeyError(MissingKeyError):

    """Raise this exception if an unknown key is present."""

    def __str__(self):
        """Convert to string.
        
        Returns
        -------
        str
            Error message with the unknown key or keys.
        """
        return 'unknown keys: %s' % self._key
