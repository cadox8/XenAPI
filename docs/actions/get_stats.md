

### Get Stats
Returns a list of relevant stats items

| Action | Version | Supported |
| :-: | :-: | :-: |
| getStats | 1.3 | <a href="#per">performance</a> |

#### Request
```php
api.php?action=getStats
```
```php
api.php?action=getStats&hash=API_KEY
```
```php
api.php?action=getStats&hash=USER:HASH
```

### Examples
```php
api.php?action=getStats
```
```php
api.php?action=getStats&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```

#### Reply
```json
{
   "threads":2,
   "posts":3,
   "conversations":3,
   "conversations_messages":4,
   "members":2,
   "latest_member":{
      "user_id":2,
      "username":"test"
   },
   "registrations_today":0,
   "threads_today":0,
   "posts_today":0,
   "users_online":1
}
```
