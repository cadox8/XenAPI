

### Create Alert
Creates an alert for the specified user.

| Action | Version | Supported |
| :-: | :-: | :-: |
| createAlert | 1.4 | <a href="#per">performance</a> |

#### Required Parameters

| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| user | The user from | cadox8 |
| cause_user | The user to send the alert | Wikijito7 |
| content_type | Type of alert | user |
| content_id | Content ID | 1 |
| alert_action | Type of alert | warning(?) |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “user” parameter was set but empty |
| 1 | The “cause_user” parameter was set but empty |
| 1 | The “content_type” parameter was set but empty |
| 1 | The “content_id” parameter was set but empty |
| 1 | The “alert_action” parameter was set but empty |
| 3 | The “user” parameter was not set |
| 3 | The “cause_user” parameter was not set |
| 3 | The “content_type” parameter was not set |
| 3 | The “content_id” parameter was not set |
| 3 | The “alert_action” parameter was not set |
| 4 | The “user” parameter was not a valid user (not registered) |
| 4 | The “cause_user” parameter was not a valid user (not registered) |
| 13 | user is required to create an alert. |
| 13 | cause_user is required to create an alert. |


#### Request
```php
api.php?action=createAlert&user=USERNAME&cause_user=CAUSE_USER&content_type=USER&content_id=CONTENT_ID&alert_action=WARNING&hash=API_KEY
```
#### Example
```php
api.php?action=createAlert&user=cadox8&cause_user=test&content_type=user&content_id=1&alert_action=warning&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
  "content_type":"user",
  "content_id":"1",
  "action":"warning"
}
```
