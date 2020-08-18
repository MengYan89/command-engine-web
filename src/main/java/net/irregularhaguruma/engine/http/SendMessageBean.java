package net.irregularhaguruma.engine.http;

import net.irregularhaguruma.engine.controller.bean.MessageBean;

import java.util.List;

public class SendMessageBean {
    private String type;
    private Long groupId;
    private Long id;
    private List<MessageBean> message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    public void setMessage(List<MessageBean> message) {
        this.message = message;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
