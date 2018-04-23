package com.tjlcast.server.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tangjialiang on 2018/4/23.
 */

@Entity
@Data
public class Transform {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = true)
    private String url ;
    @Column(columnDefinition = "GET")
    private String method ;
}
