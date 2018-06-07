*[<- Go Back](../rest-api.md)*

### Delete Post
Deletes a post as the specified user.

| Action | Version | Supported |
| :-: | :-: | :-: |
| deletePost | 1.4 | <a href="#per">performance</a> |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “post_id” parameter was set but empty |
| 1 | The “reason” parameter was set but empty |
| 3 | The “post_id” parameters was not set |
| 19 | Could not find the post |

#### Requests
```php
api.php?action=deletePost&post_id=ID&hash=USERNAME:HASH
```
```php
api.php?action=deletePost&post_id=ID&reason=REASON&hash=USERNAME:HASH
```
```php
api.php?action=deletePost&post_id=ID&reason=REASON&hash=API_KEY
```
```php
api.php?action=deletePost&post_id=ID&hash=API_KEY
```

#### Examples
```php
api.php?action=deletePost&post_id=2&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=deletePost&post_id=2&reason=Testing&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=deletePost&post_id=2&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
```php
api.php?action=deletePost&post_id=2&reason=Testing&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "post_id":2,
   "thread_id":1,
   "user_id":1,
   "username":"cadox8",
   "post_date":1528207218,
   "message":"This is a test",
   "ip_id":13,
   "message_state":"deleted",
   "attach_count":0,
   "position":1,
   "likes":0,
   "like_users":"a:0:{}",
   "warning_id":0,
   "warning_message":"",
   "last_edit_date":0,
   "last_edit_user_id":0,
   "edit_count":0,
   "message_html":"This is a test",
   "absolute_url":"http:\/\/192.168.1.2\/foro\/index.php?posts\/2\/"
}
```
