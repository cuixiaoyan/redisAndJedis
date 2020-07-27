package com.cxy.redis;

import com.cxy.redis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testPing() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");
        System.out.println(jedis.ping());
    }

    @Test
    public void testKey() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");
        //测试key-value的用法
        System.out.println("1.清空数据：" + jedis.flushDB());
        System.out.println("2.判断某个键是否存在：" + jedis.exists("username"));
        System.out.println("3.新增<'username','lq'>的键值对：" + jedis.set("username", "lq"));
        System.out.println("4.新增<'password','123456'>的键值对：" + jedis.set("password", "123456"));
        System.out.println("5.系统中所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("6.删除键password:" + jedis.del("password"));
        System.out.println("7.判断键password是否存在：" + jedis.exists("password"));
        System.out.println("8.查看键username缩存储的值的类型：" + jedis.type("username"));
        System.out.println("9.随机返回key空间的某一个：" + jedis.randomKey());
        System.out.println("10.重命名key:" + jedis.rename("username", "myname"));
        System.out.println("11.取出改后的myname:" + jedis.get("myname"));
        System.out.println("12.按索引查询：" + jedis.select(0));
        System.out.println("13.删除当前选择数据库的所有key:" + jedis.flushDB());
        System.out.println("14.返回当前数据库中key的数目：" + jedis.dbSize());
        System.out.println("15.删除所有数据库中的所有key:" + jedis.flushAll());
    }

    @Test
    public void testString() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");
        jedis.flushDB();
        System.out.println("===================增加数据====================");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("1.删除键key2:" + jedis.del("key2"));
        System.out.println("2.获取键key2：" + jedis.get("key2"));
        System.out.println("3.修改key1:" + jedis.set("key1", "valueChanged"));
        System.out.println("4.获取key1的值：" + jedis.get("key1"));
        System.out.println("5.在key3后面追加值：" + jedis.append("key3", "End"));
        System.out.println("6.获取key3的值：" + jedis.get("key3"));
        System.out.println("7.增加多个键值对：" + jedis.mset("key4", "value4", "key5", "value5"));
        System.out.println("8.获取多个键值对：" + jedis.mget("key1", "key4"));
        System.out.println("9.获取多个键值对：" + jedis.mget(""));
        System.out.println("10.删除多个键值对：" + jedis.del("key1", "key4"));
        System.out.println("11.获取多个键值对：" + jedis.mget("key1", "key2"));

        jedis.flushDB();
        System.out.println("================新增键值对防止被覆盖================");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-newValue"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("================新增键值对并设置有效时间================");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("================获取原值，更新为新值================");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));
        System.out.println("截取指定下标key2的字符串：" + jedis.getrange("key2", 2, 4));
    }

    @Test
    public void testList() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");

        jedis.flushDB();
        System.out.println("=========添加一个List========");
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");//从左边往进加
        jedis.rpush("collections", "HashMap");//从右边往进加
        jedis.lpush("collections", "TreeMap");
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));//-1代表倒数第一个
        System.out.println("collections中0到3区间的内容：" + jedis.lrange("collections", 0, 3));
        System.out.println("============================");
        //删除列表指定的值，第二个参数为删除的个数（有重复时）！后add进去的值先被删掉，类似于出栈！
        System.out.println("删除指定个数的元素：" + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("删除下标0-3区间之外的元素：" + jedis.ltrim("collections", 0, 3));
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("collections列表出栈（左）：" + jedis.lpop("collections"));
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("collections列表出栈（右）：" + jedis.rpop("collections"));
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("修改指定下标1的内容：" + jedis.lset("collections", 1, "hahaaha"));
        System.out.println("collections中的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("============================");
        System.out.println("collections的长度：" + jedis.llen("collections"));
        System.out.println("获取指定下标1的元素：" + jedis.lindex("collections", 1));
        System.out.println("==============排序==============");
        jedis.lpush("sortedList", "5", "6", "4", "3", "9", "1");
        System.out.println("排序前：" + jedis.lrange("sortedList", 0, -1));
        System.out.println("排序后：" + jedis.sort("sortedList"));

    }

    @Test
    public void testSet() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");

        jedis.flushDB();
        System.out.println("===============向集合中添加元素（不重复）================");
        System.out.println(jedis.sadd("set", "e1", "e3", "e2", "e5", "e7", "e4", "e0", "e8"));
        System.out.println(jedis.sadd("set", "e6"));
        System.out.println(jedis.sadd("set", "e6"));
        System.out.println("set集合中所有的元素为：" + jedis.smembers("set"));
        System.out.println("删除一个指定元素e0：" + jedis.srem("set", "e0"));
        System.out.println("set集合中所有的元素为：" + jedis.smembers("set"));
        System.out.println("删除多个指定元素e7，e5：" + jedis.srem("set", "e7", "e5"));
        System.out.println("set集合中所有的元素为：" + jedis.smembers("set"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("set"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("set"));
        System.out.println("set集合中所有的元素为：" + jedis.smembers("set"));
        System.out.println("set集合中的元素个数：" + jedis.scard("set"));
        System.out.println("e1是否在set集合中：" + jedis.sismember("set", "e1"));
        System.out.println("========================================================");
        System.out.println(jedis.sadd("set1", "e1", "e3", "e2", "e5", "e7", "e4", "e6"));
        System.out.println(jedis.sadd("set2", "e1", "e3", "e0", "e5", "e8", "e4", "e6"));
        System.out.println("将set1中的元素删掉e1并将e1存入set3中：" + jedis.smove("set1", "set3", "e1"));
        System.out.println("将set1中的元素删掉e5并将e5存入set3中：" + jedis.smove("set1", "set3", "e5"));
        System.out.println("set1集合中所有的元素为：" + jedis.smembers("set1"));
        System.out.println("set3集合中所有的元素为：" + jedis.smembers("set3"));
        System.out.println("=====================集合运算=======================");
        System.out.println("set1集合中所有的元素为：" + jedis.smembers("set1"));
        System.out.println("set2集合中所有的元素为：" + jedis.smembers("set2"));
        System.out.println("set1与set2集合的并集：" + jedis.sunion("set1", "set2"));
        System.out.println("set1与set2集合的交集：" + jedis.sinter("set1", "set2"));
        System.out.println("set1与set2集合的差集：" + jedis.sdiff("set1", "set2"));//set1与set2中去掉交集后剩余的元素
        jedis.sinterstore("set4", "set1", "set2");//求交集并将交集保存在dstkey中
        System.out.println("set4集合中所有的元素为：" + jedis.smembers("set4"));
    }

    @Test
    public void tsetHash() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");

        //添加元素
        jedis.hmset("hash", map);
        //还可以这么添加
        jedis.hset("hash", "k5", "v5");
        System.out.println("散列hash的所有键值对：" + jedis.hgetAll("hash"));
        System.out.println("散列hash的所有键：" + jedis.hkeys("hash"));
        System.out.println("散列hash的所有值：" + jedis.hvals("hash"));
        System.out.println("将k6的保存的值加上一个整数，如果k6不存在则添加k6：" + jedis.hincrBy("hash", "k6", 5));
        System.out.println("散列hash的所有键值对：" + jedis.hgetAll("hash"));
        System.out.println("将k6的保存的值加上一个整数，如果k6不存在则添加k6：" + jedis.hincrBy("hash", "k6", 5));
        System.out.println("散列hash的所有键值对：" + jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对：" + jedis.hdel("hash", "k1", "k3"));
        System.out.println("散列hash的所有键值对：" + jedis.hgetAll("hash"));
        System.out.println("散列hash的所有键值对个数：" + jedis.hlen("hash"));
        System.out.println("判断k2是否在hash中：" + jedis.hexists("hash", "k2"));
        System.out.println("判断k1是否在hash中：" + jedis.hexists("hash", "k1"));
        System.out.println("获取hash中的一个值：" + jedis.hmget("hash", "k4"));
        System.out.println("获取hash中的多个值：" + jedis.hmget("hash", "k4", "k6"));
    }

    @Test
    public void testZset() {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");

        jedis.flushDB();
        jedis.zadd("myset", 1, "one");
        jedis.zadd("myset", 2, "two");
        jedis.zadd("myset", 3, "three");
        System.out.println("查看全部的值：" + jedis.zrange("myset", 0, -1));

        jedis.flushDB();
        jedis.zadd("salsry", 2500, "zhangsan");
        jedis.zadd("salsry", 500, "lisi");
        jedis.zadd("salsry", 5000, "wangwu");
        System.out.println("由高到低排序：" + jedis.zrangeByScore("salsry", "-inf", "+inf"));
        System.out.println("由高到低排序：" + jedis.zrevrangeByScore("salsry", "+inf", "-inf"));
        System.out.println("查看全部的值：" + jedis.zrange("salsry", 0, -1));
        jedis.zrem("salsry", "lisi");
        System.out.println("查看全部的值：" + jedis.zrange("salsry", 0, -1));
        System.out.println("查看所有元素的个数：" + jedis.zcard("salsry"));

        jedis.flushDB();
        jedis.zadd("myset", 1, "one");
        jedis.zadd("myset", 2, "two");
        jedis.zadd("myset", 3, "three");
        jedis.zadd("myset", 4, "four");
        System.out.println("获取指定区间元素的个数：" + jedis.zcount("myset", 0, 3));
    }

    @Test
    public void testTX() throws JsonProcessingException {
        Jedis jedis = new Jedis("192.168.106.129", 6666);
        //如果没有密码，就可以省略下面步骤。
        jedis.auth("cxy0809.");

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("name", "cuixiaoyan");
        userMap.put("age", "18");

        ObjectMapper objectMapper = new ObjectMapper();
        String userList = objectMapper.writeValueAsString(userMap);
        //开启事务
        Transaction multi = jedis.multi();
        try {
            multi.set("user1", userList);
            multi.set("user2", userList);
            //代码抛出移除，执行失败。
            //int i = 1 / 0;
            multi.exec();//执行事务。

        } catch (Exception e) {
            multi.discard(); //放弃事务。
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();//关闭连接。

        }

    }

    /**
     * RedisTemplate测试
     */
    @Test
    public void testRedisTemplate() {
        // redisTemplate 操作不同的数据类型，api和我们的指令是一样的
        // opsForValue 操作字符串 类似String
        // opsForList 操作List 类似List
        // opsForSet
        // opsForHash
        // opsForZSet
        // opsForGeo
        // opsForHyperLogLog
        // 除了进本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的CRUD
        // 获取redis的连接对象
        // RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        // connection.flushDb();
        // connection.flushAll();

        redisTemplate.opsForValue().set("name", "cuixiaoyan");
        System.out.println(redisTemplate.opsForValue().get("name"));

    }

    /**
     * 保存对象
     */
    @Test
    public void testSaveUser() throws JsonProcessingException {
        User user = new User("崔笑颜1", 28);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(user);

        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }


}
