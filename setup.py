from setuptools import setup


def read(*names, **kwds):
    from codecs import open
    from os import path


    _HERE = path.abspath(path.dirname(__file__))

    return open(
        path.join(_HERE, *names),
        encoding=kwds.get('encoding', 'utf-8')
    ).read()


setup(
    name='bmibabel',
    version="0.1.0",
    description='Generate BMI language bindings with babel.',
    long_description=read('README.md'),
    url='https://github.com/csdms/bmi-babel',

    author='Eric Hutton',
    author_email='hutton.eric@gmail.com',

    license='MIT',

    packages=['bmibabel', 'bmibabel.cmd'],

    entry_points={
        'console_scripts': [
            'bmi-babel-make=bmibabel.cmd.make:main',
            'bmi-babel-fetch=bmibabel.cmd.bmi_babel_fetch:main',
        ],
    },
)
