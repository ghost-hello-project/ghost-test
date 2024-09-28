package com.laolang.jx.module.system.dict.rsp;

import lombok.Data;

@Data
public class SysDictTypeListRsp {

    private Long id;
    private String name;
    private String type;
    private String typeDesc;
    private String groupCode;

}