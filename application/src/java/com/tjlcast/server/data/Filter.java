package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by hasee on 2018/4/22.
 */
@Data
public class Filter {
    private String fiterId ;    // 过滤器 唯一Id (must)
    private String jsCode ;     // jsCode

    public Filter(String fiterId, String jsCode) {
        this.fiterId = fiterId;
        this.jsCode = jsCode;
    }
}
