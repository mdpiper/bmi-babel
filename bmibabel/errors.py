
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
