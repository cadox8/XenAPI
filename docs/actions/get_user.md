*[<- Go Back](../rest-api.md)*

### Get User
Returns the avatar of user specified by the “value” parameter, if size is not specified or unknown, default (medium) is used instead.

**NOTE:**
> Only usernames, user ID’s and e-mails can be used for the “value” parameter.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getUser | 1.0 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “value” parameter was set but empty |
| 3 | Neither of the “value” and “hash” parameters were set |
| 4 | The “value” parameter is not a registered user |

#### Requests
```php
api.php?action=getUser&hash=USERNAME:HASH
```
```php
api.php?action=getUser&value=OTHER_USERNAME&hash=USERNAME:HASH
```
**NOTE:** ``value`` param can be filled with *username*, *email* and *user_id*
```php
api.php?action=getUser&value=OTHER_USERNAME&hash=API_KEY
```
**NOTE:** ``value`` param can be filled with *username*, *email* and *user_id*

#### Examples
```php
api.php?action=getUser&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getUser&value=Test&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=getUser&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
```php
api.php?action=getUser&value=xenapi@xenapi.net&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "user_id":1,
   "username":"cadox8",
   "email":"cadox8@gmail.com",
   "gender":"",
   "custom_title":"",
   "language_id":1,
   "style_id":0,
   "timezone":"Europe\/Madrid",
   "visible":1,
   "activity_visible":1,
   "user_group_id":2,
   "secondary_group_ids":"3,4",
   "display_style_group_id":3,
   "permission_combination_id":5,
   "message_count":3,
   "conversations_unread":0,
   "register_date":1526658172,
   "last_activity":1528207853,
   "trophy_points":1,
   "alerts_unread":0,
   "avatar_date":1527687953,
   "avatar_width":268,
   "avatar_height":192,
   "gravatar":"",
   "user_state":"valid",
   "is_moderator":1,
   "is_admin":1,
   "is_banned":0,
   "like_count":0,
   "warning_points":0,
   "is_staff":1,
   "privacy_policy_accepted":0,
   "terms_accepted":0,
   "custom_fields":[]
}
```
