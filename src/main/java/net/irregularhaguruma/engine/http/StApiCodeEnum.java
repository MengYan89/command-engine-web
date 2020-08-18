package net.irregularhaguruma.engine.http;

public enum StApiCodeEnum {
    ERROR(-1,"内部错误"),
    SUCCESS(0,"成功"),
    KEY_ERROR(401,"APIKEY不存在或被封禁"),
    EXECUTE_ERROR(403,"由于不符合规范的操作而被拒绝调用"),
    KEYWORD_ISNULL(404,"找不到符合关键字的涩图"),
    QUOTA_ERROR(429,"达到调用额度限制");

    private int code;
    private String message;

    StApiCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
