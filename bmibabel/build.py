#! /usr/bin/env python
"""Build a BMI implementation."""
from __future__ import print_function

import os
import sys
import types

import yaml

from .utils import cd


def load_script(dir='.'):
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
        with open(os.path.join('.bmi', 'api.yaml'), 'r') as file_like:
            api = yaml.load(file_like)

    if isinstance(api['build'], dict) and 'brew' in api['build']:
        return brew_install_instructions(api['build']['brew'])
    else:
        return bash_install_instructions(api['build'])


def brew_install_instructions(brewer):
    """Shell commands to install a formula with Homebrew.

    Parameters
    ----------
    brewer : dict
        Description of Homebrew formula.

    Returns
    -------
    list
        Shell commands needed to install the formula.
    """
    opts = brewer.get('options', [])
    formula = brewer['formula']

    if isinstance(opts, types.StringTypes):
        opts = [opts]

    return [' '.join(['brew', 'install', formula] + opts)]


def bash_install_instructions(script):
    """Shell commands to install something.

    Parameters
    ----------
    script : str or iterable
        Shell commands as a string or a list of strings.

    Returns
    -------
    list
        Shell commands.
    """
    if isinstance(script, types.StringTypes):
        return [script]
    else:
        return script


def render_output_block(output, indent=4):
    """Format a block of output text.

    Parameters
    ----------
    output : str
        Text to format.
    indent : int, optional
        Number of spaces to indent text.

    Returns
    -------
    str
        Formatted text.
    """
    lines = output.split(os.linesep)
    return os.linesep.join([' ' * indent + line for line in lines])


def execute_build(instructions, prefix='/usr/local'):
    """Build an API from a description.

    Parameters
    ----------
    build : dict
        Build description.
    """
    import pexpect

    os.environ['CSDMS_PREFIX'] = prefix

    child = pexpect.spawn('bash', echo=False)

    prompt = r"\[bmi-babel\]\$ "
    child.sendline(r"PS1='[bmi-babel]\$ '")
    child.expect([pexpect.TIMEOUT, prompt], timeout=10)

    for instruction in instructions:
        print('==> %s' % instruction, file=sys.stderr)
        child.sendline(instruction + ' || echo FAIL')
        i = child.expect([pexpect.TIMEOUT, prompt, 'FAIL'], timeout=10)
        print(render_output_block(child.before), file=sys.stderr)
        if i == 0 or i == 2:
            break
