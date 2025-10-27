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

package es.cadox8.xenapi.api.conversation;

import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateConversation implements ApiRequest<ConversationCreateResponse> {

    private final List<Integer> recipient_ids;
    private final String title;
    private final String message;
    /**
     * API attachment key to upload files. Attachment key content type must be conversation_message with context[conversation_id] set to this conversation ID.
     */
    private final String attachment_key;
    private final boolean conversation_open;
    private final boolean open_invite;

    CreateConversation(List<Integer> recipient_ids, String title, String message, String attachment_key, boolean conversation_open, boolean open_invite) {
        this.recipient_ids = recipient_ids;
        this.title = title;
        this.message = message;
        this.attachment_key = attachment_key;
        this.conversation_open = conversation_open;
        this.open_invite = open_invite;
    }

    public static CreateConversationBuilder builder() {
        return new CreateConversationBuilder();
    }

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.CONVERSATIONS;
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
        return new ArrayList<>();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> params = new ArrayList<>();

        params.add(new XenNameValuePair("recipient_ids", this.recipient_ids));
        params.add(new XenNameValuePair("title", this.title));
        params.add(new XenNameValuePair("message", this.message));
        params.add(new XenNameValuePair("conversation_open", this.conversation_open));
        params.add(new XenNameValuePair("open_invite", this.open_invite));

        if (this.attachment_key == null || !this.attachment_key.isEmpty())
            params.add(new XenNameValuePair("attachment_key", this.attachment_key));

        return params;
    }

    @Override
    public Class<ConversationCreateResponse> response() {
        return ConversationCreateResponse.class;
    }

    public static class CreateConversationBuilder {
        private List<Integer> recipient_ids;
        private String title;
        private String message;
        private String attachment_key;
        private boolean conversation_open;
        private boolean open_invite;

        CreateConversationBuilder() {
        }

        public CreateConversationBuilder recipient_ids(List<Integer> recipient_ids) {
            this.recipient_ids = recipient_ids;
            return this;
        }

        public CreateConversationBuilder recipient_ids(Integer... recipient_ids) {
            this.recipient_ids = Arrays.asList(recipient_ids);
            return this;
        }

        public CreateConversationBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CreateConversationBuilder message(String message) {
            this.message = message;
            return this;
        }

        public CreateConversationBuilder attachment_key(String attachment_key) {
            this.attachment_key = attachment_key;
            return this;
        }

        public CreateConversationBuilder conversation_open(boolean conversation_open) {
            this.conversation_open = conversation_open;
            return this;
        }

        public CreateConversationBuilder open_invite(boolean open_invite) {
            this.open_invite = open_invite;
            return this;
        }

        public CreateConversation build() {
            return new CreateConversation(this.recipient_ids, this.title, this.message, this.attachment_key, this.conversation_open, this.open_invite);
        }

        public String toString() {
            return "CreateConversation.CreateConversationBuilder(recipient_ids=" + this.recipient_ids + ", title=" + this.title + ", message=" + this.message + ", attachment_key=" + this.attachment_key + ", conversation_open=" + this.conversation_open + ", open_invite=" + this.open_invite + ")";
        }
    }
}


