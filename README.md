# 集成百度分布式唯一ID生成框架UidGenerator

## 快速上手

### install UidGenerator 到本地

下载百度官方 [UidGenerator][1] 到本地，然后用 maven install 到本地仓库

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

访问 [http://localhost:1111/get][2]


  [1]: https://github.com/baidu/uid-generator
  [2]: http://localhost:1111/get