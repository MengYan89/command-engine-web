package net.irregularhaguruma.engine.http;

import feign.Response;
import net.irregularhaguruma.engine.config.FeignConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public interface StApi {

    StApiResponse getStByKey(String keyword);

    StApiResponse getSt();

    StApiResponse getSt(int r18);

}
