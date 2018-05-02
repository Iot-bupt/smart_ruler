package com.tjlcast.server.data;

import lombok.Data;

/**
 * Created by tangjialiang on 2018/4/23.
 */

@Data
public class Transform {
    private Integer id;
    private String name;
    private String url ;
    private String method ;

    public Transform(Integer id,String name, String url, String method)
    {
        this.id=id;
        this.name=name;
        this.url=url;
        this.method=method;

    }
}
