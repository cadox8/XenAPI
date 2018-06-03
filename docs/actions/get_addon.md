*[<- Go Back](../rest-api.md)*

### Get Addon
Returns any relevant addon information about the specified by the **“value”** parameter.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getAddon | 1.2 | <a href="#per">performance</a> |

#### Error Codes
| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “value” parameter was set but empty |
| 3 | Neither of the “value” and “hash” parameters were set |
| 4 | The “value” parameter is not installed |

#### Requests
```php
api.php?action=getAddon&value=ADDON_ID&hash=USERNAME:HASH
```
```php
api.php?action=getAddon&value=ADDON_ID&hash=API_KEY
```
#### Examples
```php
api.php?action=getAddon&value=PostRating&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getAddon&value=PostRating&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
  "id": "PostRating",
  "title": "Post Ratings",
  "version": "1.5.0",
  "enabled": true,
  "url": "http:\/\/xenforo.com\/community\/resources\/post-ratings-taking-likes-to-the-next-level.410\/"
}
```
