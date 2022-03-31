# MyShardingSphere
spring boot +  ShardingSphere + mybatis-plus 的集成 <br>
该项目主要使用到的技术是 表的分表分库 数据的脱敏 Seata 的柔性事务 <br>
由于服务器资源不足采用本地测试的方式 <br>
本项目部分代码来源网络 <br>
本项目构建是通过 阿里 spring boot 构建工具构建具体可以参考 https://start.aliyun.com/bootstrap.html <br>
ShardingSphere 中 使用单表 app_format_no 的使用方式 该表主要是为了生成订单号 <br>
### 一、系统环境
## 1.java 环境 openjdk11
## 2.数据库 mysql 5.7.17 以上
## 3.后台框架spring boot2.3.7.RELEASE mybatis-plus3.4.0、ShardingSphere 5.1.0
### 二、文件目录介绍
#### MyShardingSphere 项目更目录

>doc 存放数据库相关的文件

>>create 创建表空间sql语句语句

>>sql 创建和删除分片表语句

>>>sql create-ds0.sql和drop-ds0.sql ds0库创建和删除分片表语句

>>>sql create-ds1.sql和drop-ds1.sql ds1库创建和删除分片表语句

>>>sql undo_log.sql Seata柔性事物日志表需要在ds0和ds1数据库中建立

>>tables 创建表语基础表语句，建议使用 MySQL Workbench

>logs Apache ShardingSphere 默认的 XA 事务管理器为 Atomikos 的日志表

>seata-server-1.4.2 Seata 服务器

### 三、如何使用
#### 1.初始化数据库
工具的选择：建议使用mysql 官方提供的工具 MySQL Workbench <br>
创建ds0和ds1表空间 <br>
导入数据：导入doc\tables <br>
执行  sql  create-ds0.sql 和 create-ds1.sql
在 ds0 和 ds1 中执行 undo_log.sql 语句
#### 2.引入项目
通过maven方式导入项目

### 四、启动 Seata 服务
#### 1.修改配置文件
安装官方提供的方法实现起来很麻烦，其实都不用Dubbo 这个，这里我使用的是这个方法 <br>
将 seata-server-1.4.1/conf/file.conf 替换为 src/main/resources/file.conf 的文件 <br>
注意点：file.conf <br>
service { <br>
disableGlobalTransaction = false <br>
vgroup_mapping.raw-jdbc-group = "default" <br> 
这个中的 src/main/resources/seata.conf 需要这个transaction.service.group = raw-jdbc-group <br>
 
default.grouplist = "127.0.0.1:8091" <br>
enableDegrade = false <br>
disable = false <br>
}
#### 2.启动  Seata <br>
首先删除 seata-server-1.4.2/bin/sessionStore 的 root.data 文件 不然会报错 <br>
具体可以参考他们的官方文档 http://seata.io/en-us/docs/user/quickstart.html <br>
windows下面执行 <br>
.\seata-server.bat -p 8091 -h 127.0.0.1 -m file <br>
linux <br>
sh seata-server.sh -p 8091 -h 127.0.0.1 -m file <br>
现在存在的问题：json decode exception, Cannot construct instance of `java.time.LocalDateTime` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)<br>
问题原因不明，根据官方的说法：只有1.4.2版本才能解决 <br>
所以现在用的是XA事物 <br>
Seata 柔性事务已经解决 <br>
升级Apache ShardingSphere 到 5.1.0 版本解决 Seata 报错问题 <br>

### 五、测试 建议使用 posman 官网地址 https://www.postman.com/
1.插入用户测试http://192.168.43.173:8080/myShardingSphere/appHdrUser/addUsers <br>
2.查询测试http://192.168.43.173:8080/myShardingSphere/appHdrUser/search?pi=1&ps=1000 <br>
3.根据用户id 生成订单测试 http://192.168.43.173:8080/myShardingSphere/appGoodsOrder/addGoodsOrder?userId= <br>
4.根据用户id 查询订单测试 http://192.168.43.173:8080/myShardingSphere/appGoodsOrder/search?pi=1&ps=1000&userId= <br>
5.添加人和订单测试分布事物测试 http://192.168.43.173:8080/myShardingSphere/appGoodsOrder/addUserAndGoodsOrder <br>
