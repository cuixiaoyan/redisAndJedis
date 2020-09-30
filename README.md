# Nosql概述

## 为什么要用Nosql

>  1、单机MySQL的年代！

![image-20200722164417649](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722164417649.png)

90年代，一个基本的网站访问量一般不会太大，单个数据库完全足够！
那个时候，更多的去使用静态网页 Html ~ 服务器根本没有太大的压力！
思考一下，这种情况下：整个网站的瓶颈是什么？
1、数据量如果太大、一个机器放不下了！
2、数据的索引 （B+ Tree），一个机器内存也放不下
3、访问量（读写混合），一个服务器承受不了~
只要你开始出现以上的三种情况之一，那么你就必须要晋级！

> 2、Memcached（缓存） + MySQL + 垂直拆分 （读写分离）

网站80%的情况都是在读，每次都要去查询数据库的话就十分的麻烦！所以说我们希望减轻数据的压
力，我们可以使用缓存来保证效率！
发展过程： 优化数据结构和索引--> 文件缓存（IO）---> Memcached（当时最热门的技术！）

![image-20200722164554754](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722164554754.png)

> 3、分库分表 + 水平拆分 + MySQL集群

技术和业务在发展的同时，对人的要求也越来越高！
本质：数据库（读，写）
早些年MyISAM： 表锁，十分影响效率！高并发下就会出现严重的锁问题
转战Innodb：行锁
慢慢的就开始使用分库分表来解决写的压力！ MySQL 在哪个年代推出 了表分区！这个并没有多少公司
使用！
MySQL 的 集群，很好满足哪个年代的所有需求！

![image-20200722164648123](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722164648123.png)

> 4、如今最近的年代

2010--2020 十年之间，世界已经发生了翻天覆地的变化；（定位，也是一种数据，音乐，热榜！）
MySQL 等关系型数据库就不够用了！数据量很多，变化很快~！
MySQL 有的使用它来存储一些比较大的文件，博客，图片！数据库表很大，效率就低了！如果有一种数
据库来专门处理这种数据,
MySQL压力就变得十分小（研究如何处理这些问题！）大数据的IO压力下，表几乎没法更大！

> 目前一个基本的互联网项目！

![image-20200722164732579](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722164732579.png)

> 为什么要用NoSQL！

用户的个人信息，社交网络，地理位置。用户自己产生的数据，用户日志等等爆发式增长！
这时候我们就需要使用NoSQL数据库的，Nosql 可以很好的处理以上的情况！

## 什么是NoSQL

> NoSQL

NoSQL = Not Only SQL （不仅仅是SQL）
关系型数据库：表格 ，行 ，列
泛指非关系型数据库的，随着web2.0互联网的诞生！传统的关系型数据库很难对付web2.0时代！尤其
是超大规模的高并发的社区！ 暴露出来很多难以克服的问题，NoSQL在当今大数据环境下发展的十分迅
速，Redis是发展最快的，而且是我们当下必须要掌握的一个技术！
很多的数据类型用户的个人信息，社交网络，地理位置。这些数据类型的存储不需要一个固定的格式！
不需要多余的操作就可以横向扩展的 ！ Map<String,Object> 使用键值对来控制！

> NoSQL 特点

解耦！
1、方便扩展（数据之间没有关系，很好扩展！）
2、大数据量高性能（Redis 一秒写8万次，读取11万，NoSQL的缓存记录级，是一种细粒度的缓存，性
能会比较高！）
3、数据类型是多样型的！（不需要事先设计数据库！随取随用！如果是数据量十分大的表，很多人就无
法设计了！）
4、传统 RDBMS 和 NoSQL

```bash
传统的 RDBMS
- 结构化组织
- SQL
- 数据和关系都存在单独的表中 row col
- 操作操作，数据定义语言
- 严格的一致性
- 基础的事务
-
.....

Nosql
- 不仅仅是数据
- 没有固定的查询语言
- 键值对存储，列存储，文档存储，图形数据库（社交关系）
- 最终一致性，
- CAP定理和BASE （异地多活） 初级架构师!
- 高性能，高可用，高可扩
-
....
```

> 了解：3V+3高

大数据时代的3V：主要是描述问题的

1. 海量Volume
2. 多样Variety
3. 实时Velocity
   大数据时代的3高：主要是对程序的要求
4. 高并发
5. 高可扩
6. 高性能
   真正在公司中的实践：NoSQL + RDBMS 一起使用才是最强的 !

## NoSQL的四大分类

KV键值对：

- 新浪：Redis
- 美团：Redis + Tair
- 阿里、百度：Redis + memecache


文档型数据库（bson格式 和json一样）：

- MongoDB （一般必须要掌握）
  - MongoDB 是一个基于分布式文件存储的数据库，C++ 编写，主要用来处理大量的文档！
  - MongoDB 是一个介于关系型数据库和非关系型数据中中间的产品！MongoDB 是非关系型数
    据库中功能最丰富，最像关系型数据库的！
  - ConthDB

列存储数据库

- HBase

- 分布式文件系统

  图关系数据库

  ![image-20200722165748765](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722165748765.png)

  - 他不是存图形，放的是关系，比如：朋友圈社交网络，广告推荐！
  - Neo4j，InfoGrid

> 四者对比！

![image-20200722165901821](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722165901821.png)

# Redis入门

## 概述

> Redis是什么？

Redis（Remote Dictionary Server )，即远程字典服务 !
是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，
并提供多种语言的API。
redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了
master-slave(主从)同步。
免费和开源！是当下最热门的 NoSQL 技术之一！也被人们称之为结构化数据库！

> Redis能干什么？

1、内存存储、持久化，内存中是断电即失、所以说持久化很重要（rdb、aof）
2、效率高，可以用于高速缓存
3、发布订阅系统
4、地图信息分析
5、计时器、计数器（浏览量！）
6、........

> 特征

1、多样的数据类型
2、持久化
3、集群
4、事务

![image-20200722170120426](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722170120426.png)

1、官网：https://redis.io/
2、中文网：http://www.redis.cn/
3、下载地址：通过官网下载即可！

4、 或者使用docker安装。建议更换端口，6379容易被挖矿。

[docker安装redis](https://gitee.com/cuixiaoyan/learningDocument/blob/master/docker/软件安装.md)

## 安装成功

```bash
# 查看启动容器的id
[root@centos8 ~]# docker ps 
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                              NAMES
c91b615aebc1        redis:6.0.5         "docker-entrypoint.s…"   44 minutes ago      Up 44 minutes       6379/tcp, 0.0.0.0:6666->6666/tcp   cxyredis
# 进入docker
[root@centos8 ~]# docker exec -it c91b615aebc1 /bin/bash
# 到bin目录下启动，如果有密码。auth "密码"
root@c91b615aebc1:/bin# redis-cli -p 6666
127.0.0.1:6666> auth "密码"
OK
127.0.0.1:6666> set name 2
OK
127.0.0.1:6666> get name
"2"
127.0.0.1:6666> 
```



## 测试性能

redis-benchmark 是一个压力测试工具！
官方自带的性能测试工具！
redis-benchmark 命令参数！
![image-20200722170829656](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722170829656.png)



## 基础知识

redis默认有16个数据库，默认使用第0个。

![image-20200722172602447](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200722172602447.png)

可以使用select进行切换数据库。

```bash
127.0.0.1:6666> select 1 #切换数据库
OK
127.0.0.1:6666[1]> dbsize #查看数据库大小
(integer) 0
127.0.0.1:6666[1]> set name 1
OK
127.0.0.1:6666[1]> keys * # 查看所有数据
1) "name"
127.0.0.1:6666[1]> flushall # 清空所有数据库(16个)
OK
127.0.0.1:6666[1]> flushdb # 清空当前库
```

> Redis 是单线程的！

明白Redis是很快的，官方表示，Redis是基于内存操作，CPU不是Redis性能瓶颈，Redis的瓶颈是根据
机器的内存和网络带宽，既然可以使用单线程来实现，就使用单线程了！所有就使用了单线程了！
Redis 是C 语言写的，官方提供的数据为 100000+ 的QPS，完全不比同样是使用 key-vale的
Memecache差！
Redis 为什么单线程还这么快？
1、误区1：高性能的服务器一定是多线程的？
2、误区2：多线程（CPU上下文会切换！）一定比单线程效率高！

先去CPU>内存>硬盘的速度要有所了解！
核心：redis 是将所有的数据全部放在内存中的，所以说使用单线程去操作效率就是最高的，多线程
（CPU上下文会切换：耗时的操作！！！），对于内存系统来说，如果没有上下文切换效率就是最高
的！多次读写都是在一个CPU上的，在内存情况下，这个就是最佳的方案！

# 五大数据类型

> 官网文档

![image-20200723154920895](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200723154920895.png)

>后面我们使用SpringBoot。Jedis，所有的方法，就是这些命令！

## Redis-key

```bash
127.0.0.1:6666> keys * # 查看所有key
(empty array)
127.0.0.1:6666> set name cxy # 存入一个字符串类型
OK
127.0.0.1:6666> keys *
1) "name"
127.0.0.1:6666> set age 1
OK
127.0.0.1:6666> keys *
1) "age"
2) "name"
127.0.0.1:6666> exists name # 判断当前key是否存在
(integer) 1
127.0.0.1:6666> exists name1
(integer) 0
127.0.0.1:6666> move name 1 # 移除当前key
(integer) 1
127.0.0.1:6666> keys *
1) "age"
127.0.0.1:6666> set name cuixiaoyan
OK
127.0.0.1:6666> keys *
1) "age"
2) "name"
127.0.0.1:6666> get name
"cuixiaoyan"
127.0.0.1:6666> expire name 10 # 设置key过期时间
(integer) 1
127.0.0.1:6666> ttl name # 查看key的剩余时间
(integer) 6
127.0.0.1:6666> ttl name 
(integer) 5
127.0.0.1:6666> ttl name 
(integer) -2
127.0.0.1:6666> get name
(nil)
127.0.0.1:6666> type age # 通过key查看类型
string
```

## string(字符串)

```bash
# 基本操作
127.0.0.1:6666> flushall # 清空redis
OK
127.0.0.1:6666> set key1 v1 
OK
127.0.0.1:6666> get key1
"v1"
127.0.0.1:6666> exists key1 # 判断key是否存在
(integer) 1
127.0.0.1:6666> append key1 "hello" # 追加字符串
(integer) 7
127.0.0.1:6666> get key1
"v1hello"
127.0.0.1:6666> strlen key1 # 通过key获取值的长度
(integer) 7
127.0.0.1:6666> append key1 "cxy"
(integer) 10
127.0.0.1:6666> strlen key1
(integer) 10
127.0.0.1:6666> get key1
"v1hellocxy"
# i++ 步长 i+=
127.0.0.1:6666> set views 0 # 初始化
OK
127.0.0.1:6666> get views
"0"
127.0.0.1:6666> incr views # incr 加一
(integer) 1
127.0.0.1:6666> incr views
(integer) 2
127.0.0.1:6666> decr views # decr 减一
(integer) 1
127.0.0.1:6666> decr views
(integer) 0
127.0.0.1:6666> incrby views 10 # incrby 加n
(integer) 10
127.0.0.1:6666> incrby views 10
(integer) 20
127.0.0.1:6666> decrby views 5 # decrby 减n
(integer) 15
# 字符串范围 range
127.0.0.1:6666> set key1 "hello,cuixiaoyan"
OK
127.0.0.1:6666> get key1
"hello,cuixiaoyan"
127.0.0.1:6666> getrange key1 0 3 # 截取字符串[0，3]
"hell"
127.0.0.1:6666> getrange key1 0 -1 # -1为全部，效果如同get key
"hello,cuixiaoyan"
127.0.0.1:6666> set key2 qqwsadascas
OK
127.0.0.1:6666> get key2
"qqwsadascas"
127.0.0.1:6666> setrange key2 1 xxx # 替换指定位置开始的字符串为 xxx
(integer) 11
127.0.0.1:6666> get key2
"qxxxadascas"
# 设置过期时间 setex(set with expire) 不存在时再进行设置(分布式锁中会使用到) setnx(set if not exist)
127.0.0.1:6666> setex key3 30 "hello" # 设置过期时间为30秒
OK
127.0.0.1:6666> ttl key3
(integer) 26
127.0.0.1:6666> ttl key3
(integer) 16
127.0.0.1:6666> setnx mykey "redis" # key不存在才会增加
(integer) 1
127.0.0.1:6666> keys *
1) "key2"
2) "views"
3) "mykey"
4) "key1"
127.0.0.1:6666> setnx mykey "MongoDB" # 替换失败
(integer) 0
127.0.0.1:6666> getrange mykey 0 -1 # 截取字符串，等同于get key
"redis"
127.0.0.1:6666> setnx mykey1 "MongoDB" # 新增成功
(integer) 1
127.0.0.1:6666> getrange mykey1 0 -1
"MongoDB"
# 设置多个值，mset,mget
127.0.0.1:6666> flushall #先清空
OK
127.0.0.1:6666> mset k1 v1 k2 v2 k3 v3 # 批量设置多个
OK
127.0.0.1:6666> keys *
1) "k3"
2) "k1"
3) "k2"
127.0.0.1:6666> mget k1 k2 k3 # 批量获取多个
1) "v1"
2) "v2"
3) "v3"
127.0.0.1:6666> msetnx k1 v1 k4 v4 #因为k1已经存在，不符合条件，原子性不满足，导致失败。
(integer) 0
127.0.0.1:6666> keys *
1) "k3"
2) "k1"
3) "k2"
# 设置一个对象，这里的key是一个巧妙的设计： user:{id}:{filed} , 如此设计在Redis中是完全可以的。
127.0.0.1:6666> mset user:1:name cxy user:1:age 2
OK
127.0.0.1:6666> mget user:1:name user:1:age
1) "cxy"
2) "2"
# getset 先get，再set。
127.0.0.1:6666> getset db redis # 第一次获取没有key，返回nil，将会赋值。
(nil)
127.0.0.1:6666> get db 
"redis"
127.0.0.1:6666> getset db mysql # 第二次有值之后，就会修改。
"redis"
127.0.0.1:6666> get db
"mysql"
```

数据结构是相同的！
String类似的使用场景：value除了是我们的字符串还可以是我们的数字！

- 计数器
- 统计多单位的数量
- 粉丝数
- 对象缓存存储

## list(列表)

所有的list命令都是用l开头的，Redis不区分大小命令。把list当成 ，栈、队列、阻塞队列！

```bash
127.0.0.1:6666> lpush list one # 新建list并从左插入，先进先出。可以同时多个值。
(integer) 1
127.0.0.1:6666> lpush list two
(integer) 2
127.0.0.1:6666> lpush list 3
(integer) 3
127.0.0.1:6666> lrange list 0 -1 # 获取list中的所有值。
1) "3"
2) "two"
3) "one"
127.0.0.1:6666> lrange list 0 1
1) "3"
2) "two"
127.0.0.1:6666> rpush list 5 # 从右插入，进来的在最后面，如同一个链表。
(integer) 4
127.0.0.1:6666> lrange list 0 -1
1) "3"
2) "two"
3) "one"
4) "5"
# 移除,lpop,rpop。
127.0.0.1:6666> lrange list 0 -1
1) "3"
2) "two"
3) "one"
4) "5"
127.0.0.1:6666> lpop list #从左移除第一个。
"3"
127.0.0.1:6666> rpop list # 从右移除第一个。
"5"
127.0.0.1:6666> lrange list 0 -1
1) "two"
2) "one"
# lindex
127.0.0.1:6666> lrange list 0 -1
1) "two"
2) "one"
127.0.0.1:6666> lindex list 0 # 通过下标获取值
"two"
127.0.0.1:6666> lindex list 1
"one"
127.0.0.1:6666> 
# llen
127.0.0.1:6666> llen list # 获取list长度
(integer) 2
# lrem 移除指定的值。上面lpop,rpop。只能移除最后的。
127.0.0.1:6666> lpush list 111
(integer) 3
127.0.0.1:6666> lpush list 222
(integer) 4
127.0.0.1:6666> lpush list 333
(integer) 5
127.0.0.1:6666> lrange list 0 -1
1) "333"
2) "222"
3) "111"
4) "two"
5) "one"
127.0.0.1:6666> lrem list 1 one # 移除一个one
(integer) 1
127.0.0.1:6666> lrange list 0 -1
1) "333"
2) "222"
3) "111"
4) "two"
127.0.0.1:6666> lpush list 333
(integer) 5
127.0.0.1:6666> lrem list 1 two
(integer) 1
127.0.0.1:6666> lrange list 0 -1
1) "333"
2) "333"
3) "222"
4) "111"
127.0.0.1:6666> lrem list 2 333 # 移除两个333
(integer) 2
127.0.0.1:6666> lrange list 0 -1
1) "222"
2) "111"
127.0.0.1:6666> lrem list 9 000 # 移除不存在的值，返回0，移除9个000
(integer) 0
# trim修剪，list截断。
127.0.0.1:6666> rpush list "hello"
(integer) 1
127.0.0.1:6666> rpush list "hello1"
(integer) 2
127.0.0.1:6666> rpush list "hello2"
(integer) 3
127.0.0.1:6666> rpush list "hello3"
(integer) 4
127.0.0.1:6666> ltrim list 1 2 # 通过下标截取。
OK
127.0.0.1:6666> lrange list 0 -1 # 查看全部
1) "hello1"
2) "hello2"
# rpoplpush 移除列表最后一个元素，并将其加入新的列表中。
127.0.0.1:6666> lrange list 0 -1 
1) "hello1"
2) "hello2"
3) "hello3"
127.0.0.1:6666> rpop list
"hello3"
127.0.0.1:6666> rpoplpush list mylist # 移除当前列表最后一个元素，将它加入新的列表中。
"hello2"
127.0.0.1:6666> lrange list 0 -1
1) "hello1"
127.0.0.1:6666> lrange mylist 0 -1 # 查看新的列表
1) "hello2"
# lset 将列表中指定下标替换成另一个值，更新操作。
127.0.0.1:6666> exists list # 判断key是否存在
(integer) 0
127.0.0.1:6666> lset list 0 item # 如果不存在，替换将会报错
(error) ERR no such key
127.0.0.1:6666> lpush list value1
(integer) 1
127.0.0.1:6666> lrange list 0 0
1) "value1"
127.0.0.1:6666> lset list 0 item # 更新成功。
OK
127.0.0.1:6666> lrange list 0 0
1) "item"
127.0.0.1:6666> lset list 1 other
(error) ERR index out of range
# linsert 将某个具体的value插入到列中某个元素的前面(before)或者后面(after)。
127.0.0.1:6666> rpush list "heloo"
(integer) 1
127.0.0.1:6666> rpush list "world"
(integer) 2
127.0.0.1:6666> linsert list before "world" "other" #在world前面增加
(integer) 3
127.0.0.1:6666> lrange list 0 -1
1) "heloo"
2) "other"
3) "world"
127.0.0.1:6666> linsert list after "world" "new" #在后面 
(integer) 4
127.0.0.1:6666> lrange list 0 -1
1) "heloo"
2) "other"
3) "world"
4) "new"
```

> 小结

- 他实际上是一个链表，before Node after ， left，right 都可以插入值

- 如果key 不存在，创建新的链表

- 如果key存在，新增内容

- 如果移除了所有值，空链表，也代表不存在！

- 在两边插入或者改动值，效率最高！ 中间元素，相对来说效率会低一点~

  **消息排队！消息队列（Lpush Rpop），栈（ Lpush Lpop）！**

## set(集合)

set中的值，是不可重复的,数据是无序的。

```bash
127.0.0.1:6666> sadd set "hello"
(integer) 1
127.0.0.1:6666> sadd set "redis"
(integer) 1
127.0.0.1:6666> sadd set "cuixiaoyan" # 添加元素到set中。
(integer) 1
127.0.0.1:6666> smembers set # 查看set中所有值。
1) "cuixiaoyan"
2) "hello"
3) "redis"
127.0.0.1:6666> sismember set hello # 判断set中是否有某个值
(integer) 1
127.0.0.1:6666> sismember set he
(integer) 0
127.0.0.1:6666> scard set # 获取set里值的数量
(integer) 3
# 删除 srem
127.0.0.1:6666> srem set "hello" # 删除
(integer) 1
127.0.0.1:6666> scard set 
(integer) 2
127.0.0.1:6666> smembers set
1) "cuixiaoyan"
2) "redis"
# set不重复集合，抽随机(抽奖等等)。
127.0.0.1:6666> smembers set
1) "woshi"
2) "cuixiaoyan"
3) "nihao"
4) "redis"
127.0.0.1:6666> srandmember set # 抽取一个
"woshi"
127.0.0.1:6666> srandmember set
"redis"
127.0.0.1:6666> srandmember set 2 # 抽取两个
1) "nihao"
2) "redis"
# 删除指定的key，随机删除key。
127.0.0.1:6666> spop set # 删除
"redis"
127.0.0.1:6666> smembers set
1) "woshi"
2) "cuixiaoyan"
3) "nihao"
# 将指定的值，移动到另一个set中。
127.0.0.1:6666> sadd set "ada" "asdad" # 添加多个值
(integer) 2
127.0.0.1:6666> smembers set # 查看所有值
1) "ada"
2) "woshi"
3) "cuixiaoyan"
4) "nihao"
5) "asdad"
127.0.0.1:6666> smove set myset "woshi" # 移动某个值
(integer) 1
127.0.0.1:6666> smembers set
1) "nihao"
2) "ada"
3) "cuixiaoyan"
4) "asdad"
127.0.0.1:6666> smembers myset
1) "woshi"
# 数字类集合
127.0.0.1:6666> sadd set1 a b c d e f 
(integer) 6
127.0.0.1:6666> sadd set2 q w e r t y
(integer) 6
127.0.0.1:6666> sdiff set1 set2 # 差集
1) "a"
2) "f"
3) "c"
4) "b"
5) "d"
127.0.0.1:6666> sinter set1 set2 # 交集
1) "e"
127.0.0.1:6666> sunion set1 set2 # 并集
 1) "y"
 2) "e"
 3) "d"
 4) "b"
 5) "a"
 6) "f"
 7) "w"
 8) "t"
 9) "q"
10) "c"
11) "r"
```

微博，A用户将所有关注的人放在一个set集合中！将它的粉丝也放在一个集合中！

共同关注，共同爱好，二度好友，推荐好友！（六度分割理论）

## hash(哈希)

Map集合，key-map! 时候这个值是一个map集合！ 本质和String类型没有太大区别，还是一个简单的
key-vlaue！

```bash
127.0.0.1:6666> hset hash u1 cxy # 设置单个值
(integer) 1
127.0.0.1:6666> hmset hash u2 ccc u3 sss # 设置多个值
OK
127.0.0.1:6666> hmget hash u1 u2 # 获取多个值
1) "cxy"
2) "ccc"
127.0.0.1:6666> hgetall hash # 获取所有值
1) "u1"
2) "cxy"
3) "u2"
4) "ccc"
5) "u3"
6) "sss"
127.0.0.1:6666> hdel hash u1 # 删除指定值
(integer) 1
127.0.0.1:6666> hgetall hash
1) "u2"
2) "ccc"
3) "u3"
4) "sss"
# hlen
127.0.0.1:6666> hmset hash u1 cxy u4 iii
OK
127.0.0.1:6666> hgetall hash
1) "u2"
2) "ccc"
3) "u3"
4) "sss"
5) "u1"
6) "cxy"
7) "u4"
8) "iii"
127.0.0.1:6666> hlen hash # 获取hash的长度
(integer) 4
# 判断set集合中是否存在某个值
127.0.0.1:6666> hexists hash u1
(integer) 1
127.0.0.1:6666> hexists hash 11
(integer) 0
# 只获取所有的key，和所有的value
127.0.0.1:6666> hkeys hash
1) "u2"
2) "u3"
3) "u1"
4) "u4"
127.0.0.1:6666> hvals hash
1) "ccc"
2) "sss"
3) "cxy"
4) "iii"
# 指定增量 hincrby
127.0.0.1:6666> hset hash u5 5
(integer) 1
127.0.0.1:6666> hincrby hash u5 10
(integer) 15
127.0.0.1:6666> hincrby hash u5 -10
(integer) 5
127.0.0.1:6666> hsetnx hash u6 122 # 不存在才会新增成功。
(integer) 1
127.0.0.1:6666> hsetnx hash u1 11
(integer) 0
```

hash变更的数据 user name age,尤其是是用户信息之类的，经常变动的信息！ hash 更适合于对象的
存储，String更加适合字符串存储！

## zset(有序集合)

在set的基础上，增加了一个类似于id的属性

```bash
127.0.0.1:6666> zadd zset 1 one # 增加一个，或多个
(integer) 1
127.0.0.1:6666> zadd zset 2 two 3 three
(integer) 2
127.0.0.1:6666> zrange zset 0 -1 # 查看所有zset
1) "one"
2) "two"
3) "three"
# zset排序
127.0.0.1:6666> zadd zset 2500 xiaobai
(integer) 1
127.0.0.1:6666> zadd zset 5000 zhangsan
(integer) 1
127.0.0.1:6666> zadd zset 500 cuixiaoyan
(integer) 1
127.0.0.1:6666> zrangebyscore zset -inf +inf # 从小到大进行排序，升序。
1) "cuixiaoyan"
2) "xiaobai"
3) "zhangsan"
127.0.0.1:6666> zrevrange zset 0 -1 # 从大到小进行排序，降序。
1) "zhangsan"
2) "xiaobai"
3) "cuixiaoyan"
127.0.0.1:6666> zrangebyscore zset -inf +inf withscores # 升序，并显示类似id的值。
1) "cuixiaoyan"
2) "500"
3) "xiaobai"
4) "2500"
5) "zhangsan"
6) "5000"
127.0.0.1:6666> zrangebyscore zset -inf 2500 withscores # 最大不超过两千五的。
1) "cuixiaoyan"
2) "500"
3) "xiaobai"
4) "2500"
# 移除元素rem
127.0.0.1:6666> zrange zset 0 -1 # 查看zset中所有值
1) "cuixiaoyan"
2) "xiaobai"
3) "zhangsan"
127.0.0.1:6666> zrem zset zhangsan # 删除指定值
(integer) 1
127.0.0.1:6666> zrange zset 0 -1
1) "cuixiaoyan"
2) "xiaobai"
127.0.0.1:6666> zcard zset # 获取个数
(integer) 2
127.0.0.1:6666> zadd zset 1 c 2 x 3 y
(integer) 3
127.0.0.1:6666> zcount zset 13
# 获取指定区间
127.0.0.1:6666> zadd zset 1 c 2 x 3 y
(integer) 3
127.0.0.1:6666> zcount zset 1 3
(integer) 3
127.0.0.1:6666> zcount zset 1 2
(integer) 2
```

案例思路：set 排序
存储班级成绩表，工资表排序！
普通消息，1， 重要消息 2，带权重进行判断！
排行榜应用实现，取Top N 测试！

# 三种特殊类型

## Geospatial 地理位置

朋友的定位，附近的人，打车距离计算？
Redis 的 Geo 在Redis3.2 版本就推出了！ 这个功能可以推算地理位置的信息，两地之间的距离，方圆
几里的人！
可以查询一些地理位置的测试数据：http://www.jsons.cn/lngcodeinfo/0706D99C19A781A3/
只有 六个命令：

![image-20200725204707728](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200725204707728.png)

官方文档：https://www.redis.net.cn/order/3685.html

> getadd

### getadd 添加地理位置

- 规则：两级无法直接添加，我们一般会下载城市数据，直接通过java程序一次性导入！

- 有效的经度从-180度到180度。

- 有效的纬度从-85.05112878度到85.05112878度。

- 当坐标位置超出上述指定范围时，该命令将会返回一个错误

```bash
127.0.0.1:6666> geoadd china:city 31.23 121.47 shanghai # 这里报错。
(error) ERR invalid longitude,latitude pair 31.230000,121.470000
127.0.0.1:6666> geoadd china:city 116.40 39.90 beijing # 下面格式才对。
(integer) 1
127.0.0.1:6666> geoadd china:city 121.47 31.23 shanghai
(integer) 1
127.0.0.1:6666> geoadd china:city 120.16 30.24 hangzhou
(integer) 1
127.0.0.1:6666> geoadd china:city 108.96 34.26 xian
(integer) 1
127.0.0.1:6666> geoadd china:city 113.66 34.75 zhengzhou
(integer) 1
# 获取当前坐标定位。
127.0.0.1:6666> geopos china:city beijing # 获取指定城市的经纬度。
1) 1) "116.39999896287918091"
   2) "39.90000009167092543"
127.0.0.1:6666> geopos china:city beijing shanghai
1) 1) "116.39999896287918091"
   2) "39.90000009167092543"
2) 1) "121.47000163793563843"
   2) "31.22999903975783553"
# geodist 两人之间的距离
# 单位 m，km，mi英里，ft英尺。
127.0.0.1:6666> geodist china:city beijing shanghai km # 北京到上海单位千米。
"1067.3788"
127.0.0.1:6666> geodist china:city beijing zhengzhou # 北京到郑州单位米。
"621882.2073"
127.0.0.1:6666> geodist china:city beijing zhengzhou km
"621.8822"
# georadius 以给定的经纬度为中心， 找出某一半径内的元素
# 我附近的人？ （获得所有附近的人的地址，定位！）通过半径来查询！
# 获得指定数量的人，200
# 所有数据应该都录入：china:city ，才会让结果更加请求
127.0.0.1:6666> georadius china:city 110 30 1000 km # 根据110 30 经纬度为坐标，寻找方圆1000km内的城市。
1) "xian"
2) "hangzhou"
3) "zhengzhou"
127.0.0.1:6666> georadius china:city 110 30 500 km
1) "xian"
127.0.0.1:6666> georadius china:city 110 30 500 km withdist # 显示范围内城市，加距离。
1) 1) "xian"
   2) "483.8340"
127.0.0.1:6666> georadius china:city 110 30 500 km withcoord # 显示他人的定位信息。
1) 1) "xian"
   2) 1) "108.96000176668167114"
      2) "34.25999964418929977"
127.0.0.1:6666> georadius china:city 110 30 1000 km withdist withcoord count 1 # 筛选出最近的一个结果。
1) 1) "xian"
   2) "483.8340"
   3) 1) "108.96000176668167114"
      2) "34.25999964418929977"
127.0.0.1:6666> georadius china:city 110 30 1000 km withdist withcoord 
1) 1) "xian"
   2) "483.8340"
   3) 1) "108.96000176668167114"
      2) "34.25999964418929977"
2) 1) "hangzhou"
   2) "977.5143"
   3) 1) "120.1600000262260437"
      2) "30.2400003229490224"
3) 1) "zhengzhou"
   2) "630.2160"
   3) 1) "113.65999907255172729"
      2) "34.74999926510690784"
127.0.0.1:6666> georadius china:city 110 30 1000 km withdist withcoord count 2 # 两个。
1) 1) "xian"
   2) "483.8340"
   3) 1) "108.96000176668167114"
      2) "34.25999964418929977"
2) 1) "zhengzhou"
   2) "630.2160"
   3) 1) "113.65999907255172729"
      2) "34.74999926510690784"
# 找出指定范围内的其他元素。通过a找b。
127.0.0.1:6666> georadiusbymember china:city beijing 1000 km 
1) "zhengzhou"
2) "beijing"
3) "xian"
127.0.0.1:6666> georadiusbymember china:city shanghai 400 km
1) "hangzhou"
2) "shanghai"
# geohash返回11位的字符串。将二维的经纬度，转换为一个字符串，两个字符串越相近，表示距离也越近。
127.0.0.1:6666> geohash china:city beijing zhengzhou
1) "wx4fbxxfke0"
2) "ww0vdqh9mv0"
# geo的底层就是zset，同理可以使用zset的命令。
127.0.0.1:6666> zrange china:city 0 -1
1) "xian"
2) "hangzhou"
3) "shanghai"
4) "zhengzhou"
5) "beijing"
127.0.0.1:6666> zrem china:city beijing
(integer) 1
127.0.0.1:6666> zrange china:city 0 -1
1) "xian"
2) "hangzhou"
3) "shanghai"
4) "zhengzhou"
```

## hyperloglog

> 什么是基数？

基数（cardinal number）在数学上，是[集合论](https://baike.baidu.com/item/集合论/494533)中刻画任意[集合](https://baike.baidu.com/item/集合/2908117)大小的一个概念。两个能够建立元素间一一对应的集合称为互相对等集合。例如3个人的集合和3匹马的集合可以建立[一一](https://baike.baidu.com/item/一一/2702379)[对应](https://baike.baidu.com/item/对应)，是两个[对等](https://baike.baidu.com/item/对等/4198791)的集合。

Redis 2.8.9 版本就更新了 Hyperloglog 数据结构！
Redis Hyperloglog 基数统计的算法！

优点：占用的内存是固定，2^64 不同的元素的技术，只需要废 12KB内存！如果要从内存角度来比较的
话 Hyperloglog 首选！
网页的 UV （一个人访问一个网站多次，但是还是算作一个人！）
传统的方式， set 保存用户的id，然后就可以统计 set 中的元素数量作为标准判断 !
这个方式如果保存大量的用户id，就会比较麻烦！我们的目的是为了计数，而不是保存用户id；
0.81% 错误率！ 统计UV任务，可以忽略不计的！

```bash
127.0.0.1:6666> pfadd key a b c d e f g h i j # 创建第一个
(integer) 1
127.0.0.1:6666> pfcount key 
(integer) 10
127.0.0.1:6666> pfadd key1 i j z x c v b n m 
(integer) 1
127.0.0.1:6666> pfcount key1
(integer) 9
127.0.0.1:6666> pfmerge key2 key key1 # 将两个合并
OK
127.0.0.1:6666> pfcount key2 # 看合并的数量
(integer) 15
```

如果允许容错，那么一定可以使用 Hyperloglog ！
如果不允许容错，就使用 set 或者自己的数据类型即可！

## bitmap

> 位存储。

统计用户信息，活跃，不活跃！
登录 、 未登录！ 打卡，365打卡！ 两个状态的，都可以使用
Bitmaps！
Bitmap 位图，数据结构！ 都是操作二进制位来进行记录，就只有0 和 1 两个状态！
365 天 = 365 bit 1字节 = 8bit 46 个字节左右！

使用bitmap 来记录 周一到周日的打卡！
周一：1 周二：0 周三：0 周四：1 ......

```bash
127.0.0.1:6666> setbit sign 0 1 # 是否打卡，0已打卡，1未打。(规则自己定。)
(integer) 0
127.0.0.1:6666> setbit sign 1 0
(integer) 0
127.0.0.1:6666> setbit sign 2 0
(integer) 0
127.0.0.1:6666> setbit sign 3 1
(integer) 0
127.0.0.1:6666> setbit sign 4 1
(integer) 0
127.0.0.1:6666> setbit sign 5 0
(integer) 0
127.0.0.1:6666> setbit sign 6 0
(integer) 0
127.0.0.1:6666> getbit sign 3 # 获取周三。
(integer) 1
127.0.0.1:6666> getbit sign 6
(integer) 0
127.0.0.1:6666> bitcount sign # 这周三个0，也就是打卡三天。
(integer) 3
```

# 事务

Redis 事务本质：一组命令的集合！
一个事务中的所有命令都会被序列化，在事务执行过程的中，会按照顺序执行！
一次性、顺序性、排他性！执行一些列的命令！

Redis事务没有没有隔离级别的概念！
所有的命令在事务中，并没有直接被执行！只有发起执行命令的时候才会执行！Exec
Redis单条命令式保存原子性的，但是事务不保证原子性！
redis的事务：

- 开启事务（multi）
- 命令入队（......）
- 执行事务（exec）

```bash
# 正常执行事务。
127.0.0.1:6666> multi
OK
127.0.0.1:6666> set k1 v1 
QUEUED
127.0.0.1:6666> set k2 v2 
QUEUED
127.0.0.1:6666> get k2
QUEUED
127.0.0.1:6666> set k3 v3 
QUEUED
127.0.0.1:6666> exec
1) OK
2) OK
3) "v2"
4) OK
# 放弃事务。
127.0.0.1:6666> multi # 开启事务。
OK
127.0.0.1:6666> set k1 v1 
QUEUED
127.0.0.1:6666> set k2 v2 
QUEUED
127.0.0.1:6666> set k4 v4 
QUEUED
127.0.0.1:6666> discard # 放弃事务。
OK
127.0.0.1:6666> get k4 # 所有队列中的操作都未执行。
(nil)
# 编译型异常（代码有问题！ 命令有错！） ，事务中所有的命令都不会被执行
127.0.0.1:6666> multi 
OK
127.0.0.1:6666> set k1 v1 
QUEUED
127.0.0.1:6666> set k2 v2 
QUEUED
127.0.0.1:6666> set k3 v3 
QUEUED
127.0.0.1:6666> getset k3 # 执行了错误的命令。
(error) ERR wrong number of arguments for 'getset' command
127.0.0.1:6666> set k4 v4 
QUEUED
127.0.0.1:6666> exec
(error) EXECABORT Transaction discarded because of previous errors.
127.0.0.1:6666> get k4 # 所有的命令都不会执行。
(nil)
# 运行时异常（1/0）， 如果事务队列中存在语法性，那么执行命令的时候，其他命令是可以正常执行的，错误命令抛出异常！
127.0.0.1:6666> set k1 v1 # 设置一个非数字型的。
OK
127.0.0.1:6666> multi 
OK
127.0.0.1:6666> incr k1 # 加1，v1无法加1，但是这里编译通过。
QUEUED
127.0.0.1:6666> set k2 v2 
QUEUED
127.0.0.1:6666> set k3 v3 
QUEUED
127.0.0.1:6666> get k3 
QUEUED
127.0.0.1:6666> exec # 执行事务。
1) (error) ERR value is not an integer or out of range # 运行时报错，不会影响到其他操作。
2) OK
3) OK
4) "v3"
127.0.0.1:6666> mget k2 k3
1) "v2"
2) "v3"
```

> 监控！ Watch 

悲观锁：

- 很悲观，认为什么时候都会出问题，无论做什么都会加锁！

乐观锁：

- 很乐观，认为什么时候都不会出问题，所以不会上锁！ 更新数据的时候去判断一下，在此期间是否
  有人修改过这个数据，
- 获取version
- 更新的时候比较 version

> redis监控测试。

```bash
# 正常操作。
127.0.0.1:6666> set money 100 # 设置总金额。
OK
127.0.0.1:6666> set out 0 # 已消费金额。
OK
127.0.0.1:6666> watch money # 监控金额。
OK
127.0.0.1:6666> multi  # 开启事务。
OK
127.0.0.1:6666> decrby money 20 # 减。
QUEUED
127.0.0.1:6666> incrby out 20 # 加。
QUEUED
127.0.0.1:6666> exec # 执行事务，正常执行。
1) (integer) 80
2) (integer) 20
# 测试多线程修改值 , 使用watch 可以当做redis的乐观锁操作！
127.0.0.1:6666> watch money #监控
OK
127.0.0.1:6666> multi 
OK
127.0.0.1:6666> decrby money 10
QUEUED
127.0.0.1:6666> incrby out 10
QUEUED
127.0.0.1:6666> exec # 未执行前，money被另外线程修改。
(error) EXECABORT Transaction discarded because of previous errors.
# 另外线程
[root@centos8 ~]# docker ps 
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                              NAMES
c91b615aebc1        redis:6.0.5         "docker-entrypoint.s…"   3 days ago          Up About an hour    6379/tcp, 0.0.0.0:6666->6666/tcp   cxyredis
[root@centos8 ~]# docker exec -it c91b615aebc1 /bin/bash
root@c91b615aebc1:/data# cd /bin
root@c91b615aebc1:/bin# redis-cli -p 6666
127.0.0.1:6666> auth "cxy0809."
OK
127.0.0.1:6666> keys *
1) "out"
2) "money"
127.0.0.1:6666> get money
"80"
127.0.0.1:6666> decrby money 10 # 修改操作。
(integer) 70
# 如果修改失败，获取最新的值就好。
127.0.0.1:6666> unwatch # 解除监控。
OK
127.0.0.1:6666> watch money # 重新监控。
OK
127.0.0.1:6666> multi
OK
127.0.0.1:6666> decrby money 1
QUEUED
127.0.0.1:6666> incrby money 1
QUEUED
127.0.0.1:6666> exec # 执行成功，再没有其他线程打扰到情况下。
1) (integer) 69
2) (integer) 70
```

# jedis

什么是Jedis 是 Redis 官方推荐的 java连接开发工具！ 使用Java 操作Redis 中间件！如果你要使用
java操作redis，那么一定要对Jedis 十分的熟悉! 两者的命令一样。

1、导入依赖

```xml
		// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.11.1'
    // https://mvnrepository.com/artifact/redis.clients/jedis
    compile group: 'redis.clients', name: 'jedis', version: '3.3.0'
```

2、编码测试

- 连接数据库
- 操作命令
- 断开连接

```java
package com.cxy.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {
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


}

```

## 常用api

所有的api命令，就是我们对应的上面学习的指令，一个都没有变化！如上，其实就是中文api。

## 事务

```java
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
```

# springboot整合

SpringBoot 操作数据：spring-data jpa jdbc mongodb redis！
SpringData 也是和 SpringBoot 齐名的项目！
说明： 在 SpringBoot2.x 之后，原来使用的jedis 被替换为了 lettuce?
jedis : 采用的直连，多个线程操作的话，是不安全的，如果想要避免不安全的，使用 jedis pool 连接
池！ 更像 BIO 模式
lettuce : 采用netty，实例可以再多个线程中进行共享，不存在线程不安全的情况！可以减少线程数据
了，更像 NIO 模式
**源码分析：**

![image-20200727164542138](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200727164542138.png)

```java
@Bean
@ConditionalOnMissingBean(name ="redisTemplate") // 我们可以自己定义一个redisTemplate来替换这个默认的！
public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactoryredisConnectionFactory)throws UnknownHostException {
// 默认的 RedisTemplate 没有过多的设置，redis 对象都是需要序列化！
// 两个泛型都是 Object, Object 的类型，我们后使用需要强制转换 <String, Object>
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
@Bean
@ConditionalOnMissingBean // 由于 String 是redis中最常使用的类型，所以说单独提出来了一个bean！
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
    StringRedisTemplate template = new StringRedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
```

## 整合测试一下

```java
// 引入依赖
implementation 'org.springframework.boot:spring-boot-starter-data-redis' 
// 配置文件
  spring:
  redis:
    host: 192.168.106.129
    port: 6666
    password: 密码
//测试用例
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
```

## 序列化问题

![image-20200727170936597](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200727170936597.png)

默认使用的jdk格式化，这里我们需要更换成自己json格式化。

### 对象保存

报错：序列化问题。

![image-20200727172120633](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200727172120633.png)

解决：添加如下配置。

![image-20200727172606879](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200727172606879.png)

我们来编写一个自己的 RedisTemplete

```java
package com.cxy.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: redis
 * @description: 常用模版。
 * @author: cuixy
 * @create: 2020-07-27 17:30
 **/
@Configuration
public class RedisConfig {
    // 自己定义了一个 RedisTemplate
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 我们为了自己开发方便，一般直接使用
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // Json序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
                Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // String 的序列化
        StringRedisSerializer stringRedisSerializer = new
                StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
```

![image-20200727173523672](https://gitee.com/cuixiaoyan/uPic/blob/master/uPic/image-20200727173523672.png)

所有的redis操作，其实对于java开发人员来说，十分的简单，更重要是要去理解redis的思想和每一种数
据结构的用处和作用场景！

# Redis.conf详解

启动的时候就是通过配置文件来启动。

> 单位

![image-20200728134828837](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728134828837.png)

1、配置文件unit单位，对大小不敏感。

![image-20200728134932892](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728134932892.png)

就好比我们学习spring、improt、include(包括)。

> 网络

```bash
bind 127.0.0.1 # 绑定的ip。
protected-mode yes # 保护模式。
port 6379(我这里是6666)
```

> 通用general

```bash
daemonize yes # 以守护进程的方式运行，默认是 no，我们需要自己开启为yes！
pidfile /var/run/redis_6379.pid # 如果以后台的方式运行，我们就需要指定一个 pid 文件！
# 日志
# Specify the server verbosity level.
# This can be one of:
# debug (a lot of information, useful for development/testing)
# verbose (many rarely useful info, but not a mess like the debug level)
# notice (moderately verbose, what you want in production probably) 生产环境
# warning (only very important / critical messages are logged)
loglevel notice
logfile "" # 日志的文件位置名
databases 16 # 数据库的数量，默认是 16 个数据库
always-show-logo yes # 是否总是显示LOGO
```

> 快照

持久化，
在规定的时间内，执行了多少次操作，则会持久化到文件 .rdb. aof
redis 是内存数据库，如果没有持久化，那么数据断电及失！

```bash
# 如果900s内，如果至少有一个1 key进行了修改，我们及进行持久化操作
save 900 1
# 如果300s内，如果至少10 key进行了修改，我们及进行持久化操作
save 300 10
# 如果60s内，如果至少10000 key进行了修改，我们及进行持久化操作
save 60 10000
# 我们之后学习持久化，会自己定义这个测试！
stop-writes-on-bgsave-error yes # 持久化如果出错，是否还需要继续工作！
rdbcompression yes # 是否压缩 rdb 文件，需要消耗一些cpu资源！
rdbchecksum yes # 保存rdb文件的时候，进行错误的检查校验！
dir ./ # rdb 文件保存的目录
```

>SECURITY 安全

可以在这里设置redis的密码，默认是没有密码！

```bash
 requirepass 密码
```

> 限制 CLIENTS

```bash
maxclients 10000 # 设置能连接上redis的最大客户端的数量
maxmemory <bytes> # redis 配置最大的内存容量
maxmemory-policy noeviction # 内存到达上限之后的处理策略
1、volatile-lru：只对设置了过期时间的key进行LRU（默认值）
2、allkeys-lru ： 删除lru算法的key
3、volatile-random：随机删除即将过期key
4、allkeys-random：随机删除
5、volatile-ttl ： 删除即将过期的
6、noeviction ： 永不过期，返回错误
```

>APPEND ONLY 模式 aof配置

```bash
appendonly no # 默认是不开启aof模式的，默认是使用rdb方式持久化的，在大部分所有的情况下，
rdb完全够用！
appendfilename "appendonly.aof" # 持久化的文件的名字
# appendfsync always # 每次修改都会 sync。消耗性能
appendfsync everysec # 每秒执行一次 sync，可能会丢失这1s的数据！
# appendfsync no 
# 不执行 sync，这个时候操作系统自己同步数据，速度最快!
```

# Redis持久化

Redis 是内存数据库，如果不将内存中的数据库状态保存到磁盘，那么一旦服务器进程退出，服务器中
的数据库状态也会消失。所以 Redis 提供了持久化功能！

## RDB（Redis DataBase）

> 什么是rdb

在主从复制中，rdb就是备用了！从机上面！

![image-20200728143536157](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728143536157.png)

在指定的时间间隔内将内存中的数据集快照写入磁盘，也就是行话讲的Snapshot快照，它恢复时是将快
照文件直接读到内存里。
Redis会单独创建（fork）一个子进程来进行持久化，会先将数据写入到一个临时文件中，待持久化过程
都结束了，再用这个临时文件替换上次持久化好的文件。整个过程中，主进程是不进行任何IO操作的。
这就确保了极高的性能。如果需要进行大规模数据的恢复，且对于数据恢复的完整性不是非常敏感，那
RDB方式要比AOF方式更加的高效。RDB的缺点是最后一次持久化后的数据可能丢失。我们默认的就是
RDB，一般情况下不需要修改这个配置！
有时候在生产环境我们会将这个文件进行备份！
rdb保存的文件是dump.rdb
都是在我们的配置文件中快照中进行配置的!

这里我是使用的docker安装的，所以将持久化配置文件，挂载了出来。

![image-20200728143713672](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728143713672.png)

### 修改间隔

![image-20200728144052767](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728144052767.png)

> 触发机制

1、save的规则满足的情况下，会自动触发rdb规则
2、执行 flushall 命令，也会触发我们的rdb规则！
3、退出redis，也会产生 rdb 文件！备份就自动生成一个 dump.rdb

将原本的rdb文件删除，进行测试，执行五次操作，成功生成文件。

>如果恢复rdb文件！

1、只需要将rdb文件放在我们redis启动目录就可以，redis启动的时候会自动检查dump.rdb 恢复其中
的数据！
2、查看需要存在的位置

```bash
127.0.0.1:6666> config get dir
1) "dir"
2) "/data"
```

**优点：**
1、适合大规模的数据恢复！
2、对数据的完整性要求不高！
**缺点：**
1、需要一定的时间间隔进程操作！如果redis意外宕机了，这个最后一次修改数据就没有的了！
2、fork进程的时候，会占用一定的内存空间！

## AOF（Append Only File)

将我们的所有命令都记录下来，history，恢复的时候就把这个文件全部在执行一遍!

![image-20200728151625079](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728151625079.png)

以日志的形式来记录每个写操作，将Redis执行过的所有指令记录下来（读操作不记录），只许追加文件
但不可以改写文件，redis启动之初会读取该文件重新构建数据，换言之，redis重启的话就根据日志文件
的内容将写指令从前到后执行一次以完成数据的恢复工作。

Aof保存的是 appendonly.aof 文件

![image-20200728151807138](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200728151807138.png)

默认是不开启的，我们需要手动进行配置！我们只需要将 appendonly 改为yes就开启了 aof！
重启，redis 就可以生效了！
如果这个 aof 文件有错位，这时候 redis 是启动不起来的吗，我们需要修复这个aof文件
redis 给我们提供了一个工具 redis-check-aof --fix

**redis-check-aof --fix appendonly.aof**

如果文件正常，重启就可以直接恢复了！

> 重写规则

aof 默认就是文件的无限追加，文件会越来越大！

```bash
no-appendfsync-on-rewrite no 

auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb
```

如果 aof 文件大于 64m，太大了！ fork一个新的进程来将我们的文件进行重写！

>优点和缺点！

```bash
appendonly no # 默认是不开启aof模式的，默认是使用rdb方式持久化的，在大部分所有的情况下，
rdb完全够用！
appendfilename "appendonly.aof" # 持久化的文件的名字
# appendfsync always # 每次修改都会 sync。消耗性能
appendfsync everysec # 每秒执行一次 sync，可能会丢失这1s的数据！
# appendfsync no 
# 不执行 sync，这个时候操作系统自己同步数据，速度最快！
# rewrite 重写，
```

优点：
1、每一次修改都同步，文件的完整会更加好！
2、每秒同步一次，可能会丢失一秒的数据
3、从不同步，效率最高的！
缺点：
1、相对于数据文件来说，aof远远大于 rdb，修复的速度也比 rdb慢！
2、Aof 运行效率也要比 rdb 慢，所以我们redis默认的配置就是rdb持久化!

**扩展：**
1、RDB 持久化方式能够在指定的时间间隔内对你的数据进行快照存储
2、AOF 持久化方式记录每次对服务器写的操作，当服务器重启的时候会重新执行这些命令来恢复原始
的数据，AOF命令以Redis 协议追加保存每次写的操作到文件末尾，Redis还能对AOF文件进行后台重
写，使得AOF文件的体积不至于过大。
3、只做缓存，如果你只希望你的数据在服务器运行的时候存在，你也可以不使用任何持久化
4、同时开启两种持久化方式。在这种情况下，当redis重启的时候会优先载入AOF文件来恢复原始的数据，因为在通常情况下AOF文件保存的数据集要比RDB文件保存的数据集要完整。RDB 的数据不实时，同时使用两者时服务器重启也只会找AOF文件，那要不要只使用AOF呢？作者建议不要，因为RDB更适合用于备份数据库（AOF在不断变化不好备份），快速重启，而且不会有AOF可能潜在的Bug，留着作为一个万一的手段。
5、性能建议因为RDB文件只用作后备用途，建议只在Slave上持久化RDB文件，而且只要15分钟备份一次就够了，只保留 save 900 1 这条规则。如果Enable AOF ，好处是在最恶劣情况下也只会丢失不超过两秒数据，启动脚本较简单只load自己的AOF文件就可以了，代价一是带来了持续的IO，二是AOF rewrite 的最后将 rewrite 过程中产生的新数据写到新文件造成的阻塞几乎是不可避免的。只要硬盘许可，应该尽量减少AOF rewrite的频率，AOF重写的基础大小默认值64M太小了，可以设到5G以上，默认超过原大小100%大小重写可以改到适当的数值。如果不Enable AOF ，仅靠 Master-Slave Repllcation 实现高可用性也可以，能省掉一大笔IO，也减少了rewrite时带来的系统波动。代价是如果Master/Slave 同时倒掉，会丢失十几分钟的数据，启动脚本也要比较两个 Master/Slave 中的 RDB文件，载入较新的那个，微博就是这种架构。

# Redis发布订阅

Redis 发布订阅(pub/sub)是一种消息通信模式：发送者(pub)发送消息，订阅者(sub)接收消息。微信、
微博、关注系统！
Redis 客户端可以订阅任意数量的频道。
订阅/发布消息图：
第一个：消息发送者， 第二个：频道
第三个：消息订阅者！

![image-20200729144936899](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729144936899.png)

下图展示了频道 channel1 ， 以及订阅这个频道的三个客户端 —— client2 、 client5 和 client1 之间的
关系：

![image-20200729145005717](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729145005717.png)

当有新消息通过 PUBLISH 命令发送给频道 channel1 时， 这个消息就会被发送给订阅它的三个客户端。

![image-20200729145015326](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729145015326.png)

> 命令

这些命令被广泛用于构建即时通信应用，比如网络聊天室(chatroom)和实时广播、实时提醒等。

![image-20200729145342060](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729145342060.png)

> 测试

订阅端：（消费者）

```bash
127.0.0.1:6666> subscribe cxy #订阅一个频道
Reading messages... (press Ctrl-C to quit)
1) "subscribe"
2) "cxy"
3) (integer) 1
# 等待读取推送的消息
1) "message" # 消息
2) "cxy" # 哪个频道
3) "hello,cuixiaoyan" # 消息内容
1) "message"
2) "cxy"
3) "hello,java"
```

发送端：（生产者）

```bash
127.0.0.1:6666> publish cxy "hello,cuixiaoyan" # 发布者发布消息到频道
(integer) 1
127.0.0.1:6666> publish cxy "hello,java"
(integer) 1
```

> 原理

Redis是使用C实现的，通过分析 Redis 源码里的 pubsub.c 文件，了解发布和订阅机制的底层实现，籍
此加深对 Redis 的理解。

Redis 通过 PUBLISH 、SUBSCRIBE 和 PSUBSCRIBE 等命令实现发布和订阅功能。
微信：
通过 SUBSCRIBE 命令订阅某频道后，redis-server 里维护了一个字典，字典的键就是一个个 频道！，
而字典的值则是一个链表，链表中保存了所有订阅这个 channel 的客户端。SUBSCRIBE 命令的关键，
就是将客户端添加到给定 channel 的订阅链表中。

通过 PUBLISH 命令向订阅者发送消息，redis-server 会使用给定的频道作为键，在它所维护的 channel
字典中查找记录了订阅这个频道的所有客户端的链表，遍历这个链表，将消息发布给所有订阅者。

Pub/Sub 从字面上理解就是发布（Publish）与订阅（Subscribe），在Redis中，你可以设定对某一个
key值进行消息发布及消息订阅，当一个key值上进行了消息发布后，所有订阅它的客户端都会收到相应
的消息。这一功能最明显的用法就是用作实时消息系统，比如普通的即时聊天，群聊等功能。

使用场景：
1、实时消息系统！
2、事实聊天！（频道当做聊天室，将信息回显给所有人即可！）
3、订阅，关注系统都是可以的！
稍微复杂的场景我们就会使用 消息中间件 MQ （）

# Redis主从复制

## 概念

主从复制，是指将一台Redis服务器的数据，复制到其他的Redis服务器。前者称为主节点
(master/leader)，后者称为从节点(slave/follower)；数据的复制是单向的，只能由主节点到从节点。
Master以写为主，Slave 以读为主。

默认情况下，每台Redis服务器都是主节点；
且一个主节点可以有多个从节点(或没有从节点)，但一个从节点只能有一个主节点。（）

**主从复制的作用主要包括：**

1、数据冗余：主从复制实现了数据的热备份，是持久化之外的一种数据冗余方式。
2、故障恢复：当主节点出现问题时，可以由从节点提供服务，实现快速的故障恢复；实际上是一种服务
的冗余。
3、负载均衡：在主从复制的基础上，配合读写分离，可以由主节点提供写服务，由从节点提供读服务
（即写Redis数据时应用连接主节点，读Redis数据时应用连接从节点），分担服务器负载；尤其是在写
少读多的场景下，通过多个从节点分担读负载，可以大大提高Redis服务器的并发量。
4、高可用（集群）基石：除了上述作用以外，主从复制还是哨兵和集群能够实施的基础，因此说主从复
制是Redis高可用的基础。

一般来说，要将Redis运用于工程项目中，只使用一台Redis是万万不能的（宕机），原因如下：
1、从结构上，单个Redis服务器会发生单点故障，并且一台服务器需要处理所有的请求负载，压力较大；
2、从容量上，单个Redis服务器内存容量有限，就算一台Redis服务器内存容量为256G，也不能将所有内存用作Redis存储内存，一般来说，单台Redis最大使用内存不应该超过20G。
电商网站上的商品，一般都是一次上传，无数次浏览的，说专业点也就是"多读少写"。

主从复制，读写分离！ 80% 的情况下都是在进行读操作！减缓服务器的压力！架构中经常使用！
一主二从！
只要在公司中，主从复制就是必须要使用的，因为在真实的项目中不可能单机使用Redis！

![image-20200729152111778](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729152111778.png)

## 环境配置

只配置从库，不用配置主库！

```bash
127.0.0.1:6666> info replication # 查看信息
# Replication
role:master # 主机
connected_slaves:0 # 没有从机
master_replid:357d2d5730c8f29b586b06dd76549fcb3d49c172
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
```

复制三个配置文件，修改对应信息。

![image-20200729153349164](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200729153349164.png)

1、端口
2、pid 名字
3、log文件名字
4、dump.rdb 名字
修改完毕之后，启动我们的3个redis服务器，可以通过进程信息查看。

```bash
# 普通方式
port 6378
pidfile /var/run/redis_6378.pid
logfile "/dev/redis78.log"
dbfilename dump6378.rdb
# docker方式-----------------------------------------------------------------------------------------------
# 创建属于redis的集群网络------------------------------------------------------------------------------------
docker network create redis-cluster-net
# 查看ip 172.18.0.0----------------------------------------------------------------------------------------
[root@centos8 ~]# docker network inspect redis-cluster-net
[
    {
        "Name": "redis-cluster-net",
        "Id": "c3550af56a4c5a4894e04963b5b747361122e3666f58bd1e88e854f4b295f316",
        "Created": "2020-07-29T04:42:39.479861603-04:00",
        "Scope": "local",
        "Driver": "bridge",
        "EnableIPv6": false,
        "IPAM": {
            "Driver": "default",
            "Options": {},
            "Config": [
                {
                    "Subnet": "172.18.0.0/16",
                    "Gateway": "172.18.0.1"
                }
            ]
        },
        "Internal": false,
        "Attachable": false,
        "Ingress": false,
        "ConfigFrom": {
            "Network": ""
        },
        "ConfigOnly": false,
        "Containers": {},
        "Options": {},
        "Labels": {}
    }
]
# 编写模版文件名为：redis-cluster.tmpl ，路径放在 /usr/local/database/redis/redis-cluster ---------------------
# 基本配置
protected-mode yes
port ${port}
bind 0.0.0.0 
tcp-backlog 511
timeout 0
tcp-keepalive 300
daemonize no
supervised no
pidfile /var/run/redis_${port}.pid
loglevel notice
logfile ""
databases 16
always-show-logo yes
save 900 1
save 300 10
save 60 10000
stop-writes-on-bgsave-error yes
rdbcompression yes
rdbchecksum yes
dbfilename dump${port}.rdb
rdb-del-sync-files no
dir ./
replica-serve-stale-data yes
replica-read-only yes
repl-diskless-sync no
repl-diskless-sync-delay 5
repl-disable-tcp-nodelay no
replica-priority 100
acllog-max-len 128

 # requirepass 
lazyfree-lazy-eviction no
lazyfree-lazy-expire no
lazyfree-lazy-server-del no
replica-lazy-flush no
lazyfree-lazy-user-del no


appendonly no

appendfilename "appendonly.aof"

appendfsync everysec


auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb


aof-load-truncated yes


aof-use-rdb-preamble yes

lua-time-limit 5000
slowlog-log-slower-than 10000
slowlog-max-len 128
latency-monitor-threshold 0
notify-keyspace-events ""
hash-max-ziplist-entries 512
hash-max-ziplist-value 64


list-max-ziplist-size -2


list-compress-depth 0

set-max-intset-entries 512

zset-max-ziplist-entries 128
zset-max-ziplist-value 64

hll-sparse-max-bytes 3000

stream-node-max-bytes 4096
stream-node-max-entries 100

activerehashing yes
hz 10
dynamic-hz yes



# 创建配置脚本-----------------------------------------------------------------------------------------------

# 主目录
dir_redis_cluster='/usr/local/database/redis/redis-cluster'
# docker redis集群网关 gateway='172.18.0.1'
# 节点地址号 从2开始
idx=1
# 逐个创建各节点目录和配置文件 三个
for port in `seq 7000 7002`; do
    # 创建存放redis数据路径
    mkdir -p ${dir_redis_cluster}/${port}/data;
    # 通过模板个性化各个节点的配置文件
    idx=$(($idx+1));
    port=${port} ip=`echo ${gateway} | sed "s/1$/$idx/g"` \
        envsubst < ${dir_redis_cluster}/redis-cluster.tmpl \
        > ${dir_redis_cluster}/${port}/redis-${port}.conf
done
# 配置并启动-----------------------------------------------------------------------------------------------
# 创建容器配置并运行 redis.conf后面你的版本，默认是最新。
for port in `seq 7000 7002`; do
    docker run --name redis-${port} --net redis-cluster-net -d \
        -p ${port}:${port} -p 1${port}:1${port} \
        -v ${dir_redis_cluster}/${port}/data:/data \
        -v ${dir_redis_cluster}/${port}/redis-${port}.conf:/usr/local/etc/redis/redis.conf redis \
        redis-server /usr/local/etc/redis/redis.conf
done
# 查看集群功能是否开启，这里需要让它不成功 info cluster-----------------------------------------------------------
[root@centos8 ~]# docker exec -it redis-7000 redis-cli -p 7000 info cluster
# Cluster
cluster_enabled:0
# 其他操作(注意自己的路径)--------------------------------------------------------------------------
#!/bin/bash
# 外部输入命令
com=$1
# 主目录
dir_redis_cluster='/usr/local/database/redis/redis-cluster'
# redis集群网关
gateway='172.18.0.1'

case ${com} in
	create)
        idx=1;
		for port in `seq 7000 7005`; do
            # 创建存放redis数据路径
			mkdir -p ${dir_redis_cluster}/${port}/data;
            # 通过模板个性化各个节点的配置文件
            idx=$(($idx+1));
            port=${port} ip=`echo ${gateway} | sed "s/1$/$idx/g"` \
                envsubst < ${dir_redis_cluster}/redis-cluster.tmpl \
                > ${dir_redis_cluster}/${port}/redis-${port}.conf
		done
	;;
    build)
        # 创建容器配置并运行
        for port in `seq 7000 7005`; do
            docker run --name redis-${port} --net redis-cluster-net -d \
            	-p ${port}:${port} -p 1${port}:1${port} \
                -v ${dir_redis_cluster}/${port}/data:/data \
                -v ${dir_redis_cluster}/${port}/redis-${port}.conf:/usr/local/etc/redis/redis.conf redis \
                redis-server /usr/local/etc/redis/redis.conf
        done
    ;;
    start | begin)
        # 运行容器
    	for port in `seq 7000 7002`; do
            docker start redis-${port}
        done
    ;;
    stop | end)
        # 停止容器运行
        for port in `seq 7000 7002`; do
            docker stop redis-${port}
        done
    ;;
    rm)
        # 删除已有容器
        for port in `seq 7000 7002`; do
            docker rm redis-${port}
        done
    ;;
    restart)
        # 重启已有容器
    	for port in `seq 7000 7002`; do
            docker restart redis-${port}
        done
    ;;
    destroy)
        # 删除集群目录及配置
        for port in `seq 7000 7002`; do
            rm -rf ${dir_redis_cluster}/${port}
        done
    ;;
    *)
        echo "Usage:	./build [create|build|start|stop|rm|restart|destroy]"
    ;;
esac

```

## 一丛二主

默认情况下，每台Redis服务器都是主节点； 我们一般情况下只用配置从机就好了！
认老大！
一主 （70）二从（71，72）启动三个容器。

```bash
[root@centos8 redis-cluster]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                                                        NAMES
2157b7f9d97d        redis               "docker-entrypoint.s…"   5 seconds ago       Up 4 seconds        0.0.0.0:7002->7002/tcp, 6379/tcp, 0.0.0.0:17002->17002/tcp   redis-7002
f1ac84714bf7        redis               "docker-entrypoint.s…"   6 seconds ago       Up 4 seconds        0.0.0.0:7001->7001/tcp, 6379/tcp, 0.0.0.0:17001->17001/tcp   redis-7001
0db76b9cbe64        redis               "docker-entrypoint.s…"   6 seconds ago       Up 5 seconds        0.0.0.0:7000->7000/tcp, 6379/tcp, 0.0.0.0:17000->17000/tcp   redis-7000
# 重点如下。-------------------------------------------------------------------------------------------------
# 主机
127.0.0.1:7000> info replication #查看主从信息
# Replication
role:master
connected_slaves:2
slave0:ip=172.18.0.1,port=7001,state=online,offset=392,lag=0
slave1:ip=172.18.0.1,port=7002,state=online,offset=392,lag=1
master_replid:e2c07eadf81344899ffd7cec60036686885c2947
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:392
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:392
# 从机，得用ip才行，我真是服了。就算是本机127也不行。
[root@centos8 ~]# docker exec -it redis-7001 /bin/bash
root@cb475fe3b9e0:/data# redis-cli -h 192.168.106.129 -p 7001
192.168.106.129:7001> info replication
# Replication
role:master
connected_slaves:0
master_replid:868aadcb711e66461f5cd50b5ef59cf9cacbb26c
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
192.168.106.129:7001> SLAVEOF 192.168.106.129 7000 #设置为从机，二号机也是一样。
OK
192.168.106.129:7001> info replication 
# Replication
role:slave
master_host:192.168.106.129
master_port:7000
master_link_status:up
master_last_io_seconds_ago:3
master_sync_in_progress:0
slave_repl_offset:336
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:e2c07eadf81344899ffd7cec60036686885c2947
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:336
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:336
```

真实的从主配置应该在配置文件中配置，这样的话是永久的，我们这里使用的是命令，暂时的！

> 操作

主机可以写，从机不能写只能读！主机中的所有信息和数据，都会自动被从机保存！

```bash
# 主机可写可读
127.0.0.1:7000> set name cuixiaoyan
OK
127.0.0.1:7000> get name
"cuixiaoyan"
# 从机只能读
192.168.106.129:7001> get name
"cuixiaoyan"
192.168.106.129:7001> set age 18
(error) READONLY You can't write against a read only replica.  
```

测试：主机断开连接，从机依旧连接到主机的，但是没有写操作，这个时候，主机如果回来了，从机依
旧可以直接获取到主机写的信息！
如果是使用命令行（如上），来配置的主从，这个时候如果重启了，就会变回主机！只要变为从机，立马就会从
主机中获取值！

- 先将7002从机停止，然后主机7000往里面放数据，从机7001获取没有问题，重新启动7002并进行连接主机也是可以获取全部的，尽管刚才它宕机了。就是下面的==增量复制==。
- 主机7000如果宕机后，从机的绑定关系，依然还在。就只能提供查询操作，从机是不允许写操作的。
- 这样就出问题了，我们需要在没有宕机的从机中，选出一个主机。使用 ==SLAVEOF no one== 让自己变成主机,让其他从机重新连接过来。
- 如果这时候，之前的主机7000重新上线，就只能当做从机，去连接新的主机。==SLAVEOF== 192.168.106.129 7001

> 复制原理

Slave 启动成功连接到 master 后会发送一个sync同步命令
Master 接到命令，启动后台的存盘进程，同时收集所有接收到的用于修改数据集命令，在后台进程执行
完毕之后，master将传送整个数据文件到slave，并完成一次完全同步。
全量复制：而slave服务在接收到数据库文件数据后，将其存盘并加载到内存中。
增量复制：Master 继续将新的所有收集到的修改命令依次传给slave，完成同步
但是只要是重新连接master，一次完全同步（全量复制）将被自动执行！ 我们的数据一定可以在从机中
看到！

# 哨兵模式

## 自动选举模式。

> 概述

主从切换技术的方法是：当主服务器宕机后，需要手动把一台从服务器切换为主服务器，这就需要人工
干预，费事费力，还会造成一段时间内服务不可用。这不是一种推荐的方式，更多时候，我们优先考虑
哨兵模式。Redis从2.8开始正式提供了Sentinel（哨兵） 架构来解决这个问题。
谋朝篡位的自动版，能够后台监控主机是否故障，如果故障了根据投票数自动将从库转换为主库。
哨兵模式是一种特殊的模式，首先Redis提供了哨兵的命令，哨兵是一个独立的进程，作为进程，它会独
立运行。其原理是哨兵通过发送命令，等待Redis服务器响应，从而监控运行的多个Redis实例。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200730150337727.png" alt="image-20200730150337727" style="zoom:50%;" />

这里的哨兵有两个作用
通过发送命令，让Redis服务器返回监控其运行状态，包括主服务器和从服务器。
当哨兵监测到master宕机，会自动将slave切换成master，然后通过发布订阅模式通知其他的从服
务器，修改配置文件，让它们切换主机。
然而一个哨兵进程对Redis服务器进行监控，可能会出现问题，为此，我们可以使用多个哨兵进行监控。
各个哨兵之间还会进行监控，这样就形成了多哨兵模式。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200730150905134.png" alt="image-20200730150905134" style="zoom:50%;" />

假设主服务器宕机，哨兵1先检测到这个结果，系统并不会马上进行failover过程，仅仅是哨兵1主观的认
为主服务器不可用，这个现象成为主观下线。当后面的哨兵也检测到主服务器不可用，并且数量达到一
定值时，那么哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，进行failover[故障转移]操作。
切换成功后，就会通过发布订阅模式，让各个哨兵把自己监控的从服务器实现切换主机，这个过程称为
客观下线。

```bash
# 配置文件挂载一下，最低配置，内容如下 /etc/redis/sentinel.conf
sentinel monitor myredis 127.0.0.1 7000 1
# 创建一个哨兵容器
docker run --restart=always --log-driver json-file --log-opt max-size=100m --log-opt max-file=2 -p 7003:7003 --name redisSentinel -v /usr/local/database/redis/redis.conf:/etc/redis/redis.conf -v /usr/local/database/redis/redis-cluster/sentinel.conf:/etc/redis/sentinel.conf -d redis:6.0.5 redis-server /etc/redis/redis.conf --appendonly yes
# 访问	redis-sentinel /etc/redis/sentinel.conf
# 启动哨兵
[root@centos8 redis-cluster]# docker exec -it 48f8725736c3 redis-sentinel /etc/redis/sentinel.conf
```



> 测试

```bash
16:X 30 Jul 2020 07:34:06.679 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
16:X 30 Jul 2020 07:34:06.679 # Redis version=6.0.5, bits=64, commit=00000000, modified=0, pid=16, just started
16:X 30 Jul 2020 07:34:06.679 # Configuration loaded
                _._                                                  
           _.-``__ ''-._                                             
      _.-``    `.  `_.  ''-._           Redis 6.0.5 (00000000/0) 64 bit
  .-`` .-```.  ```\/    _.,_ ''-._                                   
 (    '      ,       .-`  | `,    )     Running in sentinel mode
 |`-._`-...-` __...-.``-._|'` _.-'|     Port: 26379
 |    `-._   `._    /     _.-'    |     PID: 16
  `-._    `-._  `-./  _.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |           http://redis.io        
  `-._    `-._`-.__.-'_.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |                                  
  `-._    `-._`-.__.-'_.-'    _.-'                                   
      `-._    `-.__.-'    _.-'                                       
          `-._        _.-'                                           
              `-.__.-'                                               

16:X 30 Jul 2020 07:34:06.680 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
16:X 30 Jul 2020 07:34:06.682 # Sentinel ID is 380b47be972cf1370e0852a1545c3490aaa9aefc
16:X 30 Jul 2020 07:34:06.682 # +monitor master myredis 192.168.106.129 7000 quorum 1
16:X 30 Jul 2020 07:34:06.723 * +slave slave 172.18.0.1:7001 172.18.0.1 7001 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:34:06.726 * +slave slave 172.18.0.1:7002 172.18.0.1 7002 @ myredis 192.168.106.129 7000

# 关掉主节点7000，这里选举7001为主节点。
16:X 30 Jul 2020 07:42:24.339 # +sdown master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.339 # +odown master myredis 192.168.106.129 7000 #quorum 1/1
16:X 30 Jul 2020 07:42:24.339 # +new-epoch 1
16:X 30 Jul 2020 07:42:24.339 # +try-failover master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.345 # +vote-for-leader 380b47be972cf1370e0852a1545c3490aaa9aefc 1
16:X 30 Jul 2020 07:42:24.345 # +elected-leader master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.345 # +failover-state-select-slave master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.430 # +selected-slave slave 172.18.0.1:7001 172.18.0.1 7001 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.430 * +failover-state-send-slaveof-noone slave 172.18.0.1:7001 172.18.0.1 7001 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.530 * +failover-state-wait-promotion slave 172.18.0.1:7001 172.18.0.1 7001 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.757 # +promoted-slave slave 172.18.0.1:7001 172.18.0.1 7001 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.757 # +failover-state-reconf-slaves master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:24.847 * +slave-reconf-sent slave 172.18.0.1:7002 172.18.0.1 7002 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:25.798 * +slave-reconf-inprog slave 172.18.0.1:7002 172.18.0.1 7002 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:25.798 * +slave-reconf-done slave 172.18.0.1:7002 172.18.0.1 7002 @ myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:25.864 # +failover-end master myredis 192.168.106.129 7000
16:X 30 Jul 2020 07:42:25.864 # +switch-master myredis 192.168.106.129 7000 172.18.0.1 7001
16:X 30 Jul 2020 07:42:25.864 * +slave slave 172.18.0.1:7002 172.18.0.1 7002 @ myredis 172.18.0.1 7001
16:X 30 Jul 2020 07:42:25.864 * +slave slave 192.168.106.129:7000 192.168.106.129 7000 @ myredis 172.18.0.1 7001
16:X 30 Jul 2020 07:42:55.915 # +sdown slave 192.168.106.129:7000 192.168.106.129 7000 @ myredis 172.18.0.1 7001

```

如果主机此时回来了，只能归并到新的主机下，当做从机，这就是哨兵模式的规则！

```bash
16:X 30 Jul 2020 07:45:40.800 # -sdown slave 192.168.106.129:7000 192.168.106.129 7000 @ myredis 172.18.0.1 7001
16:X 30 Jul 2020 07:45:50.732 * +convert-to-slave slave 192.168.106.129:7000 192.168.106.129 7000 @ myredis 172.18.0.1 7001
16:X 30 Jul 2020 07:45:57.340 * +slave slave 172.18.0.1:7000 172.18.0.1 7000 @ myredis 172.18.0.1 7001
# 查看7000的信息
127.0.0.1:7000> info replication
# Replication
role:slave
master_host:172.18.0.1
master_port:7001
master_link_status:up
master_last_io_seconds_ago:2
master_sync_in_progress:0
slave_repl_offset:63952
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:c2c821bdc9cfe49dcce55c91a97e656f77b6f9a5
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:63952
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:60510
repl_backlog_histlen:3443

```

优点：
1、哨兵集群，基于主从复制模式，所有的主从配置优点，它全有
2、 主从可以切换，故障可以转移，系统的可用性就会更好
3、哨兵模式就是主从模式的升级，手动到自动，更加健壮！
缺点：
1、Redis 不好啊在线扩容的，集群容量一旦到达上限，在线扩容就十分麻烦！
2、实现哨兵模式的配置其实是很麻烦的，里面有很多选择！

>哨兵模式的全部配置！

```bash
# Example sentinel.conf
# 哨兵sentinel实例运行的端口 默认26379
port 26379
# 哨兵sentinel的工作目录
dir /tmp
# 哨兵sentinel监控的redis主节点的 ip port
# master-name 可以自己命名的主节点名字 只能由字母A-z、数字0-9 、组成。
# quorum 配置多少个sentinel哨兵统一认为master主节点失联 那么这时客观上认为主节点失联了
# sentinel monitor <master-name> <ip> <redis-port> <quorum>
sentinel monitor mymaster 127.0.0.1 6379 2
# 当在Redis实例中开启了requirepass foobared 授权密码 这样所有连接Redis实例的客户端都要提供
密码
# 设置哨兵sentinel 连接主从的密码 注意必须为主从设置一样的验证密码
# sentinel auth-pass <master-name> <password>
sentinel auth-pass mymaster MySUPER--secret-0123passw0rd
# 指定多少毫秒之后 主节点没有应答哨兵sentinel 此时 哨兵主观上认为主节点下线 默认30秒
# sentinel down-after-milliseconds <master-name> <milliseconds>
sentinel down-after-milliseconds mymaster 30000
# 这个配置项指定了在发生failover主备切换时最多可以有多少个slave同时对新的master进行 同步，
这个数字越小，完成failover所需的时间就越长，
但是如果这个数字越大，就意味着越 多的slave因为replication而不可用。
可以通过将这个值设为 1 来保证每次只有一个slave 处于不能处理命令请求的状态。
# sentinel parallel-syncs <master-name> <numslaves>
sentinel parallel-syncs mymaster 1
# 故障转移的超时时间 failover-timeout 可以用在以下这些方面：
#1. 同一个sentinel对同一个master两次failover之间的间隔时间。
#2. 当一个slave从一个错误的master那里同步数据开始计算时间。直到slave被纠正为向正确的master那
里同步数据时。
#3.当想要取消一个正在进行的failover所需要的时间。
#4.当进行failover时，配置所有slaves指向新的master所需的最大时间。不过，即使过了这个超时，
slaves依然会被正确配置为指向master，但是就不按parallel-syncs所配置的规则来了
# 默认三分钟
# sentinel failover-timeout <master-name> <milliseconds>
sentinel failover-timeout mymaster 180000
# SCRIPTS EXECUTION
#配置当某一事件发生时所需要执行的脚本，可以通过脚本来通知管理员，例如当系统运行不正常时发邮件通知
相关人员。
#对于脚本的运行结果有以下规则：
#若脚本执行后返回1，那么该脚本稍后将会被再次执行，重复次数目前默认为10
#若脚本执行后返回2，或者比2更高的一个返回值，脚本将不会重复执行。
#如果脚本在执行过程中由于收到系统中断信号被终止了，则同返回值为1时的行为相同。
#一个脚本的最大执行时间为60s，如果超过这个时间，脚本将会被一个SIGKILL信号终止，之后重新执行。
#通知型脚本:当sentinel有任何警告级别的事件发生时（比如说redis实例的主观失效和客观失效等等），
将会去调用这个脚本，这时这个脚本应该通过邮件，SMS等方式去通知系统管理员关于系统不正常运行的信
息。调用该脚本时，将传给脚本两个参数，
一个是事件的类型，
一个是事件的描述。如果sentinel.conf配
置文件中配置了这个脚本路径，那么必须保证这个脚本存在于这个路径，并且是可执行的，否则sentinel无
法正常启动成功。
#通知脚本
# shell编程
# sentinel notification-script <master-name> <script-path>
sentinel notification-script mymaster /var/redis/notify.sh
# 客户端重新配置主节点参数脚本
# 当一个master由于failover而发生改变时，这个脚本将会被调用，通知相关的客户端关于master地址已
经发生改变的信息。
# 以下参数将会在调用脚本时传给脚本:
# <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>
# 目前<state>总是“failover”
,
# <role>是“leader”或者“observer”中的一个。
# 参数 from-ip, from-port, to-ip, to-port是用来和旧的master和新的master(即旧的slave)通
信的
# 这个脚本应该是通用的，能被多次调用，不是针对性的。
# sentinel client-reconfig-script <master-name> <script-path>
sentinel client-reconfig-script mymaster /var/redis/reconfig.sh # 一般都是由运维来配置
```

# redis缓存穿透和雪崩

> 服务高可用问题。

Redis缓存的使用，极大的提升了应用程序的性能和效率，特别是数据查询方面。但同时，它也带来了一
些问题。其中，最要害的问题，就是数据的一致性问题，从严格意义上讲，这个问题无解。如果对数据
的一致性要求很高，那么就不能使用缓存。
另外的一些典型问题就是，缓存穿透、缓存雪崩和缓存击穿。目前，业界也都有比较流行的解决方案。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200731104459377.png" alt="image-20200731104459377" style="zoom:50%;" />

## 缓存穿透（查不到）

> 概念

缓存穿透的概念很简单，用户想要查询一个数据，发现redis内存数据库没有，也就是缓存没有命中，于
是向持久层数据库查询。发现也没有，于是本次查询失败。当用户很多的时候，缓存都没有命中（秒
杀！），于是都去请求了持久层数据库。这会给持久层数据库造成很大的压力，这时候就相当于出现了
缓存穿透。

> 解决方案

==布隆过滤器==

布隆过滤器是一种数据结构，对所有可能查询的参数以hash形式存储，在控制层先进行校验，不符合则
丢弃，从而避免了对底层存储系统的查询压力。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200731105427532.png" alt="image-20200731105427532" style="zoom:50%;" />

==缓存空对象==

当存储层不命中后，即使返回的空对象也将其缓存起来，同时会设置一个过期时间，之后再访问这个数
据将会从缓存中获取，保护了后端数据源；

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200731105807997.png" alt="image-20200731105807997" style="zoom:50%;" />

但是这种方法会存在两个问题：
1、如果空值能够被缓存起来，这就意味着缓存需要更多的空间存储更多的键，因为这当中可能会有很多
的空值的键；
2、即使对空值设置了过期时间，还是会存在缓存层和存储层的数据会有一段时间窗口的不一致，这对于
需要保持一致性的业务会有影响。

## 缓存击穿（量太大，缓存过期！）

> 概述

这里需要注意和缓存击穿的区别，缓存击穿，是指一个key非常热点，在不停的扛着大并发，大并发集中
对这一个点进行访问，当这个key在失效的瞬间，持续的大并发就穿破缓存，直接请求数据库，就像在一
个屏障上凿开了一个洞。
当某个key在过期的瞬间，有大量的请求并发访问，这类数据一般是热点数据，由于缓存过期，会同时访
问数据库来查询最新数据，并且回写缓存，会导使数据库瞬间压力过大。

> 解决方案

==设置热点数据永不过期==

从缓存层面来看，没有设置过期时间，所以不会出现热点 key 过期后产生的问题。

==加互斥锁==

分布式锁：使用分布式锁，保证对于每个key同时只有一个线程去查询后端服务，其他线程没有获得分布
式锁的权限，因此只需要等待即可。这种方式将高并发的压力转移到了分布式锁，因此对分布式锁的考
验很大。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200731111636897.png" alt="image-20200731111636897" style="zoom:50%;" />

## 缓存雪崩

缓存雪崩，是指在某一个时间段，缓存集中过期失效。Redis 宕机！
产生雪崩的原因之一，比如在写本文的时候，马上就要到双十二零点，很快就会迎来一波抢购，这波商
品时间比较集中的放入了缓存，假设缓存一个小时。那么到了凌晨一点钟的时候，这批商品的缓存就都
过期了。而对这批商品的访问查询，都落到了数据库上，对于数据库而言，就会产生周期性的压力波
峰。于是所有的请求都会达到存储层，存储层的调用量会暴增，造成存储层也会挂掉的情况。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200731112811054.png" alt="image-20200731112811054" style="zoom:50%;" />

其实集中过期，倒不是非常致命，比较致命的缓存雪崩，是缓存服务器某个节点宕机或断网。因为自然
形成的缓存雪崩，一定是在某个时间段集中创建缓存，这个时候，数据库也是可以顶住压力的。无非就
是对数据库产生周期性的压力而已。而缓存服务节点的宕机，对数据库服务器造成的压力是不可预知
的，很有可能瞬间就把数据库压垮。

==redis高可用==

这个思想的含义是，既然redis有可能挂掉，那我多增设几台redis，这样一台挂掉之后其他的还可以继续
工作，其实就是搭建的集群。（异地多活！）

==限流降级==

这个解决方案的思想是，在缓存失效后，通过加锁或者队列来控制读数据库写缓存的线程数量。比如对
某个key只允许一个线程查询数据和写缓存，其他线程等待。

==数据预热==

数据加热的含义就是在正式部署之前，我先把可能的数据先预先访问一遍，这样部分可能大量访问的数
据就会加载到缓存中。在即将发生大并发访问前手动触发加载缓存不同的key，设置不同的过期时间，让
缓存失效的时间点尽量均匀。

# 应用场景

## String字符串

### String字符串结构的常用命令

```bash
#字符串常用操作
SET  key  value //存入字符串键值对
MSET  key  value [key value ...] //批量存储字符串键值对
SETNX  key  value //存入一个不存在的字符串键值对
GET  key //获取一个字符串键值
MGET  key  [key ...] //批量获取字符串键值
DEL  key  [key ...] //删除一个键
EXPIRE  key  seconds //设置一个键的过期时间(秒)
#原子加减
INCR  key //将key中储存的数字值加1
DECR  key //将key中储存的数字值减1
INCRBY  key  increment //将key所储存的值加上increment
DECRBY  key  decrement //将key所储存的值减去decrement
```

这里列出了一些String常用命令，我们看一下这些String类型的这些命令可以应用到哪些场景。

### 应用场景

**1、单值缓存**

即最简单的key-value的set和get，比如缓存个标识，开关等

```
SET key value
GET key
```

**2、对象缓存**

除了单值缓存我们还可以用String类型缓存对象，如下两种方式：

```
#1
SET user:1  value(json串)
GET user:1
#2
MSET user:1:name cuixiaoyan user:1:sex 1
MGET user:1:name user:1:sex
```

第一种直接将对象转换成json串作为value存储到redis，这种获取对象就比较简单了，直接get key拿到value转成对象即可，但有个缺点就是如果你要是修改对象的某一个字段，也得把整个对象的json串拿出来反序列化成对象，这将带来不必要的网络开销(即便是redis存在内存中，但实际我们的应用服务器和redis是隔离的，网络传输的开销也不容小觑)，同样，频繁的序列化反序列化也将会带来不小的性能开销，如果对于性能要求比较高的系统来说这将是一个灾难。

而第二种存储对象的方式则对于这种频繁修改对象某一个字段的场景就比较友好了，每个字段与值都是一个kv对，修改直接set k v覆盖就好了，但是存储多个字段时就没那么容易了，好在有mset批量操作的命令，网络开销由多次变为1次。

**3、分布式锁**

如下setnx命令是set if not exit的缩写，意思就是这个key不存在时才执行set。多个线程执行这条命令时只有一个线程会执行成功，则视为拿到锁。然后拿到锁的线程执行业务操作，执行完毕删除这个锁，释放锁。

```
#setnx key value
SETNX  product:10001  true   //返回1代表获取锁成功
SETNX  product:10001  true   //返回0代表获取锁失败
//执行业务操作
DEL  product:10001  //执行完业务释放锁
```

上述方式存在问题：程序意外终止可能会导致锁没办法释放，造成死锁。可以使用如下命令，既设置分布式锁又设置了key的过期时间

```
SET product:10001 true  ex  10  nx  //防止程序意外终止导致死锁
```

分Redis布式锁的详细实现可以参考我之前写的Redis分布式锁实战

**4、计数器**

```
INCR article:readcount:{文章id}
GET article:readcount:{文章id}
```

基于Redis原子自增命令incr可以实现诸如计数器的功能，我们都知道公众号文章，微博，博客都有一个阅读量的概念，我们就可以用这个计数器来实现，而且性能很高。

例如下图中的微信阅读数就可以用redis的自增来实现。

**5、Web集群session共享解决方案**

系统集群部署情况下首先要考虑的问题就是session共享问题，我们可以通过将原本存储在内存中由tomcat管理的session转移到由Redis来存储，实现分布式session的功能。spring框架提供了session共享的解决方案，即spring session + redis实现分布式session。

**6、分布式系统全局序列号**

分布式系统中要保证全局序列号的唯一性，可以使用Redis来维护一个自增的序列。

通过如下命令从Redis获取自增ID：

```
#INCR是一个原子自增命令
INCR orderId
```

分布式系统环境下通过Redis保证ID的自增性和唯一性，通过该命令获取ID每次都要和Redis进行交互，如果业务量很大，那么这将会很频繁。

所以可以一次性获取一定量的ID保存在JVM内存中，用完了再从Redis获取。这样减少了频繁的网络开销，但是缺点是可能会丢失(浪费)一部分ID，因为获取后服务可能挂了还没用完的ID可能就浪费了（当然你可以使用一些手段去保证不浪费，但没必要，浪费一点也是无所谓的）。

如下，每次获取1000个

```
#redis批量生成序列号提升性能
INCRBY  orderId  1000
```

## HASH结构

### Hash常用操作

```
HSET key field value//存储一个哈希表key的键值
HSETNX key field value//存储一个不存在的哈希表key的键值
HMSET key field value [field value ...] //在一个哈希表key中存储多个键值对
HGET key field//获取哈希表key对应的field键值
HMGET key field [field ...]//批量获取哈希表key中多个field键值
HDEL key field [field ...]//删除哈希表key中的field键值
HLEN key//返回哈希表key中field的数量
HGETALL key//返回哈希表key中所有的键值
HINCRBY key field increment//为哈希表key中field键的值加上增量increment
```

### 应用场景

**1、对象缓存**

结合HASH结构的key-field-value的特性，类似于Java中的HashMap，内部也是“key-value”的形式，field刚好可以存对象的属性名，假设有如下数据，



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1.jpg)



我们可以用HMSET命令批量设置field-value，前面拼接用户的ID保证存多个用户的数据不会重复；HMGET批量获取field；MSET修改某一个field。

```
HMSET  achievement {userId}:name  小明 {userId}:score 89
HMSET  achievement 1:name  小明 1:score 89
HMSET  achievement 2:name  小华 2:score 92
HMGET  achievement 1:name  1:score
```

对象与HSAH的关系就变成了下图这样



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133647589.jpg)



**2、电商购物车**

以用户id为key，商品id为field，商品数量为value可以实现购物车的常规操作。

购物车操作：

```
#添加商品
hset cart:10001 50005 1
#给某一个商品增加数量
hincrby cart:10001 50005 1
#购物车中商品总个数
hlen cart:10001
#删除商品
hdel cart:10001 50005
#获取购物车所有商品
hgetall cart:10001
```

对应购物车的几个常用操作可以想象使用Redis如何实现



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133647635.jpg)



