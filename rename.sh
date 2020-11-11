#!/usr/bin/env bash

# com.alvin 公司名
# memory  项目名

if [ ! "$2" ]
then
  echo "请输入公司名和项目名"
  exit 1
fi

companyName="$1"
groupName="$2"

# 修改文件
dirName=`pwd | xargs basename`
cd ..
mv ${dirName} ${companyName}-parent
