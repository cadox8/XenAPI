/*
 *  Copyright (c) 2018.
 *
 *  This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 *  XenAPI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  XenAPI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.cadox8.xenapi.reply;

import com.google.gson.*;
import lombok.Getter;
import lombok.ToString;
import me.cadox8.xenapi.request.RequestType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ToString
public class AlertsReply extends AbstractReply {

    @Getter private Alerts alerts;

    @Getter private String alertHandlers;

    @Override
    public RequestType getRequestType() {
        return RequestType.GET_ALERTS;
    }


    public static class Alerts {

        @Getter private List<Alert> alerts;

        public Alerts(List<Alert> alerts) {
            this.alerts = alerts;
        }
    }

    @Getter
    protected static class Alert {

        private String content_id;

        private String alerted_user_id;

        private Content content;

        private String content_type;

        private String extra_data;

        private String alert_id;

        private String event_date;

        private String action;

        private boolean new1;
        private boolean unviewed;
        private boolean extra;

        private UserAlert user;

        private String view_date;

        @Getter
        protected static class Content {

            private String secondary_group_ids;

            private String terms_accepted;

            private String gender;

            private String timezone;

            private String language_id;

            private String activity_visible;

            private String trophy_points;

            private String user_state;

            private String is_admin;

            private String last_activity;

            private String gravatar;

            private String custom_title;

            private String alerts_unread;

            private String email;

            private String avatar_height;

            private String visible;

            private String avatar_width;

            private String like_count;

            private String is_staff;

            private String register_date;

            private String is_moderator;

            private String message_count;

            private String avatar_date;

            private String user_id;

            private String conversations_unread;

            private String display_style_group_id;

            private String permission_combination_id;

            private String style_id;

            private String is_banned;

            private String warning_points;

            private String user_group_id;

            private String username;

            private String privacy_policy_accepted;
        }

        protected static class UserAlert {
            @Getter private int user_id;
            @Getter private String username;
            @Getter private String gender;
            @Getter private String gravatar;
            @Getter private int avatar_date;
        }
    }


    public static class AlertListDeserializer implements JsonDeserializer<Alerts> {
        @Override
        public Alerts deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
            final JsonObject object = jsonElement.getAsJsonObject();
            final List<Alert> cities = new ArrayList<Alert>();
            for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
                final Alert city = context.deserialize(entry.getValue(), Alert.class);
                cities.add(city);
            }
            return new Alerts(cities);
        }
    }
}
