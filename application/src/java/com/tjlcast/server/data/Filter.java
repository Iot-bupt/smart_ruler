package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by hasee on 2018/4/22.
 */
@Data
public class Filter {
    private Integer id;    // 过滤器 唯一Id (must)
    private String jsCode ;     // jsCode

    public Filter(Integer id, String jsCode) {
        this.id = id;
        this.jsCode = jsCode;
    }
}
