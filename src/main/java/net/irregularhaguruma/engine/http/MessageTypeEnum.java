package net.irregularhaguruma.engine.http;

public enum MessageTypeEnum {
    GROUP_MESSAGE("group"),
    FRIEND_MESSAGE("friend"),
    MEMBER_MESSAGE("member");

    MessageTypeEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
