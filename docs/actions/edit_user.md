*[<- Go Back](../rest-api.md)*

### Edit User
Edit the specified user.

| Action | Version | Supported |
| :-: | :-: | :-: |
| editUser | 1.4 | <a href="#per">performance</a> |

**NOTES**
>Make sure this request is sent over a secure connection as you don’t want a MIM attack of the password (password is sent in plain text).

>This action also only works with an API key, any attempt on using this action without an API key will result in error id #10 being thrown.

>If no values are changed, user error id #3 will be thrown.

>The return response will depend on the values changed of the user.


#### Error Codes
| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “user” parameter was set but empty |
| 1 | The “user” parameter was set but empty |
| 3 | The “user” parameter was not set |
| 7 | The user edit failed |
| 10 | API key was not used |

#### Required Parameters
| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| user | The user to edit | cadox8 |

#### Additional Parameters
| Parameter Value | Description | Example |
| :-: | :-: | :-: |
| username | The new username | cadox |
| password | The new password | pa55word |
| email | The new email | cadox8@gmail.com |
| group | The new group | Administrator |
| gender | The new gender | male |
| custom_title | A new custom title | Developer |
| style_id | The new user style | 3 |
| timezone | The new timezone | Europe\Madrid |
| visible | If user is visible or not | 1 |
| dob_day | The date of birth day | 23 |
| dob_month | The date of birth month | 04 |
| dob_year | The date of birth year | 1999 |
| user_state | The user state | valid |
| custom_fields | The custom field(s) and value | field_1=value_1,field_2=value_2 |
| add_groups | Add the user to secondary group(s) | 5,6,9 |
| remove_groups | Remove user from group(s) | 5,9 |
| trophy_points | Amount of trophy points. | 7 |

#### Request
```php
api.php?action=editUser&user=USERNAME&FIELD=EDIT_VALUE&hash=API_KEY
```
#### Example
```php
api.php?action=editUser&user=cadox8&username=NewUsername&hash=e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10
```
#### Reply
```json
{
  "username":"NewUsername"
}
```
