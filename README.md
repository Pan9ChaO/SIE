# Student-Information-Exchange
### 概述
本系统为应付中美项目而临时学习的springboot+thymeleaf的学生信息交换系统，功能较为简单，为后来的受难同学作参考。


代码拉下来以后，配置信息改成自己的，maven 打包，再执行数据库 sql 文件，sql 文件在 lol.sql

进入 target 目录运行 jar 包

```
nohup java -jar 35-s1eproject-0.0.1-SNAPSHOT.jar
```

## 效果展示

java 1.8

maven 3.8.4

mysql 5.5

tomcat 8.5 (项目打包后的运行环境是linux,所以在windows运行时需要将Utils类的地址改为本地tomcat的webapps文件底下的upload文件夹（没有自己加）,upload后面一定要加 / )

展示：http://localhost:8082/group5/
