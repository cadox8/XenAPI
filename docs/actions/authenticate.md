*[<- Go Back](../rest-api.md)*

### Authenticate
Authenticates the user and returns the hash that the user has to use for future requests.


| Action | Version | Supported |
| :-: | :-: | :-: |
| authenticate | 1.0 | <a href="#per">performance</a> |

#### Error Codes
| ErrorID | Cause of Error | test |
| :-: | :-: | :-: |
| 1 | The “username” parameter was set but empty | t |
| 1 | The “password” parameter was set but empty | t |
| 3 | The “username” parameter was not set | t |
| 3 | The passsword parameter was not set | t |
| 4 | The “username” parameter is not a registered user | t |
| 5 | Wrong username or password | t |

#### Request
```php
api.php?action=authenticate&username=USERNAME&password=PASSWORD
```
#### Example
```php
api.php?action=authenticate&username=cadox8&password=password
```

#### Reply
```json
{
  "hash": "JDJhJDEwJEd4U2xRQUNNTVJnTzFOM282anZYd08wRk1DTC52NFJtYWtDVHZaNHo1SUZvR0hzUVpLTkU2"
}
```
