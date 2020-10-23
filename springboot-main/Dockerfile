FROM hub.c.163.com/library/java:8-alpine
VOLUME /tmp
ADD target/*.jar app.jar

# 抛出端口，起标记作用
EXPOSE 8080

#启动命令
ENTRYPOINT exec java -jar app.jar
# 默认参数
#CMD [""]