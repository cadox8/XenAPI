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

package es.cadox8.xenapi.api.posts;

import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
public class VotePost implements ApiRequest<VotePostResponse> {

    /**
     * Required
     */
    private final int id;
    /**
     * Required
     * <p>
     * Type of vote, "up" or "down". Use the current type to undo.
     */
    private final VoteAction vote;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.POST_VOTE;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Object query() {
        return this.id;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        if (this.vote == null)
            throw new XenForoMissingArgsException("vote");

        return List.of(new XenNameValuePair("type", this.vote.getVote()));
    }

    @Override
    public Class<VotePostResponse> response() {
        return VotePostResponse.class;
    }

    @RequiredArgsConstructor
    @Getter
    public enum VoteAction {
        UP("up"),
        DOWN("down");

        private final String vote;
    }
}
