

### Get Alerts
Grabs the alerts from the specified user, if type is not specified, default (recent alerts) is used instead.

**NOTE:**
>The “value” parameter will only work for the user itself and not on others users unless the permission parameter for the “getalerts” action is changed (default permission: private).

| Action | Version | Supported |
| :-: | :-: | :-: |
| getAlerts | 1.1 | <a href="#per">performance</a>, <a href="#grab">grab_as</a> |

#### Aditional Parameters

| Parameter value | Description |
| :-: | :-: |
| fetchPopupItems | Fetch alerts viewed in the last options:alertsPopupExpiryHours hours. |
| fetchRecent | Fetch alerts viewed in the last options:alertExpiryDays days. |
| fetchAll | Fetch alerts regardless of their view_date. |

For more information, see /library/XenForo/Model/Alert.php.

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “value” parameter was set but empty |
| 1 | The “type” parameter was set but empty |
| 3 | Neither of the “value” and “hash” parameters were set |
| 3 | The “hash” parameter was an API key but the “value” parameter was not set |
| 4 | The “value” parameter was not a valid user (not registered) |

#### Requests
```php
api.php?action=getAlerts&hash=USERNAME:HASH
```
```php
api.php?action=getAlerts&type=fetchAll&hash=USERNAME:HASH
```
```php
api.php?action=getAlerts&value=USERNAME&hash=USERNAME:HASH
```
```php
api.php?action=getAlerts&value=USERNAME&type=fetchAll&hash=USERNAME:HASH
```
```php
api.php?action=getAlerts&value=USERNAME&hash=API_KEY
```
```php
api.php?action=getAlerts&value=USERNAME&type=fetchAll&hash=API_KEY
```
#### Examples
```php
api.php?action=getAlerts&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAlerts&type=fetchAll&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAlerts&value=JohnDoe&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAlerts&value=JohnDoe&type=fetchAll&hash=Contex:9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
```
```php
api.php?action=getAlerts&value=JohnDoe&hash=d8e8fca2dc0f896fd7cb4cb0031ba249
```
```php
api.php?action=getAlerts&value=JohnDoe&type=fetchAll&hash=d8e8fca2dc0f896fd7cb4cb0031ba249
```
```java
public class Xen {
    public static void main(String... args) {
        final XenAPI api = new XenAPI("e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10", "http://localhost/forum");

        final Request r = RequestBuilder.newRequest(RequestType.GET_ALERTS).addParam(RequestParam.VALUE_STRING, "cadox8").addParam(RequestParam.TYPE_STRING, "fetchAll").createRequest();

        api.getReply(r, (Callback<AlertsReply>) (failCause, result) -> {
            try {
                result.checkError();
                if (failCause != null) failCause.printStackTrace();
                System.out.println("Result: " + result.toString());
            } catch (ArgsErrorException e) {
                e.printStackTrace();
            }
        });
    }
}
```
#### Reply
```json
{
   "alerts":{
      "563926":{
         "alert_id":563926,
         "alerted_user_id":1,
         "content_type":"user",
         "content_id":1,
         "action":"following",
         "event_date":1359927097,
         "view_date":0,
         "extra_data":"",
         "alert_handler_class":"XenForo_AlertHandler_User",
         "content":{
            "user_id":1,
            "username":"cadox8",
            "email":"cadox8@gmail.com",
            "gender":"",
            "custom_title":"",
            "language_id":1,
            "style_id":8,
            "timezone":"Europe\/Madrid",
            "visible":1,
            "user_group_id":3,
            "secondary_group_ids":"2,4,7",
            "display_style_group_id":3,
            "permission_combination_id":45,
            "message_count":135,
            "conversations_unread":0,
            "register_date":1308798946,
            "last_activity":1359841741,
            "trophy_points":28,
            "alerts_unread":1,
            "avatar_date":1340917178,
            "avatar_width":90,
            "avatar_height":90,
            "gravatar":"",
            "user_state":"valid",
            "is_moderator":1,
            "is_admin":1,
            "is_banned":0,
            "like_count":47,
            "warning_points":0,
            "mood_id":70,
            "friend_count":0,
            "personal_friend_count":0
         },
         "user":{
            "user_id":7252,
            "username":"Jane Doe",
            "gender":"female",
            "gravatar":"",
            "avatar_date":1359926902
         },
         "new":true,
         "unviewed":true
      }
   },
   "alertHandlers":{
      "XenForo_AlertHandler_User":{

      }
   }
}
```
