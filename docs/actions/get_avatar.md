*[<- Go Back](../rest-api.md)*

### Get Avatar
Returns the avatar of user specified by the “value” parameter, if size is not specified or unknown, default (medium) is used instead.

**NOTE:**
> Only usernames, user ID’s and e-mails can be used for the “value” parameter.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getAvatar | 1.0 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |

#### Aditional Parameters

| Parameter value | Description |
| :-: | :-: |
| s | Small avatar (48px * 48px) |
| m | Medium avatar (96px * 96px) |
| l | Large avatar (192px * 192px) |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “value” parameter was set but empty |
| 1 | The “size” parameter was set but empty |
| 3 | Neither of the “value” and “hash” parameters were set |
| 4 | The “value” parameter is not a registered user |

#### Requests
```php
api.php?action=getAvatar&hash=USERNAME:HASH
```
```php
api.php?action=getAvatar&size=SIZE&hash=USERNAME:HASH
```
```php
api.php?action=getAvatar&value=USERNAME&hash=USERNAME:HASH
```
```php
api.php?action=getAvatar&value=USERNAME&hash=API_KEY
```
```php
api.php?action=getAvatar&value=USERNAME&size=SIZE&hash=USERNAME:HASH
```
```php
api.php?action=getAvatar&value=USERNAME&size=SIZE&hash=API_KEY
```
#### Examples
```php
api.php?action=getAvatar&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15dc15b0f00a08
```
```php
api.php?action=getAvatar&size=M&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAvatar&value=Contex&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAvatar&value=Contex&hash=d8e8fca2dc0f896fd7cb4cb0031ba249
```
```php
api.php?action=getAvatar&value=Contex&size=M&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAvatar&value=Contex&size=M&hash=d8e8fca2dc0f896fd7cb4cb0031ba249
```

#### Reply
```json
{
  "avatar":"http:\/\/192.168.1.2\/foro\/data\/avatars\/m\/0\/1.jpg?152768795"
}
```
