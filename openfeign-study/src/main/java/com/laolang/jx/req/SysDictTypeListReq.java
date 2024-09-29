package com.laolang.jx.req;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictTypeListReq extends BasePageReq {
    private String name;
    private String type;
    private String groupCode;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
