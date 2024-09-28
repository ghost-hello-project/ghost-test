package com.laolang.jx.module.system.dict.controller;

import com.laolang.jx.framework.common.domain.R;
import com.laolang.jx.module.system.dict.logic.SysDictLogic;
import com.laolang.jx.module.system.dict.req.SysDictTypeListReq;
import com.laolang.jx.module.system.dict.rsp.SysDictTypeListRsp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("admin/system/dict")
@RestController
public class SydDictController {

    private final SysDictLogic sysDictLogic;

    @GetMapping("getMethod")
    public R<SysDictTypeListRsp> getMethod() {
        return R.ok(sysDictLogic.getMethod());
    }

    @GetMapping("getMethodWithParam")
    public R<SysDictTypeListRsp> getMethodWithParam(@RequestParam(value = "id") Long id,
                                                    @RequestParam(value = "name", defaultValue = "laolang") String name) {
        return R.ok(sysDictLogic.getMethodWithParam(id, name));
    }

    @PostMapping("postMethod")
    public R<SysDictTypeListRsp> postMethod() {
        return R.ok(sysDictLogic.postMethod());
    }

    @PostMapping("postMethodWithFormData")
    public R<SysDictTypeListRsp> postMethodWithFormData(SysDictTypeListReq req) {
        return R.ok(sysDictLogic.postMethodWithFormData(req));
    }

    @PostMapping("postMethodWithRequestBody")
    public R<SysDictTypeListRsp> postMethodWithRequestBody(@RequestBody SysDictTypeListReq req) {
        return R.ok(sysDictLogic.postMethodWithRequestBody(req));
    }


}
