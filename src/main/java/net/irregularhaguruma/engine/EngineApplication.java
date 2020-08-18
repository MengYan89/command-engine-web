package net.irregularhaguruma.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"net.irregularhaguruma.engine.http"})
public class EngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class);
    }
}
