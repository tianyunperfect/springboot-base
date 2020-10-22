APP=intent
VERSION=1.4.0

# 停止容器
docker stop ${APP}
# 删除容器
docker rm ${APP}
# 删除镜像
docker rmi ${APP}:${VERSION}
# 重新生成镜像
docker build -t ${APP}:${VERSION} .
# 运行容器
docker run -di \
--name=${APP} \
-m 8GB \
--cpus=8 \
-p 8900:8900 \
-v /data1/bainuo/config:/app/config \
${APP}:${VERSION}

# 进入系统
#docker exec -it ${APP} /bin/bash

# 查看日志
# docker logs ${APP} -f

# 推送
# docker tag ${APP}:${VERSION} registry.cn-beijing.aliyuncs.com/unisound-docker-registry/${APP}:${VERSION}
# docker push registry.cn-beijing.aliyuncs.com/unisound-docker-registry/${APP}:${VERSION}