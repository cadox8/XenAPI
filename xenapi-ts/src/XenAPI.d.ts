import {Users} from "./response/Users";
import {Error} from "./response/Error";
import {User} from "./response/User";

declare module "XenAPI" {
    class XenAPI {

        /**
         * Default XenAPI constructor.
         *
         * @param url The forum url (https://forum.com/api)
         * @param api_key Generated API Key from Forum Dashboard
         * @param user_id The user_id from who is generating the Api Key
         * @param bypass To bypass all restrictions (only if super_admin)
         */
        constructor(url: string, api_key: string, user_id: number, bypass: boolean);

        /**
         * Gets all users from the forum
         *
         * @param params The list 'page'. If not set it will be 1. Wrong value = Error
         *
         * @see Users
         * @see Error
         */
        public users(params?: { page: number }): Promise<Users | Error>;

        /**
         * Gets an user from the forum
         *
         * @param id The user ID to search
         * @param params The list 'page'. If not set it will be 1. Wrong value = Error. 'with_posts' searchs user with posts. False by default
         *
         * @see User
         * @see Error
         */
        public user(id: number, params?: { with_posts: boolean, page: number }): Promise<User | Error>;
    }
}