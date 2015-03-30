"""Make a bocca project that wraps BMI implementations.

Use this command to create a bocca project that wraps BMI implementations
as babel classes. The build project can then be compiled and installed so
that language bindings are created for each babel-supported language.
Currently, this is *C*, *C++*, *Python*, *Fortran*, and *Java*.

The ``bmi-babel-make`` command uses a YAML description of the project to
create a new project.

For this command to work, you must have both `babel`_ and `bocca`_ installed
on your machine. This isn't always an easy task. For Mac, you may be able to
use `Homebrew`_. If you have Homebrew installed and you're lucky, the following
should do the trick,

.. _Homebrew: http://brew.sh
.. _babel: http://www.cca-forum.org
.. _bocca: http://www.cca-forum.org

.. code-block:: bash

    > brew tap csdms/tools
    > brew install bocca

Examples
--------

This example uses the following project description file,

.. code-block:: yaml

    language: c
    name: csdms

    interfaces:
    - name: csdms.core.Bmi

    bmi:
    - name: csdms.model.HeatC
      language: c
      includes:
      - "#include <heat/bmi_heat.h>"
      register: register_bmi_heat

    - name: csdms.model.HeatPy
      language: python
      package: csdms.heat
      class: Heat

Running ``bmi-babel-make`` on this file creates a bocca project called
*csdms* that contains the interface *csdms.core.Bmi* and two classes that
implememnt this interface: ``csdms.model.HeatC`` and ``csdms.model.HeatPy``.
The new project will be in a folder called *csdms*. To build the language
bindings for the BMI classes,

.. code-block:: sh

    > cd csdms
    > ./configure
    > make
    > make install

The language bindings are now installed in the *install* folder.
"""
import argparse

import yaml

from ..bocca import make_project, ProjectExistsError


def main():
    """Make language wrappers for BMI implementations."""

    parser = argparse.ArgumentParser()
    parser.add_argument('file', type=argparse.FileType('r'),
                        help='Project description file')
    parser.add_argument('--clobber', action='store_true',
                        help='Clobber an existing project')

    args = parser.parse_args()

    try:
        make_project(yaml.load(args.file), clobber=args.clobber)
    except ProjectExistsError as error:
        print 'The specified project (%s) already exists. Exiting.' % error


if __name__ == '__main__':
    main()
