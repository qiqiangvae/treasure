#!/bin/zsh
# 使用命令
USAGE="Usage: startup.sh {start|stop|restart}"

# 参数个数
exec_param_count=$#
# 如果不是 stop 命令，那么就是需要启动启动服务，此时参数不能少于3个，如果小于3，则提示使用命令
if [ $1 != "stop" -a $exec_param_count -lt 1 ]; then
    echo $USAGE
    exit
fi

cd $(dirname $0)
WORKSPACE=$(pwd)
# 获取 jar 文件
JAR_NAME=$(ls $WORKSPACE | grep .jar$ | awk '{print "'$LIB_DIR'/"$0}')
FULL_JAR_NAME="$WORKSPACE$JAR_NAME"

# 启动命令
start() {
    # 根据配置文件找出 pid
    echo "WORKSPACE=$WORKSPACE"
    PIDS=$(ps -ef | grep java | grep -v grep | grep "$WORKSPACE" | awk '{print $2}')
    if [ -n "$PIDS" ]; then
        echo "启动失败: 该服务已经在运行中!PID: $PIDS"
        exit 1
    fi

    # 启动，可以根据需求增加或改变调优参数
    echo "准备启动$FULL_JAR_NAME"
    echo "nohup java -Xmx256m -Xms256m -Xms128m -jar $FULL_JAR_NAME -Dspring.config.location=$WORKSPACE/application.yml >/dev/null 2>&1 &"
    nohup java -Xmx256m -Xms256m -Xmn256m -jar "$FULL_JAR_NAME" -Dspring.config.location="$WORKSPACE/application.yml" >/dev/null 2>&1 &

    # 等待启动完成
    COUNT=0
    WAIT_TIME=0
    echo "...................................."
    while [ $COUNT -lt 1 ]; do
        sleep 1
        WAIT_TIME=$(expr $WAIT_TIME + 1)
        # 找出 java 进程｜过滤 grep｜根据全路径文件名找出唯一 pid |统计数量
        COUNT=$(ps -ef | grep java | grep -v grep | grep "$FULL_JAR_NAME" | awk '{print $2}' | wc -l)
        # 大于0 说明进程已经启动成功了
        if [ $COUNT -gt 0 ]; then
            # 启动成功
            break
        fi
        # 大于 120s 超时
        if [ $WAIT_TIME -gt 120 ]; then
            echo "启动超时"
            exit 1
        fi
    done
    echo "...................................."
    PIDS=$(ps -ef | grep java | grep -v grep | grep "$FULL_JAR_NAME" | awk '{print $2}')
    echo "服务启动成功，PID: $PIDS"
}

stop() {
    # 根据配置文件找出 pid
    echo "WORKSPACE=$WORKSPACE"
    PIDS=$(ps -ef | grep java | grep -v grep | grep "$FULL_JAR_NAME" | awk '{print $2}')
    if [ -z "$PIDS" ]; then
        echo "该服务尚未运行!"
        exit
    fi
    kill $PIDS
    echo "正在服务停止,PID:$PIDS"
    # 等待停止
    COUNT=$(ps -ef | grep java | grep -v grep | grep "$FULL_JAR_NAME" | awk '{print $2}' | wc -l)
    WAIT_TIME=0
    echo "...................................."
    # 一直等待进场终止
    while [ $COUNT -gt 0 ]; do
        sleep 1
        WAIT_TIME=$(expr $WAIT_TIME + 1)
        COUNT=$(ps -ef | grep java | grep -v grep | grep "$FULL_JAR_NAME" | awk '{print $2}' | wc -l)
        if [ $WAIT_TIME -gt 120 ]; then
            echo "停止超时，强制停止进程"
            kill -9 PIDS
            exit 1
        fi
    done
    echo "服务已经停止"
}

case $1 in
start)
    start
    ;;
stop)
    stop
    ;;
restart)
    echo "服务重启中"
    stop
    sleep 1
    start
    ;;
*)
    echo $USAGE
    ;;
esac
exit 0