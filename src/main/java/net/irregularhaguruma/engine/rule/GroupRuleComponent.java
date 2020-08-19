package net.irregularhaguruma.engine.rule;

import net.irregularhaguruma.engine.controller.bean.MessageBean;

import java.util.List;

public interface GroupRuleComponent {

    void execution(List<MessageBean> messageList, long groupId, long id);

    default ComponentStatus getSort() {
        return ComponentStatus.LISTENING;
    }
}
