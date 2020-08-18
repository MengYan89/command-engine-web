package net.irregularhaguruma.engine.service;

import net.irregularhaguruma.engine.controller.bean.GroupMessageBean;

public interface Engine {
    String messageEngine(MessageEngineEnum type, GroupMessageBean messageBean);
}
