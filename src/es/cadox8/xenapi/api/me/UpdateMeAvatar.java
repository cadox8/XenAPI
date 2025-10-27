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

package es.cadox8.xenapi.api.me;

import es.cadox8.xenapi.api.commons.Success;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Builder
public class UpdateMeAvatar implements ApiRequest<Success> {

    /**
     * Required
     */
    private final File avatar;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.ME_AVATAR;
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
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.avatar == null)
            throw new XenForoMissingArgsException("avatar");

        list.add(new XenNameValuePair("avatar", this.avatar));

        return list;
    }

    @Override
    public List<XenNameValuePair> body() {
        return new ArrayList<>();
    }

    @Override
    public Class<Success> response() {
        return Success.class;
    }

    @Override
    public boolean containsFile() {
        return true;
    }
}
