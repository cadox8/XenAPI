package me.cadox8.xenapi.reply;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

import java.lang.reflect.Type;

public class NodeReply extends AbstractReply {

    @Getter private int node_id;
    @Getter private String title;
    @Getter private String description;
    @Getter private String node_name;
    @Getter private String node_type_id;
    @Getter private int parent_node_id;
    @Getter private int display_order;
    @Getter private int display_in_list;
    @Getter private int lft;
    @Getter private int rgt;
    @Getter private int depth;
    @Getter private int style_id;
    @Getter private int effective_style_id;


    @Override
    public RequestType getRequestType() {
        return RequestType.EDIT_USER;
    }
}
