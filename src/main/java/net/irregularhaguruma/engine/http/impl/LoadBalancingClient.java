package net.irregularhaguruma.engine.http.impl;

import com.alibaba.fastjson.JSON;
import net.irregularhaguruma.engine.http.StApiCodeEnum;
import net.irregularhaguruma.engine.http.StApiResponse;
import net.irregularhaguruma.engine.http.impl.st.StClient;
import net.irregularhaguruma.engine.http.impl.st.StRequestMap;
import okhttp3.Response;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class LoadBalancingClient {
    private Integer i = 0;
    private ConcurrentHashMap<Integer, StClient> clientMap = new ConcurrentHashMap<>();

    private Vector<Integer> index = new Vector<>();


    public void setClient(StClient stClient) {
        clientMap.put(i, stClient);
        index.add(i);
        i++;
    }


    public StApiResponse getExecution(StRequestMap<String,Object> params) throws IOException {
        if (index.isEmpty()) {
            return null;
        }
        Integer clientId = getClient();
        StClient client = clientMap.get(clientId);
        Response response = client.getExecution(params);
        if (response.isSuccessful()) {
            StApiResponse apiResponse = JSON.parseObject(response.body().string(), StApiResponse.class);
            // TODO 待优化的到达限额处理
            if (apiResponse.getCode() == StApiCodeEnum.QUOTA_ERROR.getCode()) {
                synchronized (client) {
                    if (index.contains(clientId)) {
                        System.out.println("这个Api调用到达限额,将进入等待");
                        new Thread(() -> {
                            index.remove(clientId);
                            try {
                                TimeUnit.SECONDS.sleep(apiResponse.getQuota_min_ttl());
                                System.out.println("这个Api的等待结束了,将回到待调用状态");
                                index.add(clientId);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }

            return apiResponse;
        }
        return null;
    }


    private int getClient() {
        Random random = new Random();
        int n = random.nextInt(index.size());
        return index.get(n);
    }





}
