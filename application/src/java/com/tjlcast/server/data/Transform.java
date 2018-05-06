package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by tangjialiang on 2018/4/23.
 */

@Data
public class Transform {
    private Integer transformId;
    private String name;
    private String url ;
    private String method ;

    public Transform(Integer transformId,String name, String url, String method)
    {
        this.transformId=transformId;
        this.name=name;
        this.url=url;
        this.method=method;

    }
}
