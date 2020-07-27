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
MySQL 有的使用它来村粗一些比较大的文件，博客，图片！数据库表很大，效率就低了！如果有一种数
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
>单点登录

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
127.0.0.1:6666> type age # 查看key的类型
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

## getadd 添加地理位置

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

