/*
 * Copyright (c) 2024
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

package es.cadox8.xenapi.params.alerts;

import es.cadox8.xenapi.api.alerts.Alerts;
import lombok.Builder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

@Builder
public class AlertsParams {

    private final int page;
    private final int cutoff;
    private final boolean unviewed;
    private final boolean unread;

    public NameValuePair[] params() {
        final NameValuePair[] params = new NameValuePair[4];

        if (this.cutoff > 0)
            params[0] = new BasicNameValuePair("cutoff", String.valueOf(cutoff));

        if (this.page > 0)
            params[1] = new BasicNameValuePair("page", String.valueOf(this.page));

        if (this.unviewed)
            params[2] = new BasicNameValuePair("unviewed", String.valueOf(this.unviewed));

        if (this.unread)
            params[3] = new BasicNameValuePair("unread", String.valueOf(this.unread));

        return params;
    }

    public Class<Alerts> type() {
        return Alerts.class;
    }
}
