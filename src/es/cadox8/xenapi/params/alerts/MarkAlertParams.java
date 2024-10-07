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

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.commons.Success;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import lombok.Builder;

@Builder
public class MarkAlertParams {

    private final int alertId;

    private final boolean read;
    private final boolean unread;
    private final boolean viewed;

    public String query() {
        this.valid();

        return String.valueOf(this.alertId);
    }

    public String body() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject body = new JsonObject();
        if (this.read)
            body.addProperty("read", true);
        if (this.viewed)
            body.addProperty("viewed", true);
        if (this.unread)
            body.addProperty("viewed", true);

        return gson.toJson(body);
    }

    private void valid() {
        final Validator<MarkAlertParams> val = ValidatorBuilder.<MarkAlertParams>of()._integer(x -> x.alertId, "alertId", c -> c.greaterThanOrEqual(1)).build();
        final ConstraintViolations violations = val.validate(this);

        if (!violations.isEmpty()) {
            final StringBuilder sb = new StringBuilder("An error occurred while validating: " + this.getClass().getSimpleName());
            sb.append('\n');
            violations.forEach(a -> sb.append(a.message()).append(" | "));
            sb.deleteCharAt(sb.length() - 2);
            throw new XenForoMissingArgsException(sb.toString());
        }
    }

    public Class<Success> type() {
        return Success.class;
    }
}
