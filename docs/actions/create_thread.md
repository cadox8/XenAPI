

### Create Thread
Creates a new thread and first post as the specified user

| Action | Version | Supported |
| :-: | :-: | :-: |
| createThread | 1.4 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |


#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “grab_as” parameter was set but empty |
| 1 | The “node_id” parameter was set but empty |
| 1 | The “message” parameter was set but empty |
| 1 | The “title” parameter was set but empty |
| 3 | The “grab_as” parameter was not set |
| 3 | The “node_id” parameter was not set |
| 3 | The “message” parameter was not set |
| 3 | The “title” parameter was not set |
| 14 | The user does not have permissions to post in this thread |
| 19 | Could not find the “node_id” |
| 24 | Discussion state could not be found in the discussion state list |

#### Required Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| title | The title of the Thread | Test |
| message | What to say in the thread | Lorem ipsum dolor[...] |
| node_id | The ID of the Node | 1 |

### Additional Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| prefix_id | The prefix of the Thread | 1 |
| discussion_open | If the discussion is open or not | 1 |
| discussion_state | The state of the discussion | visible, moderated, deleted |
| sticky | Sticky thread? | 0 |

#### Request
```php
api.php?action=createThread&node_id=NODE_ID&title=TITLE&message=MESSAGE&grab_as=USERNAME&hash=API_KEY
```
#### Example
```php
api.php?action=createThread&node_id=2&title=Second%20Thread&message=Hello%20World&grab_as=cadox8&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "user_id":1,
   "username":"cadox8",
   "title":"Second Thread",
   "prefix_id":0,
   "node_id":2,
   "discussion_state":"visible",
   "post_date":1528207898,
   "last_post_date":1528207898,
   "last_post_user_id":1,
   "last_post_username":"cadox8",
   "reply_count":0,
   "view_count":0,
   "sticky":0,
   "discussion_open":1,
   "discussion_type":"",
   "first_post_id":3,
   "last_post_id":3,
   "tags":"a:0:{}",
   "first_post_likes":0,
   "thread_id":2
}
```
