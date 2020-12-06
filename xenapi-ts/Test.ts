import {XenAPI} from "./src/XenAPI";
import {User} from "./src/response/User";
import {Error} from "./src/response/Error";

const xenApi: XenAPI = new XenAPI('https://6dc966c63171e358.demo-xenforo.com/222/api', '0FFbk9imkeB_SkU81p7Om4e_X-Tt6XjS', 1);
xenApi.user(1).then((value: User) => console.log(value)).catch((reason: Error) => console.log(reason));