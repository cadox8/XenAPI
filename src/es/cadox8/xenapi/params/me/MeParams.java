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

package es.cadox8.xenapi.params.me;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Builder;

import java.util.List;

@Builder
public class MeParams {

    // -- Options --
    private final String creation_watch_state;
    private final String interaction_watch_state;
    private final boolean content_show_signature;
    private final boolean email_on_conversation;
    private final boolean push_on_conversation;
    private final boolean receive_admin_email;
    private final boolean show_dob_year;
    private final boolean show_dob_date;
    // -- --
    // -- Profile --
    private final String location;
    private final String website;
    private final String about;
    private final String signature;
    // -- --
    // -- Privacy --
    private final String allow_view_profile;
    private final String allow_post_profile;
    private final String allow_receive_news_feed;
    private final String allow_send_personal_conversation;
    private final String allow_view_identities;
    // -- --
    private final boolean visible;
    private final boolean activity_visible;
    private final String timezone;
    private final String custom_title;
    private final List<String> custom_fields;

    public String body() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject body = new JsonObject();
        final JsonObject options = new JsonObject();
        final JsonObject profile = new JsonObject();
        final JsonObject privacy = new JsonObject();

        if (!this.creation_watch_state.isEmpty())
            options.addProperty("creation_watch_state", this.creation_watch_state);
        if (!this.interaction_watch_state.isEmpty())
            options.addProperty("interaction_watch_state", this.interaction_watch_state);
        if (this.content_show_signature)
            options.addProperty("content_show_signature", true);
        if (this.email_on_conversation)
            options.addProperty("email_on_conversation", true);
        if (this.push_on_conversation)
            options.addProperty("push_on_conversation", true);
        if (this.receive_admin_email)
            options.addProperty("receive_admin_email", true);
        if (this.show_dob_year)
            options.addProperty("show_dob_year", true);
        if (this.show_dob_date)
            options.addProperty("show_dob_date", true);

        if (!this.location.isEmpty())
            profile.addProperty("location", this.location);
        if (!this.website.isEmpty())
            profile.addProperty("website", this.website);
        if (!this.about.isEmpty())
            profile.addProperty("about", this.about);
        if (!this.signature.isEmpty())
            profile.addProperty("signature", this.signature);

        if (!this.allow_view_profile.isEmpty())
            privacy.addProperty("allow_view_profile", this.allow_view_profile);
        if (!this.allow_post_profile.isEmpty())
            privacy.addProperty("allow_post_profile", this.allow_post_profile);
        if (!this.allow_receive_news_feed.isEmpty())
            privacy.addProperty("allow_receive_news_feed", this.allow_receive_news_feed);
        if (!this.allow_send_personal_conversation.isEmpty())
            privacy.addProperty("allow_send_personal_conversation", this.allow_send_personal_conversation);
        if (!this.allow_view_identities.isEmpty())
            privacy.addProperty("allow_view_identities", this.allow_view_identities);

        if (!options.isEmpty())
            body.add("option", options);
        if (!profile.isEmpty())
            body.add("profile", profile);
        if (!privacy.isEmpty())
            body.add("privacy", privacy);

        if (this.visible)
            body.addProperty("visible", true);
        if (this.activity_visible)
            body.addProperty("activity_visible", true);
        if (!this.timezone.isEmpty())
            body.addProperty("timezone", this.timezone);
        if (!this.custom_title.isEmpty())
            body.addProperty("custom_title", this.custom_title);

        if (!this.custom_fields.isEmpty()) {
            final JsonArray array = new JsonArray();
            this.custom_fields.forEach(array::add);
            body.add("custom_fields", array);
        }

        return gson.toJson(body);
    }
}
