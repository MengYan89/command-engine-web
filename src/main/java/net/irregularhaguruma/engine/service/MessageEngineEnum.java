package net.irregularhaguruma.engine.service;

public enum  MessageEngineEnum {
    GROUP_MESSAGE("groupMessage"),
    FRIEND_MESSAGE("friendMessage");

    MessageEngineEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