### Hash结构优缺点

**优点**

- 将同类数据归类整合储存（同一个key），方便数据管理
- 相比String操作，对内存与cpu的消耗更小
- 相比String储存更节省空间

**缺点**

- 过期功能不能使用在field上，只能用在key上
- Redis集群架构下不适合大规模使用

## List结构

### List常用操作

我们可以认为列表的左边叫头，右边叫尾



![List结构的操作示意图](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133927830.jpg)



**常用命令**

```
LPUSH key value [value ...] //将一个或多个值value插入到key列表的表头(最左边)
```

### 应用场景

**1、实现常见的数据结构**

基于List的特性及丰富的命令可以实现常用的集中数据结构：

```
1）Stack(栈) = LPUSH + LPOP ，FILO先入后出
```

结合LPUSH和LPOP命令实现栈的先进后出的特性，LPUSH从左边入栈，LPOP从左边出栈，先进入的后出来。相当于入口出口是一个。

```
2）Queue(队列）= LPUSH + RPOP，FIFO先进先出
```

结合LPUSH和RPOP命令实现队列的先进先出的特性，LPUSH从左边入队，RPOP从右边出队，先进来的先出来。相当于入口出口各在两边。

`3）Blocking MQ(阻塞队列）= LPUSH + BRPOP` 结合LPUSH和BRPOP实现阻塞队列，BRPOP比RPOP多了一个timeout的参数，是一个等待的最大时间，如果在这个时间内拿不到数据则返回空。

