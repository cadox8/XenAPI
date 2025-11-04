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

package es.cadox8.xenapi.api.forums;

import es.cadox8.xenapi.api.commons.Order;
import es.cadox8.xenapi.api.commons.Sort;
import es.cadox8.xenapi.api.commons.TypeNodeId;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenNameValuePair;
import es.cadox8.xenapi.utils.XenforoPaths;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class GetForumById implements ApiRequest<Forums> {

    // Query
    private final Integer id;

    // Params (Should we send it in the body?)

    /**
     * If true, gets a page of threads in this forum
     */
    private final Boolean withThreads;
    private final Integer page;
    /**
     * Filters to only threads with the specified prefix.
     */
    private final Integer prefixId;
    /**
     * Filters to only threads started by the specified user ID.
     */
    private final Integer starterId;
    /**
     * Filters to threads that have had a reply in the last X days.
     */
    private final Integer lastDays;
    /**
     * Filters to unread threads only. Ignored for guests.
     */
    private final Boolean unread;
    /**
     * Filters to threads of the specified thread type.
     */
    private final TypeNodeId threadType;
    /**
     * Method of ordering: last_post_date, post_date. When in a specific forum context: title, reply_count, view_count, vote_score, first_post_reaction_score.
     */
    private final Order order;
    /**
     * Either "asc" or "desc" for ascending or descending. Applies only if an order is provided.
     */
    private final Sort direction;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.FORUMS;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public Object query() {
        if (this.id == null)
            throw new XenForoMissingArgsException("forumId");
        return this.id;
    }

    @Override
    public List<XenNameValuePair> params() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.withThreads != null)
            list.add(new XenNameValuePair("with_threads", this.withThreads));

        if (this.page != null)
            list.add(new XenNameValuePair("page", this.page));

        if (this.prefixId != null)
            list.add(new XenNameValuePair("prefix_id", this.prefixId));

        if (this.starterId != null)
            list.add(new XenNameValuePair("starter_id", this.starterId));

        if (this.lastDays != null && this.lastDays > 0)
            list.add(new XenNameValuePair("last_days", this.lastDays));

        if (this.unread != null)
            list.add(new XenNameValuePair("unread", this.unread));

        if (this.threadType != null)
            list.add(new XenNameValuePair("thread_type", this.threadType.getNodeType()));

        if (this.order != null) {
            list.add(new XenNameValuePair("order", this.order.getOrder()));

            if (this.direction != null)
                list.add(new XenNameValuePair("direction", this.direction.getDirection()));
        }

        return list;
    }

    @Override
    public List<XenNameValuePair> body() {
        return List.of();
    }

    @Override
    public Class<Forums> response() {
        return Forums.class;
    }
}
