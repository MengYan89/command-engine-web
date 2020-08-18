package net.irregularhaguruma.engine.controller.bean;

import java.util.List;

public class GroupMessageBean {
    private Long groupId;
    private Long id;
    private Long botId;
    private List<MessageBean> message;

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    @Override
    public String toString() {
        return "GroupMessageBean{" +
                "groupId=" + groupId +
                ", id=" + id +
                ", botId=" + botId +
                ", message=" + message +
                '}';
    }
}
