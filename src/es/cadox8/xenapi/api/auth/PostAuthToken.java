/*
 * Copyright (c) 2025
 *
 * This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 * XenAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XenAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you have any question feel free to ask at <https://cadox8.es> or <mailto:cadox8@gmail.com>
 */

package es.cadox8.xenapi.api.auth;

import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenNameValuePair;
import es.cadox8.xenapi.utils.XenforoPaths;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class PostAuthToken implements ApiRequest<AuthTokenResponse> {

    private final Integer userId;
    private final String limitIP;
    private final String returnUrl;
    private final Boolean force;
    @Builder.Default private final Boolean remember = true;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.LOGIN_TOKEN;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Object query() {
        return null;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.userId == null)
            throw new XenForoMissingArgsException("userId");

        if (this.limitIP != null && !this.limitIP.isEmpty())
            list.add(new XenNameValuePair("limit_ip", this.limitIP));

        if (this.returnUrl != null && !this.returnUrl.isEmpty())
            list.add(new XenNameValuePair("return_url", this.returnUrl));

        if (this.force != null)
            list.add(new XenNameValuePair("force", this.force));

        list.add(new XenNameValuePair("remember", this.remember));

        return list;
    }

    @Override
    public Class<AuthTokenResponse> response() {
        return AuthTokenResponse.class;
    }
}