**2、微博消息和微信公号消息**

例如，本人关注了人民网、华为中国、京港地铁等大V，假设人民网发了一条微博，ID为30033，我关注了他，那么就会往我的msg这个队列里push这个微博ID，我在打开我的微博时，就会从这个我专属的msg队列里取前几个微博ID展示给我看，所以这个就牵涉到了几个关键点：

```
1）人民网发了一条微博，ID为30033，消息ID入队
LPUSH  msg:{walking-ID}  30033
复制代码
2）华为中国发微博，ID为30055，消息入队
LPUSH  msg:{walking-ID} 30055
复制代码
3）我登录进去，会给我展示最新微博消息，那么就从我的消息队列里取最新的前5条显示在首页
LRANGE  msg:{walking-ID}  0  5
```



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133927886.jpg)



## SET结构

### Set常用操作

```
SADD  key  member  [member ...]//往集合key中存入元素，元素存在则忽略，若key不存在则新建
SREM  key  member  [member ...]//从集合key中删除元素
SMEMBERS  key //获取集合key中所有元素
SCARD  key//获取集合key的元素个数
SISMEMBER  key  member//判断member元素是否存在于集合key中
SRANDMEMBER  key  [count]//从集合key中选出count个元素，元素不从key中删除
SPOP  key  [count]//从集合key中选出count个元素，元素从key中删除
```

