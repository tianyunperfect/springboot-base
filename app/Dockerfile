FROM hub.c.163.com/library/openjdk:8-jdk
VOLUME /tmp
ADD target/*.jar app.jar

# 抛出端口，起标记作用
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]