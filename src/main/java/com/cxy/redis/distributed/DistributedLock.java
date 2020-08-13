package com.cxy.redis.distributed;

/**
 * @program: redis
 * @description: 分布式锁，接口。
 * @author: cuixy
 * @create: 2020-08-13 16:23
 **/
public interface DistributedLock {

    //锁标示
    String acquire();

    //释放锁
    boolean release(String indentifier);

}