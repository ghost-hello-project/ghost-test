package com.laolang.jx;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class OkHttpSimpleTest {

    private static final String BASE_URL = "http://localhost:8092/admin/system/dict";

    private OkHttpClient client;

    @BeforeClass
    public void beforeClass() {
        client = new OkHttpClient();
    }


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
}
