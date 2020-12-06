import {User} from "./User";

export class Users {

    public readonly users: User[];
    public readonly pagination: { current_page: number, last_page: number, per_page: number, shown: number, total: number };
}