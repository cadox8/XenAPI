*[<- Go Back](../rest-api.md)*

### Creates Conversation Reply
Creates a conversation reply as the specified user

| Action | Version | Supported |
| :-: | :-: | :-: |
| createConversationReply | 1.4 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |

#### Required Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| conversation_id | The conversation ID | 2 |
| message | The message of the conversation | Lorem ipsum dolor[...] |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 19 | Could not find the conversation |


#### Request
```php
api.php?action=createConversationReply&conversation_id=ID&message=MESSAGE&grab_as=USERNAME&hash=API_KEY
```
```php
api.php?action=createConversationReply&conversation_id=ID&message=MESSAGE&hash=USER:HASH
```
#### Example
```php
api.php?action=createConversationReply&conversation_id=2&message=Good Bye&hash=cadox8:JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2
```
```php
api.php?action=createConversationReply&conversation_id=2&message=Good Bye&grab_as=test&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
   "conversation_id":2,
   "user_id":2,
   "username":"test",
   "message":"Good Bye",
   "message_date":1528360836,
   "attach_count":0,
   "ip_id":17,
   "message_id":4
}
```
