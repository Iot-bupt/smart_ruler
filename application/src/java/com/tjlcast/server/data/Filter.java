package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by hasee on 2018/4/22.
 */
@Data
public class Filter {
    private String jsCode;

    public Filter(String jsCode)
    {
        this.jsCode = jsCode;
    }
}
