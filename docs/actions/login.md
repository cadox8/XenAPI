*[<- Go Back](../rest-api.md)*

### Login
Authenticates the user and returns the hash that the user has to use for future requests.


| Action | Version | Supported |
| :-: | :-: | :-: |
| login | 1.5 | - |

#### Error Codes

| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “username” parameter was set but empty |
| 1 | The “password” parameter was set but empty |
| 1 | The “ip_address” parameter was set but empty |
| 3 | The “username” parameter was not set |
| 3 | The “passsword” parameter was not set |
| 3 | The “ip_address” parameter was not set |
| 4 | The “username” parameter is not a registered user |
| 5 | Wrong username or password |

#### Request
```php
api.php?action=authenticate&username=USERNAME&password=PASSWORD&ip_address=IP_ADDRESS
```
```php
api.php?action=authenticate&username=USERNAME&password=PASSWORD
```
#### Example
```php
api.php?action=authenticate&username=cadox8&password=password&ip_address=127.0.0.1
```
```php
api.php?action=authenticate&username=cadox8&password=password
```
#### Reply
```json
{
  "hash": "JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2"
}
```
