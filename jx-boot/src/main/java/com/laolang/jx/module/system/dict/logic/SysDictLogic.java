package com.laolang.jx.module.system.dict.logic;

import com.laolang.jx.framework.common.util.JsonUtil;
import com.laolang.jx.module.system.dict.req.SysDictTypeListReq;
import com.laolang.jx.module.system.dict.rsp.SysDictTypeListRsp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SysDictLogic {

    public SysDictTypeListRsp getMethod() {
        log.info("getMethod");
        return buildRsp();
    }

    public SysDictTypeListRsp getMethodWithParam(Long id, String name) {
        log.info("getMethodWithParam");
        log.info("id:{}, name:{}", id, name);
        return buildRsp();
    }

    public SysDictTypeListRsp postMethod() {
        log.info("postMethod");
        return buildRsp();
    }

    public SysDictTypeListRsp postMethodWithFormData(SysDictTypeListReq req) {
        log.info("postMethodWithFormData. req:{}", JsonUtil.toJson(req));
        return buildRsp();
    }

    public SysDictTypeListRsp postMethodWithRequestBody(SysDictTypeListReq req) {
        log.info("postMethodWithRequestBody. req:{}", JsonUtil.toJson(req));
        return buildRsp();
    }

    private SysDictTypeListRsp buildRsp() {
        SysDictTypeListRsp rsp = new SysDictTypeListRsp();
        rsp.setId(1L);
        rsp.setName("性别");
        rsp.setType("gender");
        rsp.setTypeDesc("性别");
        rsp.setGroupCode("system");
        return rsp;
    }



}
