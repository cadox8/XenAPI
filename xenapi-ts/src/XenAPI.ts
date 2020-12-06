import {AxiosStatic} from 'axios';
import {Error} from "./response/Error";
import {User} from "./response/User";
import {Users} from "./response/Users";
const axios = require('axios').default;

export class XenAPI {

    private readonly url: string;
    private readonly api_key: string;
    private readonly user_id: number;

    private readonly bypass: boolean;

    private readonly axios: AxiosStatic;

    /**
     * Default XenAPI constructor.
     *
     * @param url The forum url (https://forum.com/api)
     * @param api_key Generated API Key from Forum Dashboard
     * @param user_id The user_id from who is generating the Api Key
     * @param bypass To bypass all restrictions (only if super_admin)
     */
    constructor(url: string, api_key: string, user_id: number, bypass: boolean = false) {
        this.url = url;
        this.api_key = api_key;
        this.user_id = user_id;
        this.bypass = bypass;

        this.axios = axios.create({
            baseURL: this.url,
            timeout: 5000,
            headers: {
                'Content-Type': 'x-www-form-urlencoded',
                'XF-Api-Key': this.api_key,
                'XF-Api-User': this.user_id
            }
        });
    }

    /**
     * Gets all users from the forum
     *
     * @param params The list 'page'. If not set it will be 1. Wrong value = Error
     *
     * @see Users
     * @see Error
     */
    public async users(params?: { page: number }): Promise<Users | Error> {
        return await this.get('/users', params);
    };

    /**
     * Gets an user from the forum
     *
     * @param id The user ID to search
     * @param params The list 'page'. If not set it will be 1. Wrong value = Error. 'with_posts' searchs user with posts. False by default
     *
     * @see User
     * @see Error
     */
    public async user(id: number, params?: { with_posts: boolean, page: number }): Promise<User | Error> {
        return await this.get('/users/' + id, params);
    };




    private async get(url: string, params: any): Promise<Error | any> {
        if (this.bypass) params.api_bypass_permissions = 1;
        return new Promise(async (data, err) => {
            try {
                const result: any = await this.axios.get(url, { params: params });
                data(result.data);
            } catch (error) {
                err(error);
            }
        });
    }
}