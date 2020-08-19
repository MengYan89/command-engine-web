package net.irregularhaguruma.engine.http.impl;

import com.alibaba.fastjson.JSON;
import feign.Response;
import net.irregularhaguruma.engine.config.StConfig;
import net.irregularhaguruma.engine.http.StApi;
import net.irregularhaguruma.engine.http.StApiResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.http1.Http1ExchangeCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 随机涩图API TODO 待优化
 */
@Component
public class StApiImpl implements StApi {



    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private StConfig stConfig;

    @Override
    public StApiResponse getStByKey(String keyword) {
        Request request = new Request.Builder().url("https://api.lolicon.app/setu/?"+stConfig.toString()+"&"+"keyword="+keyword)
                .build();
        try {
            okhttp3.Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                StApiResponse apiResponse = JSON.parseObject(response.body().string(), StApiResponse.class);
                return apiResponse;
            } else {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StApiResponse getSt() {
        Request request = new Request.Builder().url("https://api.lolicon.app/setu/?"+stConfig.toString())
                .build();
        try {
            okhttp3.Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                StApiResponse apiResponse = JSON.parseObject(response.body().string(), StApiResponse.class);
                return apiResponse;
            } else {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StApiResponse getSt(int r18) {
        Request request = new Request.Builder().url("https://api.lolicon.app/setu/?"+stConfig.isR18()+"&r18="+r18)
                .build();
        try {
            okhttp3.Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                StApiResponse apiResponse = JSON.parseObject(response.body().string(), StApiResponse.class);
                return apiResponse;
            } else {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
