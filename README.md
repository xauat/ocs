spring 5 hibernate 5 swagger2  activeMQ cxf

1 pom中不可直接引用 activemq-all，原因 自带spring与配置的spring版本冲突，

activeMQ相比于zeroMQ 配置麻烦，且需要单独的activeMQ的服务
activeMQ服务下载地址
http://activemq.apache.org/components/classic/download/

javax.jms.JMSException: Unknown data type: 47
解决方式：默认连接端口为61616，但API端口为8161

暂时屏蔽 activemq  ActiveMQ.xml,见 web.xml

暂时屏蔽 com.aerors.ocs.mq 包下的注解
TestController 中的注解

2 CXF
java.lang.ClassNotFoundException: com/sun/tools/internal/xjc/api/XJC  缺少tools.jar
jdk自带此包，jre不带， 想办法加入其中，或者在maven中自己加入

3 待解决c3p0日志 由log4j2 接管

4 log4j2 写文件在大并发量的情况下回锁死，解决方法百度