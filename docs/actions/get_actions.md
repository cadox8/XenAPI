

### Get Actions
Returns a list of all the available actions and their permission levels.

| Action | Version | Supported |
| :-: | :-: | :-: |
| getActions | 1.0 | <a href="#per">performance</a> |

#### Request
```php
api.php?action=getActions
```

#### Reply
```json
{
   "authenticate":"public",
   "createalert":"api_key",
   "createconversation":"authenticated",
   "createconversationreply":"authenticated",
   "createpost":"authenticated",
   "createprofilepost":"authenticated",
   "createprofilepostcomment":"authenticated",
   "createthread":"authenticated",
   "deletepost":"authenticated",
   "deleteuser":"authenticated",
   "downgradeuser":"api_key",
   "editpost":"authenticated",
   "editthread":"authenticated",
   "edituser":"api_key",
   "getactions":"public",
   "getaddon":"administrator",
   "getaddons":"administrator",
   "getalerts":"private",
   "getavatar":"public",
   "getconversation":"private",
   "getconversations":"private",
   "getgroup":"public",
   "getnode":"public",
   "getnodes":"public",
   "getpost":"public",
   "getposts":"public",
   "getprofilepost":"authenticated",
   "getprofileposts":"authenticated",
   "getresource":"administrator",
   "getresources":"administrator",
   "getresourcecategories":"administrator",
   "getstats":"public",
   "getthread":"public",
   "getthreads":"public",
   "getuser":"authenticated",
   "getusers":"public",
   "getuserupgrade":"api_key",
   "getuserupgrades":"api_key",
   "login":"public",
   "logout":"public",
   "register":"api_key",
   "search":"public",
   "upgradeuser":"api_key"
}
```
