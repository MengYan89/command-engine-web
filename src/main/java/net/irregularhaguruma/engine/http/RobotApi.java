package net.irregularhaguruma.engine.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "engine-service",
        url ="${robot.url}")
public interface RobotApi {

    @PostMapping("${robot.message}")
    void sendMessage(@RequestBody SendMessageBean sendMessageBean);
}
