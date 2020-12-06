/*
 *  Copyright (c) 2018.
 *
 *  This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 *  XenAPI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  XenAPI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.cadox8.xenapi.request;

import me.cadox8.xenapi.exceptions.ParamTypeException;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private RequestType requestType;
    private Map<RequestParam, Object> params = new HashMap<>();

    private RequestBuilder(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * Method used to create a new Request
     *
     * @param requestType The Type of the Request
     * @return A new instance of the builder
     *
     * @see RequestType
     */
    public static RequestBuilder newRequest(RequestType requestType) {
        return new RequestBuilder(requestType);
    }

    public RequestBuilder addParam(RequestParam param, Object value) {
        if (!validate(param, value)) throw new ParamTypeException(param, value);
        this.params.put(param, value);
        return this;
    }

    /**
     * Validate value for param, making sure it is of
     * the correct RequestParam type and
     * can be used for given RequestType
     */
    private boolean validate(RequestParam param, Object value) {
        if (value != null && value.getClass().equals(param.getValueClass())) {
            return param.getRequestsType().contains(requestType);
        }
        return false;
    }

    /**
     * Builds a request from the builder
     *
     * @return The Request
     */
    public Request createRequest() {
        return new Request(requestType, params);
    }

    /**
     * Builds a request from the builder with an username
     *
     * @param username to grab content as
     * @return The Request
     */
    public Request createRequest(String username) {
        return new Request(requestType, params).grab_as(username);
    }
}
