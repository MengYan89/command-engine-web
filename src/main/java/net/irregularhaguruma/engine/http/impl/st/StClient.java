package net.irregularhaguruma.engine.http.impl.st;

import net.irregularhaguruma.engine.config.StConfig;
import net.irregularhaguruma.engine.http.impl.Client;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class StClient implements Client {
    private OkHttpClient okHttpClient;
    private String url;
    private final String key;

    public StClient(OkHttpClient okHttpClient, String url, String key) {
        this.okHttpClient = okHttpClient;
        this.url = url;
        this.key = "?apikey="+key+"&";
    }

    public Response getExecution(String params) throws IOException {
        Request request = new Request.Builder().url(url+key+params)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }

    public Response getExecution(StRequestMap<String,Object> params) throws IOException {
        Request request = new Request.Builder().url(url+key+params)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }



}
