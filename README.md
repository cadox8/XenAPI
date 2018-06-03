![Logo](docs/img/logo.png)

[![Build Status](https://travis-ci.org/cadox8/XenAPI.svg?branch=master)](https://travis-ci.org/cadox8/XenAPI)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI.svg?type=small)](https://app.fossa.io/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI?ref=badge_small)

[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/powered-by-oxygen.svg)](https://forthebadge.com)

### This is a simple Xenforo API for Java and PHP.
-----

## Downloads
All downloads are hosted in [Github](https://github.com/cadox8/XenAPI/releases).

## Documentation
**Web-API & Java-API:** You can get the documentation [here](https://cadox8.github.io/XenAPI).<br>
**Javadocs:** You can check the Javadocs [here](https://cadox8.github.io/XenAPI/javadocs).

## Instalation
The api.php goes in the root of the XenForo installation.

Then, you will need to **Obtain the API Key**

## Obtaining an API Key

**NOTE:** I recomend a Version 4 UUID for the API Key (really recomended). You can generate one [here](https://www.uuidgenerator.net).

### For PHP
To run change the API key by replace the ``xenapi`` with your desired API key (UUID).
```javascript
$restAPI = new RestAPI('NEW_API_KEY');
```

or send hash in format: username:hash, where hash is result authenticate action.

### For Java
Open api.php and change ``xenapi`` with your API Key (UUID).

```java
XenAPI api = new XenAPI();
api.setToken("NEW_API_KEY");
```

Then, you will use that Key in the program.

## Dependencies
The XenAPI has the following dependencies:
* [Google Gson library](https://mvnrepository.com/artifact/com.google.code.gson/gson)
* [Project Lombok](https://projectlombok.org)
* [Apache HttpClient](https://hc.apache.org)

## Bug Reporting
You can create an issue here on GitHub to report a bug with the API or to suggest enhancements.

## License & Copyright
XenAPI is licensed under [GNU LESSER GENERAL PUBLIC LICENSE Version 3](LICENSE.txt).

The logo and some parts of the PHP Code is property of [Contex](https://github.com/Contex/XenAPI).

I (cadox8) updated the code and created the Java API.

[Contex](https://github.com/Contex) © 2012-2014<br>
[Cadox8](https://cadox8.github.io) © 2018


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fcadox8%2FXenAPI?ref=badge_large)

## TODO
* [x] Add a proper copyright header to all files.
* [ ] Deploy to a public maven repo.
* [ ] Update to Xenforo 2.0
* [ ] Better and more documentation
* [ ] More functionalists