**set运算操作**

```
SINTER key [key ...] //交集运算
SINTERSTORE destination key [key ..]//将交集结果存入新集合destination中
SUNION key [key ..] //并集运算
SUNIONSTORE destination key [key ...]//将并集结果存入新集合destination中
SDIFF key [key ...] //差集运算
SDIFFSTORE destination key [key ...]//将差集结果存入新集合destination中
```

### 应用场景

**1、微信抽奖小程序**

想必大家都用过微信里的抽奖小程序吧，如下图，我们可以点击立即参与进行抽奖，还可以查看所有参与人员，最后就是开奖的功能，一共三个关键点



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133927945.jpg)



我们看一下这三个关键点用set数据类型怎么实现：

```
1）点击参与抽奖，则将用户ID加入集合
SADD key {userlD}

2）查看参与抽奖所有用户
SMEMBERS key

3）抽取count名中奖者
SRANDMEMBER key [count]//返回但不从set中剔除

```

如果设置了一等奖二等奖三等奖...，并且每人只能得一种，则可以用SPOP key count

**2、微信微博点赞，收藏，标签**

比如发了一条朋友圈，有人点赞



![image1](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133928012.jpg)



```
1) 点赞 点赞就把点赞这个人的ID加到这个点赞的集合中
SADD  like:{消息ID}  {用户ID}

2) 取消点赞 从集合中移除用户ID
SREM like:{消息ID}  {用户ID}

3) 检查用户是否点过赞
SISMEMBER  like:{消息ID}  {用户ID}

4) 获取点赞的用户列表
SMEMBERS like:{消息ID}

5) 获取点赞用户数
SCARD like:{消息ID}

```

