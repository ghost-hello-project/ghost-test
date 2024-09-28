package com.laolang.jx;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class OkHttpSimpleTest {

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String BASE_URL = "http://localhost:8092/admin/system/dict";

    private OkHttpClient client;

    @BeforeClass
    public void beforeClass() {
        client = new OkHttpClient();
    }


    /**
     * 无参 get 请求
     */
    @Test
    public void testGetMethod() throws IOException {
        String url = BASE_URL + "/getMethod";

        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("code:{}", response.code());
            log.info("body:{}", response.body().string());
        }
    }

    /**
     * get 请求带参数
     */
    @Test
    public void testGetMethodWithParam() throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/getMethodWithParam").newBuilder();
        urlBuilder.addQueryParameter("id", "1");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("code:{}", response.code());
            log.info("body:{}", response.body().string());
        }
    }

    /**
     * 无参 post 请求
     */
    @Test
    public void testPostMethod() throws IOException {
        String url = BASE_URL + "/postMethod";

        FormBody formBody = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("code:{}", response.code());
            log.info("body:{}", response.body().string());
        }
    }

    /**
     * post form 表单请求
     */
    @Test
    public void testPostMethodWithFormData() throws IOException {
        String url = BASE_URL + "/postMethodWithFormData";

        FormBody formBody = new FormBody.Builder()
                .add("name", "gender")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("code:{}", response.code());
            log.info("body:{}", response.body().string());
        }
    }

    /**
     * post json 请求
     */
    @Test
    public void testPostMethodWithRequestBody() throws IOException {
        String url = BASE_URL + "/postMethodWithRequestBody";
        JSONObject json = new JSONObject();
        json.set("id", 1);
        RequestBody requestBody = RequestBody.create(JSONUtil.toJsonStr(json), MEDIA_TYPE_JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("code:{}", response.code());
            log.info("body:{}", response.body().string());
        }
    }
}
