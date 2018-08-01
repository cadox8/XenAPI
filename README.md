![Logo](docs/img/logo.png)

[![Build Status](https://travis-ci.org/cadox8/XenAPI.svg?branch=master)](https://travis-ci.org/cadox8/XenAPI)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI.svg?type=small)](https://app.fossa.io/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI?ref=badge_small)
[![Documentation Status](https://readthedocs.org/projects/xenapi/badge/?version=latest)](https://xenapi.readthedocs.io/en/latest/?badge=latest)

[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/powered-by-oxygen.svg)](https://forthebadge.com)

### This is a simple Xenforo API for Java and PHP.
-----

## Summary
* [XenAPI for Xenforo 2.X](#xenapi-for-xenforo-2x)
* [Downloads & Repo](#downloads--repo)
* [Documentation](#documentation)
* [Bug Reporting](#bug-reporting)
* [Contributing](#contributing)
* [Instalation](#installation)
* [Usage & API Key](#usage--api-key)
  - [For PHP](#for-php)
  - [For Java](#for-java)
* [Dependencies](#dependencies)
* [Bug Reporting](#bug-reporting)
* [License & Copyright](#license--copyright)
* [Donations](#donations)
* [TODO](#todo)
  - [TODO Docs](#todo-docs)
-----

## XenAPI for Xenforo 2.X
This repo contains the Java and the Web API for Xenforo 1.X.

A Java version for Xenforo 2.X is being developed, but I recommend you to use [this](https://xfrocks.com/resources/bd-api-for-xenforo-2-0.36/) for the WebAPI.

## Downloads & Repo
All downloads are hosted in [Github](https://github.com/cadox8/XenAPI/releases).

For the Java-API, you can add it on Maven:

```xml
    <repositories>
        <repository>
            <id>XenAPI Repo</id>
            <url>https://cadox8.github.io/repo/</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>me.cadox8</groupId>
            <artifactId>XenAPI</artifactId>
            <version>RELEASE</version>
        </dependency>
    </dependencies>
```

**NOTE:** You can use ``RELEASE`` as version or you can use the version number (you can check all versions [here](https://github.com/cadox8/XenAPI/releases))

## Documentation
**Web-API & Java-API:** You can get the documentation [here](https://xenapi.readthedocs.io/en/latest/).<br>
**Javadocs:** You can check the Javadocs [here](https://cadox8.github.io/XenAPI/javadocs).

## Bug Reporting
You can create an issue here on GitHub to report a bug with the API or to suggest enhancements.

## Contributing
If you want to contribute to the project, you must accept and follow our [Code Of Conduct](CODE_OF_CONDUCT.md) and our [guides for contributing](CONTRIBUTING.md).

## Instalation
The api.php goes in the root folder of the XenForo installation.

Then, you will need to [Set an API Key](#usage--api-key)

## Usage & API Key

**NOTE:** I recomend a Version 4 UUID for the API Key (really recomended). You can generate one [here](https://www.uuidgenerator.net).

### For PHP
To run change the API key by replace the ``xenapi`` with your desired API key (UUID).
```javascript
$restAPI = new RestAPI('NEW_API_KEY');
```

or send hash in format: ``username:hash`` , where hash is result authenticate action.

### For Java
**You need to set the new API Key in PHP before doing this!**

```java
XenAPI api = new XenAPI("YOUR_API_KEY"); // Setted in api.php
api.setBaseURL("YOUR_FORUM_URL"); // Must be http(s)://link.extension or http(s)://ip
```

Then, you will use that Key in the program.

## Dependencies
The XenAPI (Java) has the following dependencies:
* [Google Gson library](https://mvnrepository.com/artifact/com.google.code.gson/gson)
* [Project Lombok](https://projectlombok.org)
* [Apache HttpClient](https://hc.apache.org)

## License & Copyright
XenAPI is licensed under [GNU LESSER GENERAL PUBLIC LICENSE Version 3](LICENSE.txt).

The logo and some parts of the PHP Code is property of [Contex](https://github.com/Contex/XenAPI).

Cadox8 updated the code and created the Java API.

[Contex](https://github.com/Contex) © 2012-2014<br>
[Cadox8](https://cadox8.github.io) © 2018


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI?ref=badge_large)

## Donations
Building an Open Source Project is hard. You have to invert time and resources. And you won't be paid for that, that's why I'm putting a donation link here. :money_with_wings: :money_with_wings:

If you appreciate my work and want to help me maintaining this or other projects, you can donate me through [PayPal](https://paypal.me/Cadox8) or you can just [Buy Me a Coffee](https://ko-fi.com/devcadox).

## TODO
* [x] Add a proper copyright header to all files.
* [ ] Deploy to a public maven repo.
* [ ] Update to Xenforo 2.0
* [ ] Better and more documentation
* [ ] Build a full Java-api
* [x] Feed the Cat

### TODO Docs
* [x] Authenticate
* [x] Create Alert
* [x] Create Conversation
* [x] Create Conversation Reply
* [x] Create Post
* [ ] Create Profile Post
* [ ] Create Profile Post Reply
* [x] Create Thread
* [x] Delete Post
* [ ] Delete User
* [ ] Downgrade User
* [ ] Edit Post
* [ ] Edit Thread
* [x] Edit User
* [x] Get Actions
* [x] Get Addon
* [x] Get Addons
* [x] Get Alerts
* [x] Get Avatar
* [ ] Get Conversation
* [ ] Get Conversations
* [ ] Get Group
* [ ] Get Node
* [ ] Get Nodes
* [ ] Get Post
* [ ] Get Posts
* [ ] Get Profile Post
* [ ] Get Profile Posts
* [ ] Get Resource
* [ ] Get Resources
* [ ] Get Resource Categories
* [x] Get Stats
* [ ] Get Thread
* [ ] Get Threads
* [x] Get User
* [ ] Get Users
* [ ] Get User Upgrade
* [ ] Get User Upgrades
* [x] Login
* [x] Logout
* [ ] Register
* [ ] Search
* [ ] Search Threads
* [ ] Upgrade User
* [ ] Get Unread Posts
* [ ] Edit User Mod
