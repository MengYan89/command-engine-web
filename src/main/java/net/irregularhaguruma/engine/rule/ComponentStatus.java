package net.irregularhaguruma.engine.rule;

public enum ComponentStatus {
    /**
     * 执行这个组件后继续执行后续组件
     */
    LISTENING(0),
    /**
     * 执行这个组件后不继续执行后续组件
     */
    STOPPED(1);

    ComponentStatus(int sort) {
        this.sort = sort;
    }

    private int sort;

    public int getSort() {
        return sort;
    }
}