**Set集合运算操作的应用场景**

基于Redisset集合提供的丰富的命令，我们可以对集合轻松的实现交并差的运算。例如，现有集合set1，set12，set3，元素如下：

```
set1：{a,b,c}
```

对集合进行交、并、差的运算

```
SINTER set1 set2 set3 //交集--> { c } 
```

通过这些基本操作我们看可以实现什么样的业务需求。

**3、集合操作实现社交软件关注模型**

社交软件的用户关注模型，如QQ的好友，微博的关注，抖音、快手的关注、微信的公众号关注，这些社交软件都会做一个这样的功能，那就是用户关系的关注模型推荐，包括共同关注的人、可能认识的人、

首先看一下walking、chenmowanger、Hollis关注的人，如下：

```
1)walking关注的人:
walkingSet-->{chenmowanger, ImportNew, Hollis}
复制代码
2) chenmowanger关注的人:
chenmowangerSet-->{walking, ImportNew, Hollis, JavaGuide}
复制代码
3) Hollis关注的人:
HollisSet--> {waking, ImportNew, JavaGuide, feichao, CodeSheep}
复制代码
```



每个人的关注列表都是一个Redis的set集合，然后当walking点到chenmowanger的主页，就会有个区域专门展示我和二哥的一些关注情况：

```
4) walking和chenmowanger共同关注:
```

