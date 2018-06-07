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
api.php?action=getAvatar&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAvatar&size=M&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAvatar&value=Test&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAvatar&value=cadox8&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
```php
api.php?action=getAvatar&value=cadox8&size=M&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```

#### Reply
```json
{
  "avatar":"http:\/\/192.168.1.2\/foro\/data\/avatars\/m\/0\/1.jpg?152768795"
}
```
