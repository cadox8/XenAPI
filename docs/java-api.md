**NOTE:** You must have **XenAPI.jar** as dependency.

```xml
    <repositories>
        <repository>
            <id>XenAPI Repo</id>
            <url>https://cadox8.es/repo/</url>
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

For these examples I’m using these the following values:

| Type | Values |
| --- | --- |
| User Hash | JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2 |
| API Key | e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10 |

## Getting the API
First, you must have the new API Key setted in api.php and the file in Xenforo root.

In a new program, you have to instance the XenAPI class like this:
```java
final XenAPI api = new XenAPI("YOUR_API_KEY", "YOUR_FORUM_URL"); //I recommend to have a [Version 4 UUID](http://uuidgenerator.net) as the Key / Must have http:// | https://
```

With this, you will be able to send Requests and get the Reply 💃.

## Creating a Request
You will need to check the Actions and the Params first.

Example of Authentificate request
```java
final Request request = RequestBuilder.newBuilder(RequestType.AUTHENTICATE)
.addParam(RequestParam.AUTH_USER, "cadox8")
.addParam(RequestParam.AUTH_PASS, "password").createRequest();
```

The reply for this action will be a JSON text like:
```json
{"hash":"JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2"}
```

## Getting the Reply

But XenAPI has some classes to get the Reply. In this case, you will need to use ``AuthenticateReply``.
This is a example of how to get the reply (for > Java 1.8) and how to handle if we have an error code:

```java
api.getReply(r, (Callback<AuthenticateReply>) (failCause, result) -> {
    try {
        result.checkError();
        if (failCause != null) failCause.printStackTrace();
        System.out.println("Result: " + result.toString());
    } catch (ArgsErrorException e) {
        e.printStackTrace();
    }
});
```

As you can see, we have ``Callback<AuthenticateReply>`` which allows you to use the methods of these class. You will need to change the class between the ``< >`` when you change your RequestType.
