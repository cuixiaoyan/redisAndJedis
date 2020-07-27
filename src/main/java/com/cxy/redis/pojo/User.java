package com.cxy.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: redis
 * @description: 用户类
 * @author: cuixy
 * @create: 2020-07-27 17:12
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String name;
    private Integer age;

}