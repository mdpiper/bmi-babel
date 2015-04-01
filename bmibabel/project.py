"""Description of a bocca project for the Basic Model Interface."""

import os


_THIS_DIR = os.path.dirname(__file__)


def empty_bmi_project():
    """Description of an empty bocca project."""
    return {
        'name': 'csdms',
        'language': 'c',
        'interfaces': [{
            'name': 'csdms.core.Bmi',
            'sidl': os.path.join(_THIS_DIR, 'data', 'csdms.core.Bmi.sidl')
        }],
        'bmi': []
    }


def add_bmi_component(project, api):
    """Add a BMI component to a project.

    Parameters
    ----------
    project : dict or list
        Project description or list of descriptions.
    api : dict
        API description.
    """
    try:
        project['bmi'].extend(api)
    except TypeError:
        project['bmi'].append(api)
