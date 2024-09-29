package com.laolang.jx.req;


import lombok.Data;

@Data
public class BasePageReq {
    private Integer size = 10;
    private Integer page = 1;
}
