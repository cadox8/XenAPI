package es.cadox8.xenapi.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * User class
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends XenForoEntity {

    private String about;
    private boolean activity_visible;
    private int age;
    private Object[] alert_optout;
    private String allow_post_profile;
    private String allow_receive_news_feed;
    private String allow_send_personal_conversation;
    private String allow_view_identities;
    private String allow_view_profile;

    private Object[] avatar_urls;
    private Object[] profile_banner_urls;

    private boolean can_ban;
    private boolean can_converse;
    private boolean can_edit;
    private boolean can_follow;
    private boolean can_ignore;
    private boolean can_post_profile;
    private boolean can_view_profile;
    private boolean can_view_profile_posts;
    private boolean can_warn;
    private boolean content_show_signature;

    private String creation_watch_state;
    private Object custom_fields;
    private String custom_title;
    private Date dob;

    private String email;
    private boolean email_on_conversation;

    private String gravatar;

    private boolean interaction_watch_state;
    private boolean is_admin;
    private boolean is_banned;
    private boolean is_discouraged;
}
