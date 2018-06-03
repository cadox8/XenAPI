*[<- Go Back](../rest-api.md)*

### Get Conversations
Grabs the alerts from the specified user.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getConversations | 1.4 | <a href="#per">performance</a>, <a href="#limit">limit</a>, <a href="#grab">grab_as</a> |

#### Error Codes
| ErrorID | Cause of Error |
| :-: | :-: |
| 1 | The “value” parameter was set but empty |
| 1 | The “type” parameter was set but empty |
| 3 | Neither of the “value” and “hash” parameters were set |
| 3 | The “hash” parameter was an API key but the “value” parameter was not set |
| 4 | The “value” parameter was not a valid user (not registered) |
