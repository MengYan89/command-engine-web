package net.irregularhaguruma.engine.http;

import java.util.Arrays;

public class StBean {

    /**
     * 作品PID
     */
   private int pid;

    /**
     * 作品所在P
     */
    private int p;
    /**
     * 作者UID
     */
    private int uid;
    /**
     * 作品标题
     */
    private String title;
    /**
     * 作者名
     */
    private String author;
    /**
     * 图片连接
     */
    private String url;
    /**
     * 是否R18
     */
    private boolean r18;
    /**
     * 原图宽度
     */
    private int width;
    /**
     * 原图高度
     */
    private int height;
    /**
     * 作品标签
     */
    private String[] tags;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isR18() {
        return r18;
    }

    public void setR18(boolean r18) {
        this.r18 = r18;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "StBean{" +
                "pid=" + pid +
                ", p=" + p +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", r18=" + r18 +
                ", width=" + width +
                ", height=" + height +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
