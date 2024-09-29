package com.laolang.jx.remote;

import com.laolang.jx.common.domain.R;
import com.laolang.jx.req.SysDictTypeListReq;
import com.laolang.jx.rsp.SysDictTypeListRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( name = "sysDict", url = "http://localhost:8092/admin/system/dict")
public interface SysDictRemote {

    @GetMapping("getMethod")
    R<SysDictTypeListRsp> getMethod();

    @GetMapping("getMethodWithParam")
    R<SysDictTypeListRsp> getMethodWithParam(@RequestParam(value = "id") Long id,
                                             @RequestParam(value = "name", defaultValue = "laolang") String name);

    @PostMapping("postMethod")
    R<SysDictTypeListRsp> postMethod();

    @PostMapping("postMethodWithFormData")
    R<SysDictTypeListRsp> postMethodWithFormData(SysDictTypeListReq req);

    @PostMapping("postMethodWithRequestBody")
    R<SysDictTypeListRsp> postMethodWithRequestBody(@RequestBody SysDictTypeListReq req);
}
