package com.laolang.jx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

@Slf4j
@SpringBootTest(classes = RestTemplateStudyApplication.class)
public class RestTemplateSimpleTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "http://localhost:8092/admin/system/dict";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 无参 get 请求
     */
    @Test
    public void testGetMethod() {
        String url = BASE_URL + "/getMethod";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        log.info("code:{}", response.getStatusCode().value());
        log.info("body:{}", response.getBody());
    }

    /**
     * get 请求带参数
     */
    @Test
    public void testGetMethodWithParam() {
        String url = BASE_URL + "/getMethodWithParam?id=1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        log.info("code:{}", response.getStatusCode().value());
        log.info("body:{}", response.getBody());
    }

    /**
     * 无参 post 请求
     */
    @Test
    public void testPostMethod() throws IOException {
        String url = BASE_URL + "/postMethod";
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        ResponseEntity<String> response = restTemplate.postForEntity(url, param, String.class);

        log.info("code:{}", response.getStatusCode().value());
        log.info("body:{}", response.getBody());
    }

    /**
     * post form 表单请求
     */
    @Test
    public void testPostMethodWithFormData() {
        String url = BASE_URL + "/postMethodWithFormData";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.set("id", 1);
        ResponseEntity<String> response = restTemplate.postForEntity(url, param, String.class);

        log.info("code:{}", response.getStatusCode().value());
        log.info("body:{}", response.getBody());
    }

    /**
     * post json 请求
     */
    @Test
    public void testPostMethodWithRequestBody() throws IOException {
        String url = BASE_URL + "/postMethodWithRequestBody";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(param, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        log.info("code:{}", response.getStatusCode().value());
        log.info("body:{}", response.getBody());
    }
}
