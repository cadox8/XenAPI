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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.conversation.ConversationCreate;
import lombok.Builder;
import lombok.NonNull;

import java.util.Arrays;

@Builder
public class ConversationCreateParams {

    @NonNull private final Integer[] recipients;
    @NonNull private final String title;
    @NonNull private final String message;

    private final String attachmentKey;
    private final boolean open;
    private final boolean invite;

    public String body() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject body = new JsonObject();

        final JsonArray recipientsArray = new JsonArray();
        Arrays.asList(this.recipients).forEach(recipientsArray::add);
        body.add("recipient_ids", recipientsArray);

        body.addProperty("title", this.title);
        body.addProperty("message", this.message);

        if (!this.attachmentKey.isEmpty())
            body.addProperty("attachment_key", this.attachmentKey);
        if (this.open)
            body.addProperty("conversation_open", true);
        if (this.invite)
            body.addProperty("open_invite", true);

        return gson.toJson(body);
    }

    public Class<ConversationCreate> getType() {
        return ConversationCreate.class;
    }
}