也就是看哪些人在我的集合里也在二哥的集合里

```
//两个集合求并集
SINTER walkingSet zhangyixingSet--> {ImportNew, Hollis}
复制代码
5) 我关注的人也关注他(chenmowanger):
```

看我关注的人的关注列表里是不是有某个人，比如我进入chenmowanger的主页，可以展示我关注的人里还有谁也关注了chenmowanger

```
SISMEMBER ImportNewSet chenmowanger
复制代码
6) 我可能认识的人:
```

求差集，以前面这个集合为准，看二哥关注的那些人有哪些我还没关注，于是我就赶紧关注了JavaGuide（Guide哥）

```
SDIFF chenmowangerSet walkingSet->{walking, JavaGuide}
复制代码
```

**4、集合操作实现电商商品筛选**

先看一下这个图是不是很熟悉，选购手机时，有一个筛选的功能



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133928052.jpg)



如上图，电商网站买手机，进到这个页面根据各种条件搜手机，我们想一想用Redis如何实现呢？（当然了，这里并不是说人家就完全用Redis实现这一套搜索，其实主要还是用搜索引擎那些中间件，这里只是说明可以用Redis实现~）

在上架商品时维护商品，添加商品的同时把对应的商品添加到对应的set集合里即可，如下举例

```
//品牌-华为
SADD  brand:huawei  P30 Mate30 荣耀Play4 nova7
//品牌-小米
SADD  brand:xiaomi  mi6 mi8 mi9 mi10
//品牌-iPhone
SADD  brand:iPhone iphone8 iphone8plus iphoneX iphone11
//操作系统-Android
SADD os:android  P30 Mate30 荣耀Play4 nova7 mi6 mi8 mi9 mi10
//CPU品牌-骁龙
SADD cpu:brand:xiaolong iphone8 iphone8plus iphoneX iphone11 mi6 mi8 mi9 mi10
//CPU品牌-麒麟
SADD cpu:brand:qilin  P30 Mate30 荣耀Play4 nova7
//运行内存-8G
SADD ram:8G P30 Mate30 荣耀Play4 nova7 mi6 mi8 mi9 mi10 iphone8 iphone8plus iphoneX iphone11
//多条件查询 操作系统Android，CPU品牌骁龙，运行内存8G
SINTER  os:android cpu:brand:xiaolong  ram:8G -->{mi6 mi8 mi9 mi10}
```

截图更容易看：



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133928120.jpg)



假设我们维护了各种品牌，手机所属的操作系统，CPU品牌，运行内存等，那么我们在勾选条件查找时就可以用勾选的各个集合求他的交集就行了。

## ZSet有序集合

zset是有序的set集合，通过传入的分值进行排序



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133928167.jpg)



### ZSet常用操作

```
ZADD key score member [[score member]…]//往有序集合key中加入带分值元素
ZREM key member [member …]  //从有序集合key中删除元素
ZSCORE key member //返回有序集合key中元素member的分值
ZINCRBY key increment member//为有序集合key中元素member的分值加上increment 
ZCARD key//返回有序集合key中元素个数
ZRANGE key start stop [WITHSCORES]//正序获取有序集合key从start下标到stop下标的元素
ZREVRANGE key start stop [WITHSCORES]//倒序获取有序集合key从start下标到stop下标的元素
```

**Zset集合操作**

```
ZUNIONSTORE destkey numkeys key [key ...] //并集计算 
ZINTERSTORE destkey numkeys key [key …]//交集计算
```

### 应用场景

**1、Zset集合操作实现排行榜**

