import datetime
import random
import os

def set_sys_date(year, month, day):
    print('date %04d/%02d/%02d' % (year, month, day))
    os.system('date %04d/%02d/%02d' % (year, month, day))

def set_sys_time(hour):
    os.system('time %02d:%02d:%02d' % (hour, random.randint(0,60),random.randint(0,60)))

def commit(msg):
    os.system('git add .')
    os.system('git commit -m %s' % (msg))

if __name__ == '__main__':
    set_sys_date(2016,1,2)   #设置那一天
    set_sys_time(9)          #小时
    commit("解决idea自动重置") #想要深色点，最低三个
