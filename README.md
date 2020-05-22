# springboot-parent
springboot-web常用功能整合，包含常用功能。
- springboot-web示例
- log4j2 日志异步打印
- 自动捕获web异常
- controller Long 类型数据自动转换

工具类
- json工具类
- 分布式Id生成器（雪花算法，利用hostName和Ip自动分配，系统多于32个的时候，请使用redis或者mysql来分配。）


## 怎么使用

1、复制项目
```shell script
git clone https://github.com/tianyunperfect/springboot-parent.git
```
2、修成自己的项目名称
```text
1. idea右键修改包名和文件夹名称
2. 修改父pom文件module的引用
3. 修改当前pom文件中jar名称
```

## LICENSE

[MIT LICENSE](https://github.com/tianyunperfect/springboot-parent/blob/master/LICENSE)

## 参考

[springboot初始化](https://www.yuque.com/tianyunperfect/ygzsw4/nmdmva)

[spring boot的log4j2异步日志配置](https://blog.csdn.net/u011493218/article/details/86607172)