package net.irregularhaguruma.engine.controller.bean;

public enum MessageEnum {
    AT("at"),
    AT_ALL("atAll"),
    FACE("face"),
    IMAGE("image"),
    PLAIN_TEXT("plainText");


    private String type;

    MessageEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
