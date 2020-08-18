package net.irregularhaguruma.engine.controller;

import net.irregularhaguruma.engine.controller.bean.GroupMessageBean;
import net.irregularhaguruma.engine.service.Engine;
import net.irregularhaguruma.engine.service.MessageEngineEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    private Engine engine;

    @PostMapping("group")
    public String groupMassage(@RequestBody GroupMessageBean bean) {
        System.out.println(bean);
        engine.messageEngine(MessageEngineEnum.GROUP_MESSAGE,bean);
        return "123456";
    }
}
