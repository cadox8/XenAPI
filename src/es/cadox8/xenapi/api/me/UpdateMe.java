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
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class UpdateMe implements ApiRequest<Success> {

    // --- Options ---
    private final Options options;
    // --- Profile ---
    private final Profile profile;
    // --- Privacy ---
    private final Privacy privacy;
    // --- Normal ---
    private final Boolean visible;
    private final Boolean activityVisible;
    private final String timezone;
    private final String customTitle;
    private final List<XenNameValuePair> customFields;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.ME;
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
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.options != null)
            this.options.body().forEach(p -> list.add(new XenNameValuePair("option." + p.getName(), p.getValue())));

        if (this.profile != null)
            this.profile.body().forEach(p -> list.add(new XenNameValuePair("profile." + p.getName(), p.getValue())));

        if (this.privacy != null)
            this.privacy.body().forEach(p -> list.add(new XenNameValuePair("privacy." + p.getName(), p.getValue())));

        if (this.visible != null)
            list.add(new XenNameValuePair("visible", this.visible));
        if (this.activityVisible != null)
            list.add(new XenNameValuePair("activity_visible", this.activityVisible));
        if (this.timezone != null && !this.timezone.isEmpty())
            list.add(new XenNameValuePair("timezone", this.timezone));
        if (this.customTitle != null && !this.customTitle.isEmpty())
            list.add(new XenNameValuePair("custom_title", this.customTitle));

        if (this.customFields != null && !this.customFields.isEmpty())
            this.customFields.forEach(p -> list.add(new XenNameValuePair("custom_fields." + p.getName(), p.getValue())));

        return list;
    }

    @Override
    public Class<Success> response() {
        return Success.class;
    }

    public enum PrivacyOptions {
        EVERYONE,
        MEMBERS,
        FOLLOWED,
        NONE
    }

    @Builder
    public static class Options {
        private final String creationWatchState;
        private final String interactionWatchState;
        private final Boolean contentShowSignature;
        private final Boolean emailOnConversation;
        private final Boolean receiveAdminEmail;
        private final Boolean showDobYear;
        private final Boolean showDobDate;

        public List<XenNameValuePair> body() {
            final List<XenNameValuePair> list = new ArrayList<>();

            if (this.creationWatchState != null && !this.creationWatchState.isEmpty())
                list.add(new XenNameValuePair("creation_watch_state", this.creationWatchState));
            if (this.interactionWatchState != null && !this.interactionWatchState.isEmpty())
                list.add(new XenNameValuePair("interaction_watch_state", this.interactionWatchState));
            if (this.contentShowSignature != null)
                list.add(new XenNameValuePair("content_show_signature", this.contentShowSignature));
            if (this.emailOnConversation != null)
                list.add(new XenNameValuePair("email_on_conversation", this.emailOnConversation));
            if (this.receiveAdminEmail != null)
                list.add(new XenNameValuePair("receive_admin_email", this.receiveAdminEmail));
            if (this.showDobYear != null)
                list.add(new XenNameValuePair("show_dob_year", this.showDobYear));
            if (this.showDobDate != null)
                list.add(new XenNameValuePair("show_dob_date", this.showDobDate));

            return list;
        }
    }

    @Builder
    public static class Profile {
        private final String location;
        private final String website;
        private final String about;
        /**
         * This should allow the formating
         */
        private final String signature;

        public List<XenNameValuePair> body() {
            final List<XenNameValuePair> list = new ArrayList<>();

            if (this.location != null && !this.location.isEmpty())
                list.add(new XenNameValuePair("location", this.location));

            if (this.website != null && !this.website.isEmpty())
                list.add(new XenNameValuePair("website", this.website));

            if (this.about != null && !this.about.isEmpty())
                list.add(new XenNameValuePair("about", this.website));

            if (this.signature != null && !this.signature.isEmpty())
                list.add(new XenNameValuePair("signature", this.website));

            return list;
        }
    }

    @Builder
    public static class Privacy {
        private final PrivacyOptions allowViewProfile;
        private final PrivacyOptions allowPostProfile;
        private final PrivacyOptions allowReceiveNewsFeed;
        private final PrivacyOptions allowSendPersonalConversation;
        private final PrivacyOptions allowViewIdentities;

        public List<XenNameValuePair> body() {
            final List<XenNameValuePair> list = new ArrayList<>();

            if (this.allowViewProfile != null)
                list.add(new XenNameValuePair("allow_view_profile", this.allowViewProfile.name().toLowerCase()));

            if (this.allowPostProfile != null)
                list.add(new XenNameValuePair("allow_post_profile", this.allowPostProfile.name().toLowerCase()));

            if (this.allowReceiveNewsFeed != null)
                list.add(new XenNameValuePair("allow_receive_news_feed", this.allowReceiveNewsFeed.name().toLowerCase()));

            if (this.allowSendPersonalConversation != null)
                list.add(new XenNameValuePair("allow_send_personal_conversation", this.allowSendPersonalConversation.name().toLowerCase()));

            if (this.allowViewIdentities != null)
                list.add(new XenNameValuePair("allow_view_identities", this.allowViewIdentities.name().toLowerCase()));

            return list;
        }
    }
}
