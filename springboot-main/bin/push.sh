mvn clean package -Dmaven.test.skip=true

remote=root@www.xxx.cn
remoteDir=/app/appName/

# 在本地执行的代码，比如上传文件到服务器 scp 本地文件 user@ip:远程目录
scp -r app/target/lib ${remote}:${remoteDir}
scp -r app/target/resource ${remote}:${remoteDir}
scp app/target/*.jar ${remote}:${remoteDir}

# 执行命令
ssh -o StrictHostKeyChecking=no ${remote} > /dev/null 2>&1 << eeooff

cd /app/appName/
sh bin/boot.sh restart

exit
eeooff
echo ok