# 集成百度分布式唯一ID生成框架UidGenerator

## 简介

UidGenerator是Java实现的, 基于Snowflake算法的唯一ID生成器（[具体请点击查看官方介绍][1]）。

## 快速上手

### install UidGenerator 到本地

下载百度官方 [UidGenerator][2] 到本地，然后用 maven install 到本地仓库

### 修改数据库连接信息和端口号

因为 UidGenerator 在服务启动的时候会在数据库表中插一条记录，将记录的id作为 workerId，重启时继续插入，意味着 workerId 的分配策略为用完即弃。所以修改数据库信息如下

```
server.port=1111
mysql.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/test
jdbc.username=root
jdbc.password=root
```

默认端口为1111，这个根据实际项目修改

## 启动

访问 [http:localhost:1111/get][3]


  [1]: https://github.com/baidu/uid-generator/blob/master/README.zh_cn.md
  [2]: https://github.com/baidu/uid-generator/blob/master/README.zh_cn.md
  [3]: http://localhost:1111/get