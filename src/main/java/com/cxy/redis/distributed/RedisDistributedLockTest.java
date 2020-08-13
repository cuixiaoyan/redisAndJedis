package com.cxy.redis.distributed;

import redis.clients.jedis.Jedis;

/**
 * @program: redis
 * @description: 分布式锁测试类。
 * @author: cuixy
 * @create: 2020-08-13 17:01
 **/
public class RedisDistributedLockTest {

    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                RedisDistributedLock lock = null;
                String unLockIdentify = null;
                try {
                    Jedis conn = new Jedis("192.168.106.129", 6666);
                    //如果没有密码，就可以省略下面步骤。
                    conn.auth("cxy0809.");

                    lock = new RedisDistributedLock(conn, "test1");
                    unLockIdentify = lock.acquire();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    secskill();
                } finally {
                    if (lock != null) {
                        lock.release(unLockIdentify);
                    }
                }
            }).start();
        }


    }

}