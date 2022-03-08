#!/bin/bash
#1. 将代码打包为jar文件，不包含任何配置文件，放到bin目录下
#2. 将依赖的类库放到lib目录下
#3. 将配置文件放到conf目录下
#4. 如果是spring项目，将spring的总配置文件通过args传入main函数，完成spring config初始化，其他properties文件、spring子配置文件，做出相应修改
#


COMP_NAME=rcmd-api
MAIN_CLASS=cc.pmtv.rcmd.Main
JAVA_ARGS='-server -Xms1024m -Xmx1024m -Djava.awt.headless=true'


WORK_BASE=$(cd `dirname $0`; cd ..; pwd)
cd $WORK_BASE

BIN_DIR=$WORK_BASE/bin
LIB_DIR=$WORK_BASE/lib
CONF_DIR=$WORK_BASE/conf
LOG_DIR=$WORK_BASE/log

PID_FILE=$BIN_DIR/$COMP_NAME.pid
LOG_FILE=$LOG_DIR/$COMP_NAME.out

DEPS_JAR=`ls $LIB_DIR | grep "..*\.jar$"`
CLASS_PATH=`echo '. '$DEPS_JAR | sed -e 's/ /:lib\//g'`

MAIN_JAR=`ls $BIN_DIR | grep "..*\.jar$"`
CLASS_PATH=$CLASS_PATH`echo ' '$MAIN_JAR | sed -e 's/ /:bin\//g'`

CONF_FILE=`ls $CONF_DIR`
CLASS_PATH=$CLASS_PATH`echo ' '$CONF_FILE | sed -e 's/ /:conf\//g'`

CMD='java '$JAVA_ARGS' -classpath '$CLASS_PATH' '$MAIN_CLASS' '$COMP_NAME

#echo ${CMD}

case "$1" in
    start)
        if [ -f $PID_FILE ]
        then
                echo "$PID_FILE exists, process is already running or crashed"
        else
                echo "Starting $COMP_NAME server..."
		
		nohup $CMD >> $LOG_FILE 2>&1 &
	
		echo $! > "$PID_FILE" 
        fi
        if [ "$?" = "0" ]
        then
              echo " is running..."
        fi
        ;;
    stop)
        if [ ! -f $PID_FILE ]
        then
                echo "$PID_FILE does not exist, process is not running"
        else
                PID=$(cat $PID_FILE)
                echo "Stopping ...$PID..."
		[ ! -z ${PID} ] && { 
                	kill -15 "$PID" 
		}
		rm "$PID_FILE"
                echo "Component $COMP_NAME stopped"
        fi
        ;;
  *)
    echo "Usage: ./run.sh {start|stop}" >&2
        exit 1
esac
