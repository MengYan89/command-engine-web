package net.irregularhaguruma.engine.controller.bean;

public class MessageBean {
    public MessageBean() {
    }

    public MessageBean(int no, String msgType, String msgDate) {
        this.no = no;
        this.msgType = msgType;
        this.msgDate = msgDate;
    }

    private int no;
    private String msgType;
    private String msgDate;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "no=" + no +
                ", msgType='" + msgType + '\'' +
                ", msgDate='" + msgDate + '\'' +
                '}';
    }
}
