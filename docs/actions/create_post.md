

### Create Post
Creates a new post as the specified user (Replies to a existing post)

| Action | Version | Supported |
| :-: | :-: | :-: |
| createPost | 1.4 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |


#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “grab_as” parameter was set but empty |
| 1 | The “thread_id” parameter was set but empty |
| 1 | The “message” parameter was set but empty |
| 3 | The “grab_as” parameter was not set |
| 3 | The “thread_id” parameter was not set |
| 3 | The “message” parameter was not set |
| 14 | The user does not have permissions to post in this thread |
| 19 | Could not find the “thread_id” |

#### Required Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| message | What to say in the post | Lorem ipsum dolor[...] |
| thread_id | The ID of the Thread | 1 |


#### Request
```php
api.php?action=createPost&thread_id=THREAD_ID&message=MESSAGE&grab_as=USERNAME&hash=API_KEY
```
#### Example
```php
api.php?action=createPost&thread_id=1&message=This%20is%20a%20test&grab_as=cadox8&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "user_id":1,
   "username":"cadox8",
   "message":"This is a test",
   "message_state":"visible",
   "thread_id":1,
   "post_date":1528207218,
   "position":1,
   "last_edit_user_id":0,
   "ip_id":13,
   "attach_count":0,
   "likes":0,
   "like_users":"a:0:{}",
   "warning_id":0,
   "warning_message":"",
   "last_edit_date":0,
   "edit_count":0,
   "post_id":2
}
```
