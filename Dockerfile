FROM registry.cn-hongkong.aliyuncs.com/tianyunperfect/jdk8:8u261

WORKDIR /app
COPY bin bin/
COPY lib lib/
COPY *.jar ./
RUN mkdir log

ENTRYPOINT sh /app/bin/boot docker_start
