#!/bin/bash
#jar包名称初始化，不用手动设置
APP_NAME=
# 切换目录
cd `dirname $0` || exit
cd ..

#查找jar包
for item in *.jar; do
  fileName=$item
  if [ -f "$fileName" ]; then
    if [ "${fileName##*.}" = jar ]; then
      APP_NAME=$fileName
      break
    fi
  fi
done

if [ ! "$APP_NAME" ]; then
  echo 未找到jar包
  exit 1
fi

STDOUT_FILE=/dev/null


# 判断java是否存在
BITS=$(java -version 2>&1 | grep -i 64-bit)
if [ -z "$BITS" ]; then
  echo 未安装JDK8
  exit 1
fi

# 解锁更多参数、
JAVA_OPTS=" -XX:+UnlockExperimentalVMOptions"
# 内存配置，监视程序，然后根据实际情况进行调整，元空间默认20兆左右
# -Xms8g -Xmx8g -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m
JAVA_OPTS="$JAVA_OPTS -server "
# 垃圾收集器、设置分层编译、
JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:+TieredCompilation"
# 自定义配置文件和lib目录，多个目录用冒号分割
# 已修改为分离 lib和 resource，所以 Dloader.path暂时不用
#JAVA_OPTS="$JAVA_OPTS -Dloader.path=config -Djava.io.tmpdir=./tmp "
JAVA_OPTS="$JAVA_OPTS -Djava.io.tmpdir=./tmp "
# 服务器模式、兼容IPV4、编码（避免乱码）、禁止代码调用gc、
JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8  -XX:+DisableExplicitGC"
# gc 日志
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:log/gc.log "
# OOM日志
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=log/heap_dump"

# java调试
if [ "$2" = "debug" ]; then
  JAVA_OPTS="$JAVA_OPTS -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8081 "
fi


# 使用说明，用来提示输入参数
usage() {
  echo "Usage: sh boot [APP_NAME] [start|stop|restart|status]"
  exit 1
}

# 检查程序是否在运行
is_exist() {
  # 获取PID
  PID=$(ps -ef | grep ${APP_NAME} | grep -v $0 | grep -v grep | awk '{print $2}')
  # -z "${pid}"判断pid是否存在，如果不存在返回1，存在返回0
  if [ -z "${PID}" ]; then
    # 如果进程不存在返回1
    return 1
  else
    # 进程存在返回0
    return 0
  fi
}

# 定义启动程序函数
start() {
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is already running, PID=${PID}"
  else
    nohup java -jar $JAVA_OPTS ${APP_NAME} >>${STDOUT_FILE} 2>&1 &
    PID=$(echo $!)
    echo "${APP_NAME} start success, PID=$!"
  fi
}

# 停止进程函数
stop() {
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 "${PID}"
    # 检测是否停止
    COUNT=1
    while [ $COUNT -eq 1 ]; do
      echo -e ".\c"
      sleep 1
      is_exist
      if [ -z "${PID}" ]; then
        COUNT=0
        echo "${APP_NAME} process stop"
      fi
    done
  else
    echo "There is not the process of ${APP_NAME}"
  fi
}

# 重启进程函数
restart() {
  stop
  start
}

# 查看进程状态
status() {
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is running, PID=${PID}"
  else
    echo "There is not the process of ${APP_NAME}"
  fi
}

case $1 in
"start")
  start
  ;;
"stop")
  stop
  ;;
"restart")
  restart
  ;;
"status")
  status
  ;;
*)
  usage
  ;;
esac
exit 0
