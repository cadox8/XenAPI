*[<- Go Back](../rest-api.md)*

### Get Addons
Returns all the installed addons, if type is not specified, default (all) is used instead.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getAddons | 1.2 | <a href="#per">performance</a> |

#### Aditional Parameters

| Parameter value | Description |
| :-: | :-: |
| all | This is default, and will return all the addons, ignoring if they are installed or not. |
| enabled | Fetches all the addons that are enabled, ignoring the disabled ones. |
| disabled | Fetches all the addons that are disabled, ignoring the enabled ones. |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “type” parameter was set but empty |
| 3 | The “hash” parameter was an API key but the “type” parameter was not set |

#### Requests
```php
api.php?action=getAddons&hash=USERNAME:HASH
```
```php
api.php?action=getAddons&hash=API_KEY
```
```php
api.php?action=getAddons&type=TYPE&hash=USERNAME:HASH
```
```php
api.php?action=getAddons&type=TYPE&hash=API_KEY
```
#### Examples
```php
api.php?action=getAddons&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAddons&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
```php
api.php?action=getAddons&type=enabled&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAddons&type=enabled&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
  "count": 3,
  "addons": [
    {
      "id": "xenCODE_KeywordsMeta",
      "title": "'Keywords' Meta Tag by xenCODE",
      "version": "1.0.0",
      "enabled": true,
      "url": "http:\/\/xenforo.com\/community\/resources\/authors\/mr-goodie2shoes.11736\/"
    },
    {
      "id": "8thos_bar_flex",
      "title": "8thos Bar for Flexile",
      "version": "1.5",
      "enabled": true,
      "url": ""
    },
    {
      "id": "RichUsernameEverywhere",
      "title": "Add Username Style to Last Post",
      "version": "1.0.1",
      "enabled": true,
      "url": "http:\/\/www.madnaoki.com"
    }
  ]
}
```
