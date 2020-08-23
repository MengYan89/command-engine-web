package net.irregularhaguruma.engine.http.impl;

import com.alibaba.fastjson.JSON;
import feign.Response;
import net.irregularhaguruma.engine.config.StConfig;
import net.irregularhaguruma.engine.http.StApi;
import net.irregularhaguruma.engine.http.StApiResponse;
import net.irregularhaguruma.engine.http.impl.st.StClient;
import net.irregularhaguruma.engine.http.impl.st.StRequestMap;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.http1.Http1ExchangeCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 随机涩图API TODO 待优化
 */
@Component
public class StApiImpl implements StApi {



    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private StConfig stConfig;

    private LoadBalancingClient client = new LoadBalancingClient();


    @PostConstruct
    public void init() {
        String[] key = stConfig.getKey();
        String url = stConfig.getUrl();
        for (String k: key)
            client.setClient(new StClient(okHttpClient, url, k));
    }

    @Override
    public StApiResponse getStByKey(String keyword) {
        StRequestMap<String, Object> request = new StRequestMap<>();
        request.put("r18",stConfig.getR18());
        request.put("size1200", stConfig.getSize1200());
        request.put("keyword",keyword);
        try {
            StApiResponse apiResponse = client.getExecution(request);
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StApiResponse getSt() {
        StRequestMap<String, Object> request = new StRequestMap<>();
        request.put("r18",stConfig.getR18());
        request.put("size1200", stConfig.getSize1200());
        try {
            StApiResponse apiResponse = client.getExecution(request);
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StApiResponse getSt(int r18) {
        StRequestMap<String, Object> request = new StRequestMap<>();
        request.put("r18",r18);
        request.put("size1200", stConfig.getSize1200());
        try {
            StApiResponse apiResponse = client.getExecution(request);
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
