# Ping++ Java SDK for Account

## 依赖
- gson: 2.6.2
- commons-codec: 1.10
- pingpp-java: 2.2.4

## 导入步骤
1. 先根据 [pingpp-java](https://github.com/PingPlusPlus/pingpp-java) 的步骤导入 pingpp-java；
2. 下载 [libs](/libs) 目录下的 jar 文件，导入到你的工程。

## 初始化
### 设置 apiKey
```java
Pingpp.apiKey = "YOUR_API_KEY";
```
Ping++ 浦发扫码 API 文档(1).md
### 设置签名私钥
密钥需要你自己生成，公钥请填写到 [Ping++ Dashboard](https://dashboard.pingxx.com)。  
建议使用 PKCS\#8 编码的私钥文件。如果你的私钥是 PKCS\#1 编码的，请使用以下命令转换：
``` shell
openssl pkcs8 -topk8 -inform PEM -in pkcs1.pem -outform PEM -nocrypt -out pkcs8.pem
```

设置你的私钥
```java    
Pingpp.privateKey = "<PRIVATE_KEY_CONTENT>";
```

### 设置 App ID
```java    
Pingpp.appId = "<APP_ID>";
```

## 接口调用
具体接口调用请参考 [test](/src/test/java/com/pingplusplus) 目录下的文件。

调用举例（创建用户）：
```java
Map<String, Object> params = new HashMap<String, Object>();
params.put("id", "<USER_ID>");
params.put("address", "Shanghai, China");
params.put("avatar", "https://example.com/avatar.png");
params.put("email", "USER_NAME@gmail.com");
params.put("gender", "MALE");
params.put("mobile", "18602101010");
Map<String, Object> metadata = new HashMap<String, Object>();
metadata.put("custom_key", "custom_value");
params.put("metadata", metadata);

User user = User.create(params);
```
