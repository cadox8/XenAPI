![Logo](docs/logo/svg/logo-no-background.svg)

[![Build Status](https://github.com/cadox8/XenAPI/actions/workflows/build.yml/badge.svg)](https://github.com/cadox8/XenAPI/actions)

## This is a simple XenForo 2.X API for Java.

-----

## Summary

* [XenAPI for Xenforo 1.X](#me.cadox8.xenapi-for-xenforo-1x)
* [Downloads & Repo](#downloads--repo)
* [Documentation](#documentation)
* [Bug Reporting](#bug-reporting)
* [Contributing](#contributing)
* [Usage & API Key](#usage--api-key)
* [Dependencies](#dependencies)
* [Bug Reporting](#bug-reporting)
* [License & Copyright](#license--copyright)

-----

## XenAPI for Xenforo 1.X

This repo contains only a framework for Xenforo 2.X.

v1.X of Xenforo will not be developed anymore. If you need the old API you can grab it
from [here](https://github.com/cadox8/XenAPI/releases/tag/Xenforo_v1.X).

## Downloads & Repo

All downloads are hosted in [this repo](https://repo.cadox8.es/#/).

Alternatively, you can download files [here on Github](https://github.com/cadox8/XenAPI/releases/latest).

For the Java-API, you can add it on Maven:

```xml

<repositories>
    <repository>
        <id>XenAPI Repo</id>
        <url>https://repo.cadox8.es/#/</url>
    </repository>
</repositories>

<dependencies>
<dependency>
    <groupId>es.cadox8</groupId>
    <artifactId>XenAPI</artifactId>
    <version>LATEST</version>
</dependency>
</dependencies>
```

**NOTE:** You can use ``LATEST`` as version, or you can use the version number (you can check all
versions [here](https://repo.cadox8.es/#/) or [on the docs](https://)).

## Documentation

**Web-API & Java-API:** You can get the documentation [here](https://cadox8.github.io/XenAPI/#/).

**Javadocs:** You can check the Javadocs [here](https://cadox8.github.io/XenAPI/javadocs).

## Bug Reporting

You can create an issue here on GitHub to report a bug with the API or to suggest enhancements.

## Contributing

If you want to contribute to the project, you must accept and follow our [Code Of Conduct](.github/CODE_OF_CONDUCT.md) and
our [guides for contributing](.github/CONTRIBUTING.md).

## Usage & API Key

You will need to enable API in your XenForo. You can use this [guide](https://xenforo.com/docs/dev/rest-api/).

## Dependencies

The XenAPI (Java) has the following dependencies:

* [Google Gson library](https://mvnrepository.com/artifact/com.google.code.gson/gson)
* [Project Lombok](https://projectlombok.org)
* [Apache HttpClient](https://hc.apache.org)
* [StaticLog](https://github.com/jupf/staticlog)

## License & Copyright

XenAPI is licensed under [GNU LESSER GENERAL PUBLIC LICENSE Version 3](LICENSE.md).

Some parts of the PHP Code is property of [Contex](https://github.com/Contex/XenAPI).

Cadox8 updated the code and created the Java API.

[Contex](https://github.com/Contex) © 2012-2014

[Cadox8](https://cadox8.es) © 2018-2025