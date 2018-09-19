# logsdk-java
bi logsdk-java

一、Logsdk简介
	Logsdk主要用于加快服务端日志的开发速度，在sdk中对一些常用的工具类及日志类进行了封装，以减少游戏侧的开发时间，并能够快速地接入大数据平台。
二、Logsdk的组成
      1. 枚举类
          位于com.gameley.bigData.logsdkjava.enums下, 定义了日志中需要使用的枚举
      2. po类
         位于com.gameley.bigData.logsdkjava.po下，定义了所有的日志类
      3. utils工具类
          位于com.gameley.bigData.logsdkjava.utils下，封装了于用于发送日志的及解析配置文件的工具类等
      4. 配置文件
          log_sd.properties, 请将该文件放到classpath下，该文件配置了一些日志需要的设定信息
      5. 说明文档
三、Logsdk的使用
           1. 引入logsdk的jar包
如果使用了maven可以将jar包下载下来放到本地仓库里，在pom.xml文件里添加以下信息：
<dependencies>
	<dependency>
		<groupId>com.gameley.bigData</groupId>
			<artifactId>logsdk-java</artifactId>
			<version>1.0-SNAPSHOT</version>
	</dependency>
</dependencies>

	2.添加配置文件
	   请在项目的classpath路径下添加log_sd.properties配置文件, 需要进行以下配置
	    ip = 127.0.0.1                       #接收日志的服务器ip地址
	    port = 4141                          #接收日志的服务器端口
	    gameId = 1                          #游戏id
	    regionId = 1010001             #区服id
	    channel_plat = 2006603-3,1000401-1     #渠道和平台的对应关系
	   游戏侧需要根据平台分配的实际情况来填写
	3. Logsdk的日志配置
 为了便于排查问题，Logsdk会输出一些日志便于问题的定位，我们使用了基于slf4j框架的	  logback日志系统。如果游戏侧也使用了该框架请在pom.xml里排除logsdk里的logback. 关于配置文件请自行配置
	4.使用步骤
           例如：发送角色登录日志
           	a: 创建对应的日志对象
	LogLoginPo logLoginPo = new LogLoginPo(channelId, uid, LogLoginTypeEnum.login_in, new Date());
使用要点：
1.每个日志类都会一个或者多个带参数的构造器，没有默认构造器，构造器里的参数就是发送该日志所  必填的最少字段，因此所能统计到的信息也是最少的，如果需要统计更多的信息，请进行b操作。
2.参数中有些参数是枚举类型的，这些枚举已经在com.gameley.bigData.logsdkjava.enums包下定义好，使用者不需要自定义枚举，直接根据参数提示到该包下找对应的枚举即可
b: 给对应的属性赋值(如果需要的话)			  logLoginPo.setOnline(100).setGuildId(“1001").setRoleName(LogUtil.stringFilterAll("小灰灰"));
	使用要点：
	1.该操作主要用于传递一些其它用于统计分析的字段，具体根据自身的统计需求进行操作
	2. 可通过链式调用来进行各个属性的赋值
              3. 其中需要使用枚举的地方同 a 步骤里的要点2



	c: 调用LogSendUtil里对应的发送方法
	LogSendUtil.sendLoginLog(logLoginPo);
  使用要点:
  1. LogSendutil中封装了所有的发送日志的方法，只需要将 a和b步骤 中的对象，传入到对应的方法内，日志就能发送出去。
   	其它日志的使用步骤和上面一致。
          5. 日志测试
	为了便于检查日志发送的正确与否，可以到www.xxx.com进行日志测试
