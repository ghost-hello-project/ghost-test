package com.laolang.jx;

import cn.hutool.json.JSONUtil;
import com.laolang.jx.common.domain.R;
import com.laolang.jx.remote.SysDictRemote;
import com.laolang.jx.req.SysDictTypeListReq;
import com.laolang.jx.rsp.SysDictTypeListRsp;
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
import org.testng.annotations.Test;

@Slf4j
@SpringBootTest(classes = OpenfeignStudyApplication.class)
public class OpenfeignSimpleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SysDictRemote sysDictRemote;


    /**
     * 无参 get 请求
     */
    @Test
    public void testGetMethod() {
        R<SysDictTypeListRsp> r = sysDictRemote.getMethod();
        log.info(JSONUtil.toJsonStr(r));
    }

    /**
     * get 请求带参数
     */
    @Test
    public void testGetMethodWithParam() {
        R<SysDictTypeListRsp> r = sysDictRemote.getMethodWithParam(1L, "潼关路边的一只野鬼");
        log.info(JSONUtil.toJsonStr(r));
    }

    /**
     * 无参 post 请求
     */
    @Test
    public void testPostMethod() {
        R<SysDictTypeListRsp> r = sysDictRemote.postMethod();
        log.info(JSONUtil.toJsonStr(r));
    }

    /**
     * post form 表单请求
     */
    @Test
    public void testPostMethodWithFormData() {
        SysDictTypeListReq req = new SysDictTypeListReq();
        req.setName("gender");
        R<SysDictTypeListRsp> r = sysDictRemote.postMethodWithFormData(req);
        log.info(JSONUtil.toJsonStr(r));
    }

    /**
     * post json 请求
     */
    @Test
    public void testPostMethodWithRequestBody() throws IOException {
        SysDictTypeListReq req = new SysDictTypeListReq();
        req.setName("gender");
        R<SysDictTypeListRsp> r = sysDictRemote.postMethodWithRequestBody(req);
        log.info(JSONUtil.toJsonStr(r));
    }


}