我们都知道微博热点，新闻热榜，投票排行榜等都有一个排名的概念，如下图百度热榜，展示的是实时的点击量比较高的新闻（假设这些新闻的ID为1001-1010），每个新闻都有一个热点值，一般按点击量，1001这个新闻热点是484W，1002这个是467W，实时的，可能等会再看就不一样了，那么我们看下用Redis咋实现。



![image](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731133928301.jpg)



```
1）点击新闻
```

每次有人点击这个新闻，那么久ius给他的分值加1

```
ZINCRBY  hotNews:20200722  1  1001 //新闻ID为1001的新闻分值加一
2）展示当日排行前十
```

取集合中的前10个元素

```
ZREVRANGE  hotNews:20200722  0  10  WITHSCORES
3）七日热点榜单计算
ZUNIONSTORE  hotNews:20200715-20200721  7 hotNews:20200715 hotNews:20200716... hotNews:20200721
4）展示七日排行前十
ZREVRANGE hotNews:20190813-20190819  0  10  WITHSCORES
```

## 更多应用场景

- 微信<摇一摇><抢红包>
- 滴滴打车、摩拜单车<附近的车>
- 美团和饿了么<附近的餐馆>
- 搜索自动补全
- 布隆过滤器

# Redis集群方案

- 主从复制模式
- Sentinel（哨兵）模式
- Cluster 模式

## Redis 集群的三种模式

### 主从复制模式



![img](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731141211788.jpg)



#### 主从复制的作用

通过持久化功能，Redis保证了即使在服务器重启的情况下也不会丢失（或少量丢失）数据，因为持久化会把内存中数据保存到硬盘上，重启会从硬盘上加载数据。 但是由于数据是存储在一台服务器上的，如果这台服务器出现硬盘故障等问题，也会导致数据丢失。

为了避免单点故障，通常的做法是将数据库复制多个副本以部署在不同的服务器上，这样即使有一台服务器出现故障，其他服务器依然可以继续提供服务。

为此， **Redis 提供了复制（replication）功能，可以实现当一台数据库中的数据更新后，自动将更新的数据同步到其他数据库上**。

在复制的概念中，数据库分为两类，一类是主数据库（master），另一类是从数据库(slave）。主数据库可以进行读写操作，当写操作导致数据变化时会自动将数据同步给从数据库。而从数据库一般是只读的，并接受主数据库同步过来的数据。一个主数据库可以拥有多个从数据库，而一个从数据库只能拥有一个主数据库。

**总结：引入主从复制机制的目的有两个**

- 一个是读写分离，分担 "master" 的读写压力
- 一个是方便做容灾恢复

#### **主从复制原理**



![img](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731141211834.jpg)



- 从数据库启动成功后，连接主数据库，发送 SYNC 命令；
- 主数据库接收到 SYNC 命令后，开始执行 BGSAVE 命令生成 RDB 文件并使用缓冲区记录此后执行的所有写命令；
- 主数据库 BGSAVE 执行完后，向所有从数据库发送快照文件，并在发送期间继续记录被执行的写命令；
- 从数据库收到快照文件后丢弃所有旧数据，载入收到的快照；
- 主数据库快照发送完毕后开始向从数据库发送缓冲区中的写命令；
- 从数据库完成对快照的载入，开始接收命令请求，并执行来自主数据库缓冲区的写命令；（**从数据库初始化完成**）
- 主数据库每执行一个写命令就会向从数据库发送相同的写命令，从数据库接收并执行收到的写命令（**从数据库初始化完成后的操作**）
- 出现断开重连后，2.8之后的版本会将断线期间的命令传给重数据库，增量复制。
- 主从刚刚连接的时候，进行全量同步；全同步结束后，进行增量同步。当然，如果有需要，slave 在任何时候都可以发起全量同步。Redis 的策略是，无论如何，首先会尝试进行增量同步，如不成功，要求从机进行全量同步。

#### 主从复制优缺点

**主从复制优点**

- 支持主从复制，主机会自动将数据同步到从机，可以进行读写分离；
- 为了分载 Master 的读操作压力，Slave 服务器可以为客户端提供只读操作的服务，写服务仍然必须由Master来完成；
- Slave 同样可以接受其它 Slaves 的连接和同步请求，这样可以有效的分载 Master 的同步压力；
- Master Server 是以非阻塞的方式为 Slaves 提供服务。所以在 Master-Slave 同步期间，客户端仍然可以提交查询或修改请求；
- Slave Server 同样是以非阻塞的方式完成数据同步。在同步期间，如果有客户端提交查询请求，Redis则返回同步之前的数据；

**主从复制缺点**

- Redis不具备自动容错和恢复功能，主机从机的宕机都会导致前端部分读写请求失败，需要等待机器重启或者手动切换前端的IP才能恢复（**也就是要人工介入**）；
- 主机宕机，宕机前有部分数据未能及时同步到从机，切换IP后还会引入数据不一致的问题，降低了系统的可用性；
- 如果多个 Slave 断线了，需要重启的时候，尽量不要在同一时间段进行重启。因为只要 Slave 启动，就会发送sync 请求和主机全量同步，当多个 Slave 重启的时候，可能会导致 Master IO 剧增从而宕机。
- Redis 较难支持在线扩容，在集群容量达到上限时在线扩容会变得很复杂；

### Sentinel（哨兵）模式

第一种主从同步/复制的模式，当主服务器宕机后，需要手动把一台从服务器切换为主服务器，这就需要人工干预，费事费力，还会造成一段时间内服务不可用。这不是一种推荐的方式，更多时候，我们优先考虑哨兵模式。

哨兵模式是一种特殊的模式，首先 Redis 提供了哨兵的命令，**哨兵是一个独立的进程，作为进程，它会独立运行。其原理是哨兵通过发送命令，等待Redis服务器响应，从而监控运行的多个 Redis 实例**。



![单哨兵](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731141211854.jpg)



#### **哨兵模式的作用**

- 通过发送命令，让 Redis 服务器返回监控其运行状态，包括主服务器和从服务器；
- 当哨兵监测到 master 宕机，会自动将 slave 切换成 master ，然后通过**发布订阅模式**通知其他的从服务器，修改配置文件，让它们切换主机；

然而一个哨兵进程对Redis服务器进行监控，也可能会出现问题，为此，我们可以使用多个哨兵进行监控。各个哨兵之间还会进行监控，这样就形成了多哨兵模式。



![多哨兵](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731141211881.jpg)



#### **故障切换的过程**

假设主服务器宕机，哨兵1先检测到这个结果，系统并不会马上进行 failover 过程，仅仅是哨兵1主观的认为主服务器不可用，这个现象成为**主观下线**。当后面的哨兵也检测到主服务器不可用，并且数量达到一定值时，那么哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，进行 failover 操作。切换成功后，就会通过发布订阅模式，让各个哨兵把自己监控的从服务器实现切换主机，这个过程称为**客观下线**。这样对于客户端而言，一切都是透明的。

#### 哨兵模式的工作方式：

- 每个Sentinel（哨兵）进程以每秒钟一次的频率向整个集群中的 Master 主服务器，Slave 从服务器以及其他Sentinel（哨兵）进程发送一个 PING 命令。
- 如果一个实例（instance）距离最后一次有效回复 PING 命令的时间超过 down-after-milliseconds 选项所指定的值， 则这个实例会被 Sentinel（哨兵）进程标记为主观下线（SDOWN）
- 如果一个 Master 主服务器被标记为主观下线（SDOWN），则正在监视这个 Master 主服务器的所有 Sentinel（哨兵）进程要以每秒一次的频率确认 Master 主服务器的确进入了主观下线状态
- 当有足够数量的 Sentinel（哨兵）进程（大于等于配置文件指定的值）在指定的时间范围内确认 Master 主服务器进入了主观下线状态（SDOWN）， 则 Master 主服务器会被标记为客观下线（ODOWN）
- 在一般情况下， 每个 Sentinel（哨兵）进程会以每 10 秒一次的频率向集群中的所有 Master 主服务器、Slave 从服务器发送 INFO 命令。
- 当 Master 主服务器被 Sentinel（哨兵）进程标记为客观下线（ODOWN）时，Sentinel（哨兵）进程向下线的 Master 主服务器的所有 Slave 从服务器发送 INFO 命令的频率会从 10 秒一次改为每秒一次。
- 若没有足够数量的 Sentinel（哨兵）进程同意 Master主服务器下线， Master 主服务器的客观下线状态就会被移除。若 Master 主服务器重新向 Sentinel（哨兵）进程发送 PING 命令返回有效回复，Master主服务器的主观下线状态就会被移除。

#### 哨兵模式的优缺点

**优点：**

- 哨兵模式是基于主从模式的，所有主从的优点，哨兵模式都具有。
- 主从可以自动切换，系统更健壮，可用性更高(**可以看作自动版的主从复制**)。

**缺点：**

- Redis较难支持在线扩容，在集群容量达到上限时在线扩容会变得很复杂。

### Cluster 集群模式（Redis官方）

Redis Cluster是一种服务器 Sharding 技术，3.0版本开始正式提供。

Redis 的哨兵模式基本已经可以实现高可用，读写分离 ，但是在这种模式下每台 Redis 服务器都存储相同的数据，很浪费内存，所以在 redis3.0上加入了 Cluster 集群模式，实现了 Redis 的分布式存储，**也就是说每台 Redis 节点上存储不同的内容**。



![image-20200531184321294](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/1-20200731141211913.jpg)



在这个图中，每一个蓝色的圈都代表着一个 redis 的服务器节点。它们任何两个节点之间都是相互连通的。客户端可以与任何一个节点相连接，然后就可以访问集群中的任何一个节点。对其进行存取和其他操作。

#### **集群的数据分片**

Redis 集群没有使用一致性 hash，而是引入了哈希槽【hash slot】的概念。

Redis 集群有16384 个哈希槽，每个 key 通过 CRC16 校验后对 16384 取模来决定放置哪个槽。集群的每个节点负责一部分hash槽，举个例子，比如当前集群有3个节点，那么：

- 节点 A 包含 0 到 5460 号哈希槽
- 节点 B 包含 5461 到 10922 号哈希槽
- 节点 C 包含 10923 到 16383 号哈希槽

这种结构很容易添加或者删除节点。比如如果我想新添加个节点 D ， 我需要从节点  A， B， C 中得部分槽到 D 上。如果我想移除节点 A ，需要将 A 中的槽移到 B 和 C 节点上，然后将没有任何槽的 A 节点从集群中移除即可。由于从一个节点将哈希槽移动到另一个节点并不会停止服务，所以无论添加删除或者改变某个节点的哈希槽的数量都不会造成集群不可用的状态。

在 Redis 的每一个节点上，都有这么两个东西，一个是插槽（slot），它的的取值范围是：0-16383。还有一个就是 cluster，可以理解为是一个集群管理的插件。当我们的存取的 Key到达的时候，Redis 会根据 CRC16 的算法得出一个结果，然后把结果对 16384 求余数，这样每个 key 都会对应一个编号在 0-16383 之间的哈希槽，通过这个值，去找到对应的插槽所对应的节点，然后直接自动跳转到这个对应的节点上进行存取操作。

#### Redis 集群的主从复制模型

为了保证高可用，redis-cluster集群引入了主从复制模型，一个主节点对应一个或者多个从节点，当主节点宕机的时候，就会启用从节点。当其它主节点 ping 一个主节点 A 时，如果半数以上的主节点与 A 通信超时，那么认为主节点 A 宕机了。如果主节点 A 和它的从节点 A1 都宕机了，那么该集群就无法再提供服务了。

#### **集群的特点**

- 所有的 redis 节点彼此互联(PING-PONG机制)，内部使用二进制协议优化传输速度和带宽。
- 节点的 fail 是通过集群中超过半数的节点检测失效时才生效。
- 客户端与 Redis 节点直连，不需要中间代理层.客户端不需要连接集群所有节点，连接集群中任何一个可用节点即可。

# 分布式锁

　　运行效果如下图所示。从图中可以看出，同一个资源在同一个时刻只能被一个线程获取，从而保证了库存数量N的递减是顺序的。

![image-20200813171442211](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200813171442211.png)

## 接口

```java
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
```



## 实现类

```java
package com.cxy.redis.distributed;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * @program: redis
 * @description: 分布式锁，实现类。
 * @author: cuixy
 * @create: 2020-08-13 16:28
 **/
@Slf4j
public class RedisDistributedLock implements DistributedLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";


    /**
     * redis 客户端
     */
    private Jedis jedis;

    /**
     * 分布式锁的键值
     */
    private String lockKey;

    /**
     * 锁的超时时间 10s
     */
    int expireTime = 10 * 1000;

    /**
     * 锁等待，防止线程饥饿
     */
    int acquireTimeout = 1 * 1000;

    /**
     * 获取指定键值的锁
     *
     * @param jedis   jedis Redis客户端
     * @param lockKey 锁的键值
     */
    public RedisDistributedLock(Jedis jedis, String lockKey) {
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    /**
     * 获取指定键值的锁,同时设置获取锁超时时间
     *
     * @param jedis          jedis Redis客户端
     * @param lockKey        锁的键值
     * @param acquireTimeout 获取锁超时时间
     */
    public RedisDistributedLock(Jedis jedis, String lockKey, int acquireTimeout) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.acquireTimeout = acquireTimeout;
    }

    /**
     * 获取指定键值的锁,同时设置获取锁超时时间和锁过期时间
     *
     * @param jedis          jedis Redis客户端
     * @param lockKey        锁的键值
     * @param acquireTimeout 获取锁超时时间
     * @param expireTime     锁失效时间
     */
    public RedisDistributedLock(Jedis jedis, String lockKey, int acquireTimeout, int expireTime) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.acquireTimeout = acquireTimeout;
        this.expireTime = expireTime;
    }


    @Override
    public String acquire() {
        try {
            //获取锁的超时时间，超过这个时间则放弃获取锁。
            long end = System.currentTimeMillis() + acquireTimeout;
            //随机生成一个value
            String requireToken = UUID.randomUUID().toString();
            while (System.currentTimeMillis() < end) {
                String result = jedis.set(lockKey, requireToken, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                if (LOCK_SUCCESS.equals(result)) {
                    return requireToken;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public boolean release(String identify) {
        if (identify == null) {
            return false;
        }

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = new Object();
        try {
            result = jedis.eval(script, Collections.singletonList(lockKey),
                    Collections.singletonList(identify));
            if (RELEASE_SUCCESS.equals(result)) {
                log.info("release lock success, requestToken:{}", identify);
                return true;
            }
        } catch (Exception e) {
            log.error("release lock due to error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        log.info("release lock failed, requestToken:{}, result:{}", identify, result);
        return false;
    }

}
```

## 测试类

```java
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
```






