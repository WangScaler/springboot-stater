# Springboot-stater
springboot-stater 是基于springboot并集成了druid、shiro、redis、mybatis-plus、JWT、actuator等工具的初始demo.用户可以在此demo的基础上开发自己的的应用。
## shiro
将session存入redis缓存,避免重复读取mysql数据库，给数据库造成压力。用户访问接口时在认证判断用户是否存在以及用户状态是否正常。授权阶段判断用户是否是指定角色，或者是否有访问接口的权限。
## swagger
展示所有的api
## Druid
使用druid连接池,具有sql监控功能
## mybatis-plys
具有自动生成代码，以及提供简单sql的api,无需手撸
## jwt认证
无状态认证
## actuator
监控整个应用
## jsoup
防止xss攻击