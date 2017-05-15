## 文件说明

### 互联互通

> 1，这个目录都是互联互通的标准文档信息
> 2，go， java， python的加密解密代码demo
> 3，对接过程的一些资料

### 互联互通协议补充

> 1，充电网-数联云商小车对接接口规范


## 对接说明

### 第三方对接需要提准备的东西
> 1，给到获取token的密钥
> 2，给到9位的组织机构代码
> 3，给到加密向量值（16位）
> 4，给到加密的私钥（16位）
> 5，给到签名的签名用的密钥（16位）
> 6，给到可以外网访问的回调地址（http url）

### 充电网php测试环境的配置信息
> 1，充电网的组织结构代码：398496746
> 2，其他所有的向量，私钥，密钥都是：1234567890abcdef（注意：这里是他们请求我们接口地址用到的，不是请求他们, 可能会要改动）
> 3，测试服务器请求地址：http://test.platform.chargerlink.com/evcs/v20160701/

### 互联互通请求的签名方式
> 1，请求的内容拼接顺序： OperatorID + Data + TimeStamp + Seq
> 2，比如请求的内容如下： OperatorID = 1111,  Data="aaaa", TimeStamp=20170508111111, Seq=0001
> 3，那么签名的string是： 1111aaaa201705081111110001

### 互联互通响应的签名方式
> 1，响应的内容拼接顺序： ret + msg + data 
> 2，比如响应的内容如下： ret = 0,  msg="1", data="abc" 
> 3，那么签名的string是： 01abc  
