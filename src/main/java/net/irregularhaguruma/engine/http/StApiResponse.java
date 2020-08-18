package net.irregularhaguruma.engine.http;

import java.util.List;

public class StApiResponse {
    /**
     * 返回码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 剩余调用额度
     */
    private int quota;
    /**
     * 额度回复秒数,每次回复一次
     */
    private int quota_min_ttl;
    /**
     * 结果数
     */
    private int count;

    /**
     * 图片数组
     */
    private List<StBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getQuota_min_ttl() {
        return quota_min_ttl;
    }

    public void setQuota_min_ttl(int quota_min_ttl) {
        this.quota_min_ttl = quota_min_ttl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<StBean> getData() {
        return data;
    }

    public void setData(List<StBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StApiResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", quota=" + quota +
                ", quota_min_ttl=" + quota_min_ttl +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
