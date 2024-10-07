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

package es.cadox8.xenapi.params.conversation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.conversation.ConversationMessages;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ConversationMsgsParams {

    /**
     * Required
     */
    @NonNull private final int conversationId;
    /**
     * Required
     */
    @NonNull private final String message;

    private final String attachment_key;

    public String body() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject body = new JsonObject();

        body.addProperty("conversationId", conversationId);
        body.addProperty("message", message);

        if (!this.attachment_key.isEmpty())
            body.addProperty("attachment_key", this.attachment_key);

        return gson.toJson(body);
    }

    public Class<ConversationMessages> type() {
        return ConversationMessages.class;
    }
}
