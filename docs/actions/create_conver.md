

### Creates Conversation
Creates a conversation as the specified user

| Action | Version | Supported |
| :-: | :-: | :-: |
| createConversation | 1.4 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |

#### Required Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| recipients | The users to talk to | test,wikijito7 |
| title | The title of the conversation | Hello friends |
| message | The message of the conversation | Lorem ipsum dolor[...] |

### Additional Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| open_invite | If anyone can invite to join | 0 |
| conversation_locked | If you can answer | 0 |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “grab_as” parameter was set but empty |
| 3 | The “grab_as” parameter was not set |
| 4 | The “user” parameter was not a valid user (not registered) |


#### Request
```php
api.php?action=createConversation&recipients=USERS&title=TITLE&message=MESSAGE&grab_as=USERNAME&hash=API_KEY
```
```php
api.php?action=createConversation&recipients=USERS&title=TITLE&message=MESSAGE&hash=USER:HASH
```
#### Example
```php
api.php?action=createConversation&recipients=test&title=Test&message=Hello&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=createConversation&recipients=test&title=Test&message=Hello&grab_as=cadox8&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "user_id":1,
   "username":"cadox8",
   "title":"Test",
   "open_invite":0,
   "conversation_open":1,
   "recipients":"a:1:{i:2;a:2:{s:7:\"user_id\";i:2;s:8:\"username\";s:4:\"test\";}}",
   "start_date":1528360388,
   "last_message_date":1528360388,
   "last_message_user_id":1,
   "last_message_username":"cadox8",
   "reply_count":0,
   "recipient_count":0,
   "first_message_id":2,
   "last_message_id":2,
   "conversation_id":2
}
```
