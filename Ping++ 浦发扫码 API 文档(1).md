# Ping++ 线下扫码代理商接入 API 文档

## 目录

### 1. 子商户
 * [子商户应用](#子商户应用)

### 2. 订单
 * [Orders 商品订单](#Orders_商品订单)
 * [Order_refunds 订单退款](#Order_refunds_订单退款)

### 3. 回调
 * [综合账户 Webhooks 通知](#综合账户_Webhooks_通知)



<h2 id="子商户应用">子商户应用</h2>

**属性** |
----|----

id	  *string*	|子商户对象 id ，即应用 id，由 Ping++ 生成。

object	  *string*	|值为 "sub_app"。

created	  *timestamp*|	创建时间。

display_name	  *string*	|应用名称，2~50 位。

account	  *string*|子商户应用所属 account 对象 id。

description	  *string*|订单附加说明，2~50 位。

metadata	  *hash*|	详见 [元数据](#元数据)。

available_methods	  *list*|	可用的支付渠道列表，不包含余额 balance。

user	  *string*|	平台应用下对应的 user，使用expand 参数开扩展展开用户对象。

level   *int*| 子商户当前层级（注：已有数据该值为 1 ）

parent_app  *string*|父商户应用 ID 


#### 对象示例
```json
{
  "id": "app_q5eff1jHKqXP9qvr",
  "object": "sub_app",
  "created": 1488332846,
  "display_name": "sub_app_display_name",
  "account": "acct_14yPiHyrb1GGub1m",
  "description": "Your description",
  "metadata": {
    "a": "b",
    "c": "d"
  },
  "available_methods": {},
  "user": "test_user_031"
}
```

### 创建子商户应用

调用该接口创建子商户应用。子商户创建的时候会使用user参数创建在APP_ID 下的 business 类型用户, 并且会给子商户自动创建一个用户id 为 0 的 business 类型用户,如果解除子商户会自动禁用该用户 id 为 0 的用户。创建时可以设定父应用，默认值为所属应用（即平台），取值范围为平台以及4级以内的应用，即最多创建 5 级子商户。

**请求参数** |
---- | ----

APP_ID   **required**  *string*|平台的应用 ID，即子商户所属应用。

display_name	  **required**	  *string*|应用名称，2~50 位。

user	  **required**	*string*|平台应用下对应的 user，Ping++ 会自动创建一个 type 为 business 类型的 user，该用户可使用用户模块的所有功能，expandable 开扩展。

parent_app  *optional*	*string*| 父商户应用 ID，必须为平台或者平台下其他的子商户，默认值为平台 

metadata	  *optional*	*hash*|详见 [元数据](#元数据)。

description	  *optional*  *string*|订单附加说明，最多 2~50 位。

#### 定义
``` curl
  POST https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

#### 请求示例
``` curl
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Content-Type: application/json" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
    "display_name": "sub_app_display_name",
    "user": "test_user_031",
    "metadata": {
        "a": "b",
        "c": "d"
    },
    "description": "Your description",
    "parent_app": "app_rDyHSCy14aL8m9ev"
}'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个 `sub_app` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
  "id": "app_q5eff1jHKqXP9qvr",
  "object": "sub_app",
  "created": 1488332846,
  "display_name": "sub_app_display_name",
  "account": "acct_14yPiHyrb1GGub1m",
  "description": "Your description",
  "metadata": {
    "a": "b",
    "c": "d"
  },
  "available_methods": {},
  "user": "test_user_031",
  "parent_app": "app_rDyHSCy14aL8m9ev",
  "level" : 2
}
```
### 查询子商户应用

调用该接口查询子商户应用。

**请求参数** |
---- | ----

app_id   **required**  *string*|平台应用 id。

sub\_app\_id   **required**  *string*| 子商户应用 id。

#### 定义
``` curl
  GET https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps/{SUB_APP_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/apps/app_LibTW1n1SOq9Pin1/sub_apps/app_GaDuf99evvfTi5Wb \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个 `sub_app` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
  "id": "app_GaDuf99evvfTi5Wb",
  "object": "sub_app",
  "created": 1488332846,
  "display_name": "sub_app_display_name",
  "account": "acct_14yPiHyrb1GGub1m",
  "description": "Your description",
  "metadata": {
    "a": "b",
    "c": "d"
  },
  "available_methods": {},
  "user": "test_user_031",
  "parent_app": "app_rDyHSCy14aL8m9ev",
  "level" : 2
}
```
### 更新子商户应用

调用该接口更新子商户应用。

**请求参数** |
---- | ----

app_id   **required**  *string*|平台应用 id。

sub\_app\_id   **required**  *string*|子商户应用 id。

display_name	  *optional*	  *string*|应用名称，2~50 位。

metadata	  *optional*	*hash*|详见 [元数据](#元数据)。

description	  *optional*  *string*|订单附加说明，最多 2~50 位。

parent_app  *optional*  *string*|父商户应用 ID，必须为平台或者平台下其他的子商户

#### 定义
``` curl
  PUT https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps/{SUB_APP_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/apps/app_4OOi9SGuD88GGqbL/sub_apps/app_q5eff1jHKqXP9qvr \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Content-Type: application/json" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
    "display_name": "sub_app_name2",
    "metadata": {
        "key": "value"
    },
    "description": "Your description"
}'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个更新后的 `sub_app` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "id": "app_q5eff1jHKqXP9qvr",
    "object": "sub_app",
    "created": 1488332846,
    "display_name": "sub_app_name2",
    "account": "acct_14yPiHyrb1GGub1m",
    "description": "Your description",
    "metadata": {
        "key": "value"
    },
    "available_methods": {},
    "user": "test_user_031",
    "parent_app": "app_rDyHSCy14aL8m9ev",
    "level" : 2
}
```

### 删除子商户应用

调用该接口更新子商户应用。

**请求参数** |
---- | ----

app_id   **required** *string*|平台应用 id。

sub\_app\_id   **required** *string*| 子商户应用 id。


#### 定义
``` curl
  DELETE https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps/{SUB_APP_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps/app_q5eff1jHKqXP9qvr \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Content-Type: application/json" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个删除确认的对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "deleted": true,
    "id": "SUB_APP_ID"
}
```

### 查询子商户应用列表

调用该接口查询子商户应用。

**请求参数** |
---- | ---- 

app   **required**  *string* | 平台 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。

level  *optional*   *int* | 子商户当前层级

parent_app   *optional*   *string* |父商户应用 ID，必须为平台或者平台下其他的子商户

page   *optional*   *int* | 页码，默认值为"1"，取值范围（1~100000000）。

per_page   *optional*  *int* | 每页数量，默认值为"20"，取值范围（1~100）。

created[gt]   *optional*   *timestamp* | 大于 `charge` 对象的创建时间，用 Unix 时间戳表示。

created[gte]   *optional*  *timestamp* | 大于或等于 `charge` 对象的创建时间，用 Unix 时间戳表示。

created[lt]   *optional*  *timestamp* | 小于 `charge` 对象的创建时间，用 Unix 时间戳表示。

created[lte]   *optional*   *timestamp* | 小于或等于 `charge` 对象的创建时间，用 Unix 时间戳表示。

#### 定义
``` curl
  GET https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/apps/app_LibTW1n1SOq9Pin1/sub_apps \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个子商户对象列表，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
  "object": "list",
  "url": "/v1/apps/app_4OOi9SGuD88GGqbL/sub_apps",
  "has_more": false,
  "data": [
    {
      "id": "app_q5eff1jHKqXP9qvr",
      "object": "sub_app",
      "created": 1488332846,
      "display_name": "sub_app_name2",
      "account": "acct_14yPiHyrb1GGub1m",
      "description": "Your description",
      "metadata": {
        "key": "value"
      },
      "available_methods": {},
      "user": "test_user_031",
      "parent_app": "app_rDyHSCy14aL8m9ev",
      "level": 2
    },
    {...},
    {...}
  ]
}
```
### 子商户应用支付渠道

**参数** | 类型 |描述
---- | ---- | ----
object	|*string*|值为 `channel`。
created	|*timestamp*|	创建时间。
channel |*string* | 支付使用的第三方支付渠道。
params	|*hash*|支付渠道参数列表，参见 [params(各渠道参数规则)](#jump)。
banned	|*bool*|是否禁用，禁用后该渠道不会出现在可用支付渠道列表中。
banned_msg	|*string*|禁用信息。
description	|*string*|描述。

#### 对象示例
```json
{
    "object": "channel",
    "created": 1486198795,
    "channel": "alipay",
    "params": [
        {
          "channel": "alipay",
          "fee_rate": "1",
          "alipay_app_auth_token": "201510BBaabdb44d8fd04607abf8d5931ec75D84",
          "alipay_user_id": "2088011177545623",
          "alipay_auth_app_id": "2013111800001989",
          "alipay_expires_in": "31536000",
          "alipay_re_expires_in": "32140800",
          "alipay_app_refresh_token": "201510BB09dece3ea7654531b66bf9f97cdceE67",
          "auth_type": "alipay_token"
        }
    ],
    "banned": false,
    "ban_msg": "werwerwer",
    "description": ""
}
```

### 创建子商户应用支付渠道

请求参数 |是否必须 | 类型|描述
---- | ---- |----|----
app_id |**required**|*string*|平台应用 ID 。查看[如何获取App ID](https://help.pingxx.com/article/198599)。
sub\_app\_id |**required**|*string*|子商户应用 ID 。
channel |**required** | *string*|支付使用的第三方支付渠道。
params	|**required**|*hash*|支付渠道参数列表，见[params(各渠道参数规则)](#jump)。
banned	|*optional*|*boolean*|禁用信息。当 banned 为 true 时必填；为 false 时选填，可传空字符串将该字段置为空。
banned_msg	|*optional*|*string*|禁用信息。
description	|*optional*|*string*|描述。

#### 定义
``` curl
  POST https://api.pingxx.com/v1/apps/{APP_ID}/sub_apps/{SUB_APP_ID}/channels
```
#### 请求示例
```
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps/app_GaDuf99evvfTi5Wb/channels \
-H "Pingplusplus-Request-Timestamp: 1496934031" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_live_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
  "channel": "isv_wap_cil",
  "banned": false,
  "banned_msg": null,
  "description": "description for channel isv_wap_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}'
```
**返回**

返回一个子商户渠道对象，或者返回一个错误，详见 [错误](https://www.pingxx.com/api#错误)。

#### 返回示例
```json
{
  "object": "channel",
  "channel": "isv_wap_cil",
  "banned": false,
  "banned_msg": null,
  "created": 1496934031,
  "description": "description for channel isv_wap_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}
```
<span id="jump"> params(各渠道参数规则)</span>

> 包括如下渠道：`isv_scan`（用户被扫），`isv_qr`（用户主扫），`isv_wap`（固定码）
 
#### isv_scan 用户被扫
参数 | 类型 | 长度/个数/范围 | 是否必需 | 默认值 | 描述
--- | --- | --- | --- | --- | ---
`fee_rate` 	| integer | [0, 10000] | optional | - |渠道费率
`mer_id` | string | 15 | required |  - |  商户号
`inst_id` | string | 8 | required | - | 机构号
`key` | string | 32 |  required | - | 签名私钥
`support_refund` | boolean | [`true`,`false`] | required | - | 是否支持退款，true：支持，false：不支持


#### 请求示例
```
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps/app_GaDuf99evvfTi5Wb/channels \
-H "Pingplusplus-Request-Timestamp: 1496931036" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_live_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
  "channel": "isv_scan_cil",
  "banned": false,
  "banned_msg": null,
  "description": "description for channel qpay",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}'
```
#### 返回示例
```json
{
  "object": "channel",
  "channel": "isv_scan_cil",
  "banned": false,
  "banned_msg": null,
  "created": 1496931036,
  "description": "description for channel qpay",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}
```

#### isv_qr 用户主扫
参数 | 类型 | 长度/个数/范围 | 是否必需 | 默认值 | 描述
--- | --- | --- | --- | --- | ---
`fee_rate` 	| integer | [0, 10000] | optional | - |渠道费率
`mer_id` | string | 15 | required |  - |  商户号
`inst_id` | string | 8 | required | - | 机构号
`key` | string | 32 |  required | - | 签名私钥
`support_refund` | boolean | [`true`,`false`] | required | - | 是否支持退款，true：支持，false：不支持

#### 请求示例
```
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps/app_GaDuf99evvfTi5Wb/channels \
-H "Pingplusplus-Request-Timestamp: 1496930949" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_live_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
  "channel": "isv_qr_cil",
  "banned": false,
  "banned_msg": null,
  "description": "description for channel isv_qr_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}'
```

#### 返回示例
```json
{
  "object": "channel",
  "channel": "isv_qr_cil",
  "banned": false,
  "banned_msg": null,
  "created": 1496930949,
  "description": "description for channel isv_qr_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}
```


#### isv_wap 线下收钱wap
参数 | 类型 | 长度/个数/范围 | 是否必需 | 默认值 | 描述
--- | --- | --- | --- | --- | ---
`fee_rate` 	| integer | [0, 10000] | optional | - |渠道费率
`mer_id` | string | 15 | required |  - |  商户号
`inst_id` | string | 8 | required | - | 机构号
`key` | string | 32 |  required | - | 签名私钥
`support_refund` | boolean | [`true`,`false`] | required | - | 是否支持退款，true：支持，false：不支持

#### 请求示例
```
curl https://api.pingxx.com/v1/apps/app_1Gqj58ynP0mHeX1q/sub_apps/app_GaDuf99evvfTi5Wb/channels \
-H "Pingplusplus-Request-Timestamp: 1496934031" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_live_ibbTe5jLGCi5rzfH4OqPW9KC: \
-d '{
  "channel": "isv_wap_cil",
  "banned": false,
  "banned_msg": null,
  "description": "description for channel isv_wap_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}'
```
#### 返回示例
```json
{
  "object": "channel",
  "channel": "isv_wap_cil",
  "banned": false,
  "banned_msg": null,
  "created": 1496934031,
  "description": "description for channel isv_wap_cil",
  "params": {
    "fee_rate": 16,
    "mer_id": "288880088880008",
    "inst_id": "98888888",
    "key": "eae4c4426b73e26e48dacf0fd6e9a9e1",
    "support_refund": true
  }
}
```

<h2 id="Orders_商品订单"> Orders 商品订单</h2>

# 订单

## Order 订单

你可以通过`order`对象完成一笔订单的下单和付款动作。在一笔商品订单中可以使用优惠券进行商品折扣，可以通过余额或支付渠道进行付款。目前不支持余额+渠道的组合支付。

**属性** | 
---- | ----
id  *string* | 由 Ping++ 生成的商品对象 ID，19 位字符串。
object  *string* | 值为 "order"。
created  *timestamp* | 订单创建时的 Unix 时间戳。
livemode  *boolean* | 是否处于 `live` 模式。
app  *string* | 支付使用的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
status  *string*| 4种订单状态：`created`（待支付）、`paid`（成功）,`refunded`（是否有退款）,`canceled`（取消）。
paid  *boolean* | 是否已支付。当订单已付金额大于等于订单应付金额（amount_paid ≥ actual_amount）时，该值变为 true
refunded  *boolean* | 是否存在退款信息，无论退款是否成功。
uid  *string* | 1~64位，用户唯一标识，不区分大小写，可以是邮箱账号、手机号等等。
amount *int* |订单总金额，单位：分。
coupon_amount  *int* | 优惠券优惠的金额，单位：分。
actual_amount  *int* | 订单应付金额，单位：分。值为订单总金额减去优惠券优惠的金额（amount - coupon_amount）。
merchant\_order\_no  **required**  *string*| 15-32 位，商户订单号，建议：时间戳+随机数（或交易顺序号），必须在商户系统内唯一。
amount_refunded  *int* | 成功退款总金额，单位：分。
currency  *string* | 3 位 ISO 货币代码，人民币为 `cny`。
subject  *string* | 商品标题，该参数最长为 32 个 Unicode 字符，银联全渠道（`upacp`/`upacp_wap`）限制在 32 个字节。
body  *string* | 商品描述信息，该参数最长为 128 个 Unicode 字符，`yeepay_wap` 对于该参数长度限制为 100 个 Unicode 字符。
client_ip  *ip address* | 发起支付请求客户端的 IP 地址，格式为 IPv4 整型，如 127.0.0.1。
time_paid  *timestamp* | 订单支付完成时的 Unix 时间戳。（银联支付成功时间为接收异步通知的时间）
time_expire  *timestamp* | 订单失效时的 Unix 时间戳。时间范围在订单创建后的 5 分钟到 24 小时，创建时间以 Ping++ 服务器时间为准。 微信对该参数的有效值限制为 2 小时内；银联对该参数的有效值限制为 1 小时内；线下扫码渠道对该参数的有效值为订单创建后的 1 分钟到 24 小时，默认为 23小时59分。
coupon  *string* | 使用的 `coupon` 对象的 `id`，24位。
available_balance	 *int* |	订单支付前，用户的可用余额，单位为分。
receipt_app	 *string*	| 收款方应用。使用收款方应用的渠道参数进行支付。当收款方应用和订单应用不一致时，目前不支持余额支付。 
service_app	 *string*| 服务方应用。承接该交易服务的应用，处于商户应用层级关系的底层。服务方商户层级链上的应用都能看到这笔订单。
available_methods	 *list*| 可使用支付方式名称列表，包含渠道和余额（如果可用）。 
charge_essentials  *hash* | 订单支付要素，包括 `channel`、`transaction_no` 的值和 `credential` 对象。
charges  *list*| Charge 对象列表，其中 Charge 对象不包含 refund 对象。
description  *string* | 订单附加说明，最多 255 个 Unicode 字符。
metadata  *hash* | 详见 [元数据](#元数据)。

**注：** 

- 取消的订单不能支付；过期的订单也不能支付。
- 已经支付、过期的订单不能取消。
- 订单取消会恢复优惠券（如果使用过优惠券的话）。


#### 对象示例
```json
{
    "id": "2001608270000004421",
    "object": "order",
    "created": 1470932865,
    "livemode": false,
    "paid": false,
    "refunded": false,
    "status": "created",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "available_balance": 5000,
    "merchant_order_no": "88888888888",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 0,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": null,
    "time_expire": 1470208948,
    "refunds": {
        "object": "list",
        "url": "/v1/orders/2001608270000004428/refunds",
        "has_more": false,
        "data": [
        ]
    },
    "charge": null,
    "balance_transaction": null,
    "coupon": "300316082514255200000900",
    "description": "test1-description",
    "metadata": {
    },
    "charge_essentials": {
    },
    "user_fee": 0,
    "extra_amount": 0
}
```

### 创建 Order 对象

通过创建`order`对象完成一笔订单的下单动作（确认一笔订单的付款信息），下单时用户可以使用优惠券进行打折，下单完成后该订单状态会变成待支付状态。当用户被禁用时，该请求会被拒绝。

**请求参数** | 
---- | ---- 
app  **required**  *string*|支付使用的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
uid  **optional**  *string*|1~64位，用户唯一标识，不区分大小写，可以是邮箱账号、手机号等等，**不能设置为0**，不传时默认为 0。
merchant\_order\_no  **required**  *string*| 15-32 位，商户订单号，建议：时间戳+随机数（或交易顺序号），必须在商户系统内唯一。
amount  **required**  *int*|订单总金额（必须大于0），单位为对应币种的最小货币单位，人民币为分。如订单总金额为 1 元，`amount` 为 100，么么贷商户请查看申请的借贷金额范围。
currency  **required**  *string*|3 位 ISO 货币代码，人民币为 `cny`。
client_ip  **required**  *string*|发起支付请求客户端的 IP 地址，格式为 IPv4 整型，如 127.0.0.1。
subject  **required**  *string*|商品标题，该参数最长为 32 个 Unicode 字符，银联全渠道（`upacp`/`upacp_wap`）限制在 32 个字节。
body  **required**  *string*|商品描述信息，该参数最长为 128 个 Unicode 字符，`yeepay_wap` 对于该参数长度限制为 100 个 Unicode 字符。
description  *optional*  *string*|订单附加说明，最多 255 个 Unicode 字符。
coupon  *optional*  *string*|24位，使用的 `coupon` 对象的 `id`。
actual_amount  *optional*  *int*|支付订单实际金额，其值为amount订单总金额减去卡券抵扣金额，传了该值就校验是否 actual_amount = amount-核销金额，否则不校验，取值范围：0 ~ 1000000000。
time_expire  *optional*  *timestamp*| 订单失效时的 Unix 时间戳。时间范围在订单创建后的 5 分钟到 24 小时，创建时间以 Ping++ 服务器时间为准。 微信对该参数的有效值限制为 2 小时内；银联对该参数的有效值限制为 1 小时内，线下扫码渠道对该参数的有效值为订单创建后的 1 分钟到 24 小时，默认为 23小时59分。
metadata  *optinal*  *hash*|详见 [元数据](#元数据)。
receipt_app	 *optional*	 *string*|收款方应用对应的 `app` 对象的 `id`。使用收款方应用的渠道参数进行支付。当收款方应用和订单应用不一致时，目前不支持余额支付。 
service_app	 *optional* *string*|服务方应用对应的 `app` 对象的 `id`。承接该交易服务的应用，处于商户应用层级关系的底层。服务方商户层级链上的应用都能看到这笔订单。
royalty_users  *optional* *list*|分润的用户列表，默认为[]，不分润，具体 hash 如下表。
royalty_template *optional* *string*| 分润模版 ID。该参数与 royalty_users 同时传时，会忽略 royalty_template。


**分润的用户列表(royalty_users)参数说明** |  
---- | ----
user	 **required** *string*|分润的 user 对象 id。
amount	 **required** *int*|分润的金额，单位：分。

#### 定义
``` curl
  POST https://api.pingxx.com/v1/orders
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Content-Type: application/json" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
-d '{
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "merchant_order_no": "88888888888",
    "coupon":"300316082514255200000900",
    "amount": "30",
    "client_ip": "127.0.0.1",
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "description": "test1-description",
    "time_expire": "1472282548"
}'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个 `order` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "id": "2001608270000004421",
    "object": "order",
    "created": 1470932865,
    "livemode": false,
    "paid": false,
    "refunded": false,
    "status": "created",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "available_balance": 5000,
    "merchant_order_no": "88888888888",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 0,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": null,
    "time_expire": 1470208948,
    "refunds": {
        "object": "list",
        "url": "/v1/orders/2001608270000004428/refunds",
        "has_more": false,
        "data": [
        ]
    },
    "charge": null,
    "balance_transaction": null,
    "coupon": "300316082514255200000900",
    "description": "test1-description",
    "metadata": {
    },
    "charge_essentials": {
    },
    "user_fee": 0,
    "extra_amount": 0
}
```

### 支付 Order 对象
用户可以使用余额或支付渠道对一笔待支付状态的 `order` 进行付款。付款成功后，会发送 Webhooks 通知。

**请求参数** |  
---- | ---- 
id  **required**  *string*|Ping++ 返回的 `order` 对象的 `id`，用于商品订单查询、退款。
charge_amount  **required**  *int*|渠道支付金额。
channel  *optional*  *string*|支付使用的第三方支付渠道。参考 [支付渠道属性值](#支付渠道属性值)。
extra  *optional*  *hash*|线下扫码需要提交的额外参数，详细参考 [支付渠道 extra 参数说明](# 支付渠道 extra 参数说明)。
charge_order_no  *optional*  *string*|支付使用的商户订单号，默认使用订单对象中的商户订单号。

#### 定义
``` curl
POST https://api.pingxx.com/v1/orders/{ORDER_ID}/pay
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2001608270000004428/pay \
-H "Pingplusplus-Signature: SIGNATURE" \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Content-Type: application/json" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
-d '{
  "charge_amount": 0,
  "balance_amount":10
}'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个 `order` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "id": "2001608270000004421",
    "object": "order",
    "created": 1472228865,
    "livemode": false,
    "paid": true,
    "refunded": false,
    "status": "paid",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "available_balance": 5000,
    "merchant_order_no": "88888888888",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 10,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": 1472228975,
    "time_expire": 1472282548,
    "refunds": {
        "object": "list",
        "url": "/v1/orders/2001608270000004428/refunds",
        "has_more": false,
        "data": [
        ]
    },
    "charge": null,
    "balance_transaction": "310216082700270000001101",
    "coupon": "300316082514255200000900",
    "description": "test1-description",
    "metadata": {
    },
    "charge_essentials": {
    },
    "user_fee": 0,
    "extra_amount": 0
}
```

### 取消 Order 对象

你可以对待支付状态的`order`对象进行取消动作，订单被取消后不能支付，如果订单取消支付前用户已经打开了支付控件之类的并在订单取消后进行了支付，则该订单仍然会被标记为已付款，你需要确定用户的真实意图进行发货或者退款。
如果订单使用了优惠券，优惠券会在订单取消后自动恢复。

**请求参数** | 
---- | ---- 
id  **required**  *string*|Ping++ 返回的 `order` 对象的 `id`，用于商品订单查询、退款。
status  **required**  *string*|值："canceled"，更新 Order 的状态。
user  *optional*  *string*|发起前，检查该参数是否和订单的 user 一致，默认不检查
**注：**

- 已经支付、过期订单不能取消
- 订单取消会恢复卡券（如果使用过卡券的话）

#### 定义
``` curl
PUT https://api.pingxx.com/v1/orders/{ORDER_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2001608270000004428 \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
-d '
	{
	 "status":"canceled"
	}
'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个取消的 `order` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
 {
    "id": "2011608250000000621",
    "object": "order",
    "created": 1472125527,
    "livemode": false,
    "paid": false,
    "refunded": false,
    "status": "canceled",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "available_balance": 5000,
    "merchant_order_no": "88888888019",
    "type": "purchase",
    "amount": 20,
    "coupon_amount": 20,
    "balance_amount": 0,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": null,
    "time_expire": 1472126411,
    "refunds":{
    "object": "list",
    "url": "/v1/orders/2011608250000000622/refunds",
    "has_more": false,
    "data":[]
    },
    "charge": null,
    "balance_transaction": null,
    "coupon": "300316082514255200001000",
    "description": "test1-description",
    "metadata":{},
    "charge_essentials":{},
    "user_fee": 0,
    "extra_amount": 0
}
```

### 查询 Order 对象

调用该接口查询 `order` 对象。

**请求参数** | 
---- | ----
id  **required** *string*|Order 订单对象的 ID 。

#### 定义
``` curl
  GET https://api.pingxx.com/v1/orders/{PING_ORDER_ID}/
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2001608270000004428/ \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个 `order` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "id": "2011608250000000971",
    "object": "order",
    "created": 1472124353,
    "livemode": false,
    "paid": false,
    "refunded": false,
    "status": "created",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "available_balance": 5000,
    "merchant_order_no": "88888888009",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 0,
    "charge_amount": 10,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": 1472124411,
    "time_expire": 1472126411,
    "refunds":[],
    "charge": "ch_b1ybz1GO4CaD1eTy1CevXTmH",
    "balance_transaction": null,
    "coupon": "300316082514255200001000",
    "description": "test1-description",
    "metadata":{},
    "charge_essentials":{
        "channel": "wx",
        "transaction_no": null,
        "credential":{
            "object": "credential",
            "wx":{
                "appId": "wxxhmb1s1y58c0gy54",
                "partnerId": "1262535901",
                "prepayId": "1101000000160825f5gss40gahwl8wxl",
                "nonceStr": "dcb247fe1b54de35de67aea796856d92",
                "timeStamp": 1472124411,
                "packageValue": "Sign=WXPay",
                "sign": "5226e593b3dd9943217de6f5e1cf391b3c514612"
            }
        },
        "extra": {}
    },
    "user_fee": 0,
    "extra_amount": 0
}
```

### 查询 Order 对象列表

调用该接口查询 `order` 对象列表。

**请求参数** | 
---- | ----
app  **required**  *string* | 支付使用的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
uid  *optinoal* *string*| 付款用户 `id`。
receipt_app  *potional* *string*| 收款方应用对应的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
service_app  *potional* *string*| 服务方应用对应的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
paid  *optional* *boolean* | 是否付款。
refunded  *optional*  *boolean* | 是否存在退款信息，无论退款是否成功。
canceled  *optional* *int* | "0"：未取消，"1"：已取消。
type  *optional* *string*|	"purchase"：消费订单，"recharge"：充值订单。（兼容旧版）
page  *optional* *int* | 页码，默认值为"1"，取值范围（1~100000000）。
per_page  *optional* *int* | 每页数量，默认值为"20"，取值范围（1~100）。
created[gt]  *optional*  *timestamp* | 大于 `charge` 对象的创建时间，用 Unix 时间戳表示。
created[gte]  *optional*  *timestamp* | 大于或等于 `charge` 对象的创建时间，用 Unix 时间戳表示。
created[lt]  *optional*  *timestamp* | 小于 `charge` 对象的创建时间，用 Unix 时间戳表示。
created[lte]  *optional*  *timestamp* | 小于或等于 `charge` 对象的创建时间，用 Unix 时间戳表示。
	

#### 定义
``` curl
  GET https://api.pingxx.com/v1/orders/
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/ \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
**返回**

返回一个 `order` 对象列表，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
    "object": "list",
    "url": "/v1/orders/",
    "has_more": false,
    "data": [
        {
            "id": "2001608270000004421",
            "object": "order",
            "created": 1472228865,
            "livemode": false,
            "paid": true,
            "refunded": true,
            "status": "created",
            "app": "app_1Gqj58ynP0mHeX1q",
            "uid": "user_002",
            "available_balance": 5000,
            "merchant_order_no": "88888888888",
            "type": "purchase",
            "amount": 30,
            "coupon_amount": 20,
            "balance_amount": 10,
            "charge_amount": 0,
            "amount_refunded": 10,
            "currency": "cny",
            "subject": "test1",
            "body": "test1body1",
            "client_ip": "127.0.0.1",
            "time_paid": 1472228975,
            "time_expire": 1472282548,
            "refunds": {
                "object": "list",
                "url": "/v1/orders/2001608270000004428/refunds",
                "has_more": false,
                "data": [
                    {
                        "id": 2111608270000005209,
                        "object": "order_refund",
                        "order": "2001608270000004428",
                        "app": "app_1Gqj58ynP0mHeX1q",
                        "uid": "user_002",
                        "merchant_order_no": "88888888888",
                        "amount": 10,
                        "coupon_amount": 20,
                        "balance_amount": 10,
                        "charge_amount": 0,
                        "coupon": "300316082514255200000900",
                        "balance_transaction": "310216082700270000001101",
                        "charge_refund": null,
                        "status": "succeeded",
                        "created": 1472229138,
                        "time_succeed": null,
                        "description": "test-refund",
                        "metadata": {},
                        "extra": {}
                    }
                ]
            },
            "charge": null,
            "balance_transaction": "310216082700270000001101",
            "coupon": "300316082514255200000900",
            "description": "test1-description",
            "metadata": {},
            "charge_essentials": {},
            "user_fee": 0,
            "extra_amount": 0,
            "uid":"user_001",
            "receipt_app": "receipt_app_id",
            "service_app": "service_app_id"
        },
        {...},
        {...}
    ]
}
```

### 查询 order 订单中 charge 对象

可以调用此接口查询`order`订单中的 charge 对象状态，返回值为 charge 对象。


**请求参数** | 
---- | ----
APP_ID  **required**  *string* | 支付使用的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
ORDER_ID  **required**  *string* |Order 订单对象的 ID 。
CH_ID  **required** *string*  | charge对象ID。

#### 定义
``` curl
GET https://api.pingxx.com/v1/orders/{ORDER_ID}/charges/{CHARGE_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```


#### 请求示例
```
curl https://api.pingxx.com/v1/orders/2001608270000004421/charges/ch_mPGm1KOGG844eLWvDOfHWvvD \
-H "Pingplusplus-Signature: {SIGNATURE}" \
-H "Pingplusplus-Request-Timestamp: 1496728534" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 返回示例
```json
{
    "id": "ch_mPGm1KOGG844eLWvDOfHWvvD",
    "object": "charge",
    "created": 1496743617,
    "livemode": false,
    "paid": true,
    "refunded": true,
    "app": "app_4OOi9SGuD88GGqbL",
    "channel": "alipay",
    "order_no": "201706000167",
    "client_ip": "127.0.0.1",
    "amount": 1,
    "amount_settle": 1,
    "currency": "cny",
    "subject": "测试订单007",
    "body": "订单内容007",
    "extra": {
    "buyer_account": "alipay_account"
    },
    "time_paid": 1496743628,
    "time_expire": 1496830017,
    "time_settle": null,
    "transaction_no": "2017060641835586",
    "amount_refunded": 0,
    "failure_code": null,
    "failure_msg": null,
    "metadata": {},
    "credential": {},
    "description": null
}
```

### 查询 order 订单中 Charge 对象列表
调用此接口查询`order`订单中所包含的 charge 对象列表。

**请求参数** | 
---- | ----
ORDER_ID   **required**  *integer*  | 订单ID
channel  *optional* *string* | 支付使用的支付渠道。参考 [支付渠道属性值](#支付渠道属性值) 。
paid  *optional* *boolean*  | 是否已付款。
refunded  *optional* *boolean*  | 是否存在退款信息，无论退款是否成功。
page  *optional*  *integer*  | 页码，取值范围：1-100000000。默认为1
per_page  *optional*  *integer* | 每页数量，取值范围：1-100，默认为10.

#### 定义
```curl
GET https://api.pingxx.com/v1/orders/{ORDER_ID}/charges
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 请求示例
```
curl https://api.pingxx.com/v1/orders/2001608270000004421/charges \
-H "Pingplusplus-Signature: {SIGNATURE}" \
-H "Pingplusplus-Request-Timestamp: 1496728534" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```
#### 返回示例
```json
{
  "object": "list",
  "url": "/v1/orders/2001608270000004421/charges",
  "has_more": true,
  "data": [
    {
      "id": "ch_mPGm1KOGG844eLWvDOfHWvvD",
      "object": "charge",
      "created": 1496743617,
      "livemode": false,
      "paid": true,
      "refunded": true,
      "app": "app_4OOi9SGuD88GGqbL",
      "channel": "alipay",
      "order_no": "201706000167",
      "client_ip": "127.0.0.1",
      "amount": 1,
      "amount_settle": 1,
      "currency": "cny",
      "subject": "测试订单007",
      "body": "订单内容007",
      "extra": {
        "buyer_account": "alipay_account"
      },
      "time_paid": 1496743628,
      "time_expire": 1496830017,
      "time_settle": null,
      "transaction_no": "2017060641835586",
      "amount_refunded": 0,
      "failure_code": null,
      "failure_msg": null,
      "metadata": {},
      "credential": {},
      "description": null
    },
    {...},
    {...}
```

### Orders 相关的 Event 类型
该类型的 Event 对象会在 Orders  订单支付成功后触发，以 Webhooks 形式发送至客户配置的 Webhooks URL 。详情请参考 [Events 事件](#events-事件)。

事件类型 |
---- | ----
order.succeeded | 商品订单对象，订单支付成功触发。

##订单退款

对已经支付的订单进行退款，可以使用`order`商品订单对应的退款接口进行，也可以使用`charge`支付对应的退款接口进行。

两类退款接口的区别：

* `order`商品订单退款：使用`order`商品订单支付接口进行付款的订单，可以使用`order`对象中的`order_id`来发起订单退款，也可以使用`order`对象中包含的`charge_id`调用[charge 退款接口](#refunds-退款)进行退款。
* `charge`支付退款：使用`charge`支付接口进行付款的订单，必须使用`charge`支付对应的退款接口进行退款。使用说明参见[charge 退款接口](#refunds-退款)

余额充值类的退款参见[用户余额充值退款](#用户余额充值退款)


**属性** |
---- |---- 
id  *string* | Ping++ 生成的 `refund` 对象的 `id`，用于商品退款订单的查询。
object  *string* | 值为 "refund"。
order_no  *string* | 退款的订单号，由 Ping++ 生成。
app  *string* | 支付使用的 `app` 对象的 `id`，查看[如何获取App ID](https://help.pingxx.com/article/198599)。
amount  *int* | 订单总金额（必须大于0），单位为对应币种的最小货币单位，人民币为分。如订单总金额为 1 元，`amount` 为 100，么么贷商户请查看申请的借贷金额范围。
succeed  *boolean* | 退款是否成功。
status  *string* | 退款状态 pending: 处理中; succeeded: 成功; failed: 失败。
description  *string* | 订单附加说明，最多 255 个 Unicode 字符。
created  *int* |  退款订单创建时的 Unix 时间戳。
time_succeed  *timestamp* | 退款成功时间，用 Unix 时间戳表示。
charge  *string* | refund 对象的所在  charge 对象的  id 。
charge_order_no  *string* | 商户订单号，这边返回的是  charge 对象中的  order_no 参数。
transaction_no  *string* | 支付渠道返回的交易流水号，部分渠道返回该字段为空。
funding_source  *string* | 退款资金来源。取值范围："unsettled_funds"：使用未结算资金退款；"recharge\_funds"：使用可用余额退款。注：默认值"unsettled\_funds"，该参数仅适用于所有微信渠道，包括 wx ,  wx\_pub ,  wx\_pub_qr ,  wx\_lite ,  wx\_wap 五个渠道；该参数仅在请求退款，传入该字段时返回。
failure_code  *string* | 退款的错误码，详见 [错误](https://www.pingxx.com/api#%E9%94%99%E8%AF%AF) 中的错误码。
failure_msg  *string* | 退款消息的描述。
metadata  *hash* | 详见 [元数据](#元数据)。





#### 对象示例
```json
{
  "id": "re_y1u944PmfnrTHyvnL0nD0iD1",
  "object": "refund",
  "order_no": "y1u944PmfnrTHyvnL0nD0iD1",
  "amount": 9,
  "created": 1409634160,
  "succeed": true,
  "status": "succeeded",
  "time_succeed": 1409634192,
  "description": "Refund Description",
  "failure_code": null,
  "failure_msg": null,
  "metadata": {},
  "charge": "ch_L8qn10mLmr1GS8e5OODmHaL4",
  "charge_order_no": "123456789",
  "transaction_no": "2004450349201512090096425284"
}
```
###  创建 refund  对象（针对 order 对象）

通过发起一次退款请求创建一个新的 `refund` 对象，只能对已经发生交易并且没有全额退款的 order 对象发起退款。退款成功后，会发送 Webhooks 通知。充值订单仅支持全额原路退回（到支付渠道）

**请求参数** |
---- | ----
id **required** *string*| 需要退款的订单  order ID 。
charge_amount	 *optional*|	*int*|支付渠道部分退款金额，默认为支付渠道部分全额退款。单位：分。
charge *optional* *string*|在该 order 订单中，要退款的 charge 对象 ID，不填默认全额退款
metadata  *optional*  *hash*| 详见 [元数据](#元数据)。
description  **required**  *string*| 订单附加说明，最多 255 个 Unicode 字符。
refund_mode  *optional* *string*|退款方式。原路退回：`to_source`，退至余额：`to_balance`。默认为原路返回。
funding_source *optional* *string*|退款资金来源。取值范围："unsettled_funds"：使用未结算资金退款；"recharge_funds"：使用可用余额退款。注：默认值"unsettled_funds"，该参数仅适用于所有微信渠道，包括 wx , wx_pub , wx_pub_qr , wx_lite , wx_wap 五个渠道；该参数仅在请求退款，传入该字段时返回。
royalty_users	 *optional* *hash*|退分润的用户列表。默认分润全退，不是分润全退时，需要填写所有分润的用户。具体可参考下表。


**退分润的用户列表参数说明** |
---- |---- 
user  **required** *string*|退分润的 user 对象 id。
amount	 *optional* *int*|退分润的金额，单位：分；不退分润时填 0。 默认分润全退。

#### 定义
``` curl
  POST https://api.pingxx.com/v1/orders/{ORDER_ID}/order_refunds
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```


#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2111608270000005209/order_refunds \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
-d '{
    "description":"test-refund"
}'
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个 `order` 对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例

```json
{
  "object": "list",
  "url": "/v1/orders/2001608270000004421/charge_refunds",
  "has_more": false,
  "data": [
    {
      "id": "re_y1u944PmfnrTHyvnL0nD0iD1",
      "object": "refund",
      "order_no": "y1u944PmfnrTHyvnL0nD0iD1",
      "amount": 800,
      "created": 1499930518,
      "succeed": true,
      "status": "succeeded",
      "time_succeed": 1499930518,
      "description": "Refund Description",
      "failure_code": null,
      "failure_msg": null,
      "metadata": {},
      "charge": "ch_8SCSCCn90ir1bb54m5fjbnX5",
      "charge_order_no": "2017071102122327",
      "transaction_no": "2004450349201512090096425284",
      "extra": {}
    }
  ]
}

```

###  查询 refund 对象

调用该接口查询一笔 `order` 的 `refund` 对象。

**请求参数** |
---- |---- 
id  **required** *string*| 需要查询的退款订单 ID，refund_id。
order_id	 **required** *string*|该笔退款对应的订单 ID,order_id。


#### 定义
``` curl
  GET https://api.pingxx.com/v1/orders/{ORDER_ID}/refunds/{ORDER_REFUND_ID}
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```


#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2111608270000005209/refunds/2001608270000004421 \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个 `refund` 退款对象，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例

``` json
{
    "id": 2111608270000005209,
    "object": "order_refund",
    "order": "2001608270000004421",
    "app": "app_1Gqj58ynP0mHeX1q",
    "uid": "user_002",
    "merchant_order_no": "88888888888",
    "amount": 10,
    "coupon_amount": 20,
    "balance_amount": 10,
    "charge_amount": 0,
    "coupon": "300316082514255200000900",
    "balance_transaction": "310216082700270000001101",
    "charge_refund": null,
    "status": "succeeded",
    "created": 1472229138,
    "time_succeed": 1472229338,
    "description": "test-refund",
    "metadata": {
    },
    "extra": {
    },
    "refund_mode": "to_source"
}
```

###  查询 refund 对象列表

调用该接口查询的 `refund` 对象列表。

**请求参数** | 
---- | ----
id **required** *string*| 需要查询的 `Order` 订单 ID。
page  *optional* *int* | 页码，默认值为"1"，取值范围（1~100000000）。
per_page  *optional* *int* | 每页数量，默认值为"10"，取值范围（1~100）。
created[gt]  *optional*  *timestamp* | 创建时间大于该值，用 Unix 时间戳表示。
created[gte]  *optional*  *timestamp* | 创建时间大于或等于该值，用 Unix 时间戳表示。
created[lt]  *optional*  *timestamp* | 创建时间小于该值，用 Unix 时间戳表示。
created[lte]  *optional*  *timestamp* | 创建时间小于或等于该值，用 Unix 时间戳表示。
status  *optional* *int* | 退款状态，处理中："pending"，成功："succeeded"，失败："failed"。

#### 定义
``` curl
GET https://api.pingxx.com/v1/orders/{PING_ORDER_ID}/refunds
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

#### 请求示例
``` curl
curl https://api.pingxx.com/v1/orders/2111608270000005209/refunds \
-H "Pingplusplus-Request-Timestamp: 1475029155" \
-H "Pingplusplus-Signature: SIGNATURE" \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
待补充
```
```java
待补充
```
```ruby
待补充
```
```javascript
待补充
```
```python
待补充
```
```go
待补充
```
```cs
待补充
```

**返回**

返回一个 `order_refund` 订单退款对象列表，或者返回一个错误，详见 [错误](#错误)。

#### 返回示例
```json
{
  "object": "list",
  "url": "/v1/charges/ch_L8qn10mLmr1GS8e5OODmHaL4/refunds",
  "has_more": false,
  "data": [
    {
      "id": "re_TmbvDKHiXLCSG0mnj9jnDyjA",
      "object": "refund",
      "order_no": "TmbvDKHiXLCSG0mnj9jnDyjA",
      "amount": 100,
      "created": 1410835214,
      "succeed": true,
      "status": "succeeded",
      "time_succeed": 1410835652,
      "description": "Refund Description",
      "failure_code": null,
      "failure_msg": null,
      "metadata": {},
      "charge": "ch_L8qn10mLmr1GS8e5OODmHaL4",
      "charge_order_no": "123456789",
      "transaction_no": "2004450349201512090096425284"
    },
    {...},
    {...}
  ]
}
```

### Orders.refund 相关的 Event 类型
该类型的 Event 对象会在 Orders  订单退款成功后触发，以 Webhooks 形式发送至客户配置的 Webhooks URL 。详情请参考 [Events 事件](#events-事件)。

事件类型 |
---- | ----
order.refund.succeeded | 订单退款对象，订单退款成功触发。




<h2 id="Webhooks_通知">Webhooks 通知</h2>
webhooks 通知是以 POST 形式发送的 JSON，放在请求的 `body` 里，内容是 `event` 对象。`event` 对象属性定义如下。

**参数**| 属性| 描述
---- | ---- | ----
id |*string* | 事件对象 `id` ，由 Ping++ 生成，28 位长度字符串。
object |*string* | 值为 "event"。
livemode |*boolean* | 事件是否发生在生产环境。
created |*timestamp* | 事件发生的时间。
pending_webhooks |*int* | 推送未成功的 webhooks 数量。
type |*string* | 事件类型，详见[事件类型](https://www.pingxx.com/api#event-事件类型)。
request |*string* | API Request ID。值 "null" 表示该事件不是由 API 请求触发的。
data |*hash* | 绑定在事件上的数据对象,具体参考下表 `data` 参数说明。

**data 参数** |类型|描述
---- | ----|----
object |*hash* | 
previous_attributes |*hash* | 绑定对象属性 变化之前的值。只有 *.updated 事件有这个属性。


#### 示例对象
```json
{
    "id": "evt_hMGV2eR15fMupHUdDYibhLop",
    "object": "event",
    "type": "order.succeeded",
    "livemode": true,
    "created": 1472228975,
    "data": {
        "object": {
    "id": "2001608270000004421",
    "object": "order",
    "created": 1472228865,
    "livemode": false,
    "paid": true,
    "refunded": false,
    "status": "paid",
    "app": "app_rzj58S80W9GCCiX9",
    "uid": "15800973612",
    "merchant_order_no": "88888888888",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 10,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": 1472228975,
    "time_expire": 1472282548,
    "refunds": {
        "object": "list",
        "url": "/v1/orders/2001608270000004428/refunds",
        "has_more": false,
        "data": [
        ]
    },
    "charge": null,
    "balance_transaction": "310216082700270000001101",
    "coupon": "300316082514255200000900",
    "description": "test1-description",
    "metadata": {
    },
    "charge_essentials": {
    }
    }
},
    "pending_webhooks": 0,
    "request": "iar_jf1iT0fT0a00v1u5qDvb1u00"
}
```
### Event 事件类型

每个事件类型的作用域都是单个应用，目前支持的事件包括：

事件类型 | 描述
---- | ----
charge.succeeded | 支付对象，支付成功时触发。
refund.succeeded | 退款对象，退款成功时触发。
order.succeeded | 商品订单对象，订单支付成功触发。
order.refund.succeeded | 订单退款对象，订单退款成功触发。


```
事件类型为 charge.succeeded :
{
    "id": "evt_ugB6x3K43D16wXCcqbplWAJo",
    "created": 1427555101,
    "livemode": true,
    "type": "charge.succeeded",
    "data": {
        "object": {
            "id": "ch_Xsr7u35O3m1Gw4ed2ODmi4Lw",
            "object": "charge",
            "created": 1427555076,
            "livemode": true,
            "paid": true,
            "refunded": false,
            "app": "app_1Gqj58ynP0mHeX1q",
            "channel": "upacp",
            "order_no": "123456789",
            "client_ip": "127.0.0.1",
            "amount": 100,
            "amount_settle": 100,
            "currency": "cny",
            "subject": "Your Subject",
            "body": "Your Body",
            "extra": {},
            "time_paid": 1427555101,
            "time_expire": 1427641476,
            "time_settle": null,
            "transaction_no": "1224524301201505066067849274",
            "refunds": {
                "object": "list",
                "url": "/v1/charges/ch_L8qn10mLmr1GS8e5OODmHaL4/refunds",
                "has_more": false,
                "data": []
            },
            "amount_refunded": 0,
            "failure_code": null,
            "failure_msg": null,
            "metadata": {},
            "credential": {},
            "description": null
        }
    },
    "object": "event",
    "pending_webhooks": 0,
    "request": "iar_qH4y1KbTy5eLGm1uHSTS00s"
}
事件类型为 refund.succeeded :
{
    "id": "evt_gJKelawq06CiPojS5gt3noQA",
    "created": 1427555348,
    "livemode": true,
    "type": "refund.succeeded",
    "data": {
        "object": {
            "id": "re_SG0mnjTD3jAHimbvDKjnXLC9",
            "object": "refund",
            "order_no": "SG0mnjTD3jAHimbvDKjnXLC9",
            "amount": 100,
            "created": 1427555346,
            "succeed": true,
            "status": "succeeded",
            "time_succeed": 1427555348,
            "description": "Refund Description",
            "failure_code": null,
            "failure_msg": null,
            "metadata": {},
            "charge": "ch_Xsr7u35O3m1Gw4ed2ODmi4Lw"
        }
    },
    "object": "event",
    "pending_webhooks": 0,
    "request": "iar_Ca1Oe10OqTSOPOmzX9Hi1a5"
}
事件类型为 order.succeeded：
{
    "id": "evt_hMGV2eR15fMupHUdDYibhLop",
    "object": "event",
    "type": "order.succeeded",
    "livemode": true,
    "created": 1472228975,
    "data": {
        "object": {
    "id": "2001608270000004421",
    "object": "order",
    "created": 1472228865,
    "livemode": false,
    "paid": true,
    "refunded": false,
    "status": "paid",
    "app": "app_rzj58S80W9GCCiX9",
    "uid": "15800973612",
    "merchant_order_no": "88888888888",
    "type": "purchase",
    "amount": 30,
    "coupon_amount": 20,
    "balance_amount": 10,
    "charge_amount": 0,
    "amount_refunded": 0,
    "currency": "cny",
    "subject": "test1",
    "body": "test1body1",
    "client_ip": "127.0.0.1",
    "time_paid": 1472228975,
    "time_expire": 1472282548,
    "refunds": {
        "object": "list",
        "url": "/v1/orders/2001608270000004428/refunds",
        "has_more": false,
        "data": [
        ]
    },
    "charge": null,
    "balance_transaction": "310216082700270000001101",
    "coupon": "300316082514255200000900",
    "description": "test1-description",
    "metadata": {
    },
    "charge_essentials": {
    }
    }
},
    "pending_webhooks": 0,
    "request": "iar_jf1iT0fT0a00v1u5qDvb1u00"
}
事件类型为 order_refund.succeeded:
{
    "id": "evt_hMGV2e895fMupHUdDJRJLYU00",
    "object": "event",
    "type": "order_refund.succeeded",
    "livemode": true,
    "created": 1472229338,
    "data": {
        "object": {
            "id": 2111608270000005209,
            "object": "order_refund",
            "order": "2001608270000004421",
            "app": "app_rzj58S80W9GCCiX9",
            "uid": "15800973612",
            "merchant_order_no": "88888888888",
            "amount": 10,
            "coupon_amount": 20,
            "balance_amount": 0,
            "charge_amount": 10,
            "coupon": "300316082514255200000900",
            "balance_transaction": "310216082700270000001101",
            "charge_rfd_id": null,//Ping++ charge 退款 ID
            "status": "succeeded",//退款状态
            "created": 1472229138,
            "time_succeed": 1472229338,
            "description": "test-refund",
            "metadata": {
             },
         "extra": {
                "failure_code":null,
                "failure_msg":null,
                "channel_transaction":"25134179971810968744"
         }
        }
    },
     "pending_webhooks": 0,
     "request": "iar_jf1iT0fT0a18v1u5qDvb1uDS"
}

```
### 查询 Event 对象

通过 `event` 对象的 `id` 查询一个已创建的 `event` 对象。

**请求参数** |描述
---- | ----
id **required** | 事件 `id` 。

#### 定义
```curl
GET https://api.pingxx.com/v1/events/{EVENT_ID}
```
#### 请求示例
```curl
curl https://api.pingxx.com/v1/events/evt_lqVSy5gbL0A68pS8YKvJzdWZ \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
PHP
\Pingpp\Pingpp::setApiKey("sk_test_ibbTe5jLGCi5rzfH4OqPW9KC");
\Pingpp\Event::retrieve('evt_lqVSy5gbL0A68pS8YKvJzdWZ');
```
```java
JAVA
Pingpp.apiKey = "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC";
Event.retrieve("evt_lqVSy5gbL0A68pS8YKvJzdWZ");
```
```ruby
RUBY
require "pingpp"
Pingpp.api_key = "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC"
Pingpp::Event.retrieve("evt_lqVSy5gbL0A68pS8YKvJzdWZ")
```
```javascript
Node.js
var pingpp = require('pingpp')('sk_test_ibbTe5jLGCi5rzfH4OqPW9KC');
pingpp.event.retrieve(
   "evt_lqVSy5gbL0A68pS8YKvJzdWZ",
   function(err, event) {
     // YOUR CODE
   }
);
```
``` python
Python
  import pingpp
pingpp.api_key = 'sk_test_ibbTe5jLGCi5rzfH4OqPW9KC'
pingpp.Event.retrieve('evt_lqVSy5gbL0A68pS8YKvJzdWZ')
```
```go
Go
import (pingpp "github.com/pingplusplus/pingpp-go")
Event, err := client.get("evt_lqVSy5gbL0A68pS8YKvJzdWZ")
```
``` cs
C#
try {
    Event evt = Event.retrieve("evt_lqVSy5gbL0A68pS8YKvJzdWZ");
    Console.WriteLine(evt);
 } catch (Exception e) {
    Console.WriteLine(e.Message.ToString());
}
```
**返回**

返回一个已存在的 `event` 对象或者一个错误，详见 [错误](https://www.pingxx.com/api#错误)。

#### 返回示例
```json
{
    "id": "evt_lqVSy5gbL0A68pS8YKvJzdWZ",
    "created": 1430915345,
    "livemode": true,
    "object": "event",
    "data": {
        "object": {
            "id": "ch_ebT0y9iPGCKCL0aPy9X1WLmT",
            "object": "charge",
            "created": 1430915284,
            "livemode": true,
            "paid": true,
            "refunded": false,
            "app": "app_Xz9iXLn9ebX1SOe1",
            "channel": "wx",
            "order_no": "as223af2ds",
            "client_ip": "127.0.0.1",
            "amount": 100,
            "amount_settle": 100,
            "currency": "cny",
            "subject": "Your Subject",
            "body": "Your Body",
            "extra": [],
            "time_paid": 1430915344,
            "time_expire": 1431001684,
            "time_settle": null,
            "transaction_no": "1001680021201505060112980000",
            "refunds": {
                "object": "list",
                "url": "/v1/charges/ch_ebT0y9iPGCKCL0aPy9X1WLmT/refunds",
                "has_more": false,
                "data": []
            },
            "amount_refunded": 0,
            "failure_code": null,
            "failure_msg": null,
            "metadata": [],
            "credential": [],
            "description": null
        }
    },
    "pending_webhooks": 0,
    "type": "charge.succeeded",
    "request": "iar_0K8m90CCeDK8PabXD00yfTq"
}
```

### 查询 Event 对象列表

返回之前创建 `event` 对象的一个列表。列表是按创建时间进行排序，总是将最新的 `event` 对象显示在最前。

**请求参数** | 类型|描述
---- | ----|----
limit |*optional* | 限制每页可以返回多少对象，范围为 1-20 项，默认是 10 项。
starting_after |*optional* | 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 `id` 是 `obj_end` ，你可以使用 starting_after = `obj_end` 去获取下一页。
ending_before |*optional* | 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的最后一项的 `id` 是 `obj_start` ，你可以使用 `ending_before` = `obj_start` 去获取上一页。
type |*optional* | `event` 对象的类型。
created |*optional* | 对象的创建时间，用 Unix 时间戳表示，具体参考下表 `created` 参数。

**`created`参数** |是否必须|参数类型|描述
---- | ----|----|----
created[gt] |*optional*| *timestamp* | 大于 `event` 对象的创建时间，用 Unix 时间戳表示。
created[gte] |*optional* |*timestamp* | 大于或等于 `event` 对象的创建时间，用 Unix 时间戳表示。
created[lt] |*optional* |*timestamp* | 小于 `event` 对象的创建时间，用 Unix 时间戳表示。
created[lte] |*optional* |*timestamp* | 小于或等于 `event` 对象的创建时间，用 Unix 时间戳表示。

#### 定义
```curl
GET https://api.pingxx.com/v1/events/
```
```php
PHP
\Pingpp\Event::all();
```
```java
JAVA
Event.all(Map options);
```
```ruby
RUBY
Pingpp::Event.all
```
```javascript
Node.js
pingpp.event.list();
```
```python
Python
pingpp.Event.all()
```
```go
Go
pingpp.EventClient.List()
```
```cs
C#
list(Dictionary<String, Object> params)
```
#### 请求示例 
```curl
curl https://api.pingxx.com/v1/events/?limit=3 \
-u sk_test_ibbTe5jLGCi5rzfH4OqPW9KC:
```
```php
PHP
\Pingpp\Pingpp::setApiKey('sk_test_ibbTe5jLGCi5rzfH4OqPW9KC');
\Pingpp\Event::all(array('limit' => 3));
```
``` java
JAVA
Pingpp.apiKey = "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC";

Map<String, Object> eventParams = new HashMap<String, Object>();
eventParams.put("limit", 3);

Event.all(eventParams);
```
```ruby
Ruby
require "pingpp"
Pingpp.api_key = "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC"
Pingpp::Event.all(:limit => 3)
```
```javascript
Node.js
var pingpp = require('pingpp')('sk_test_ibbTe5jLGCi5rzfH4OqPW9KC');
pingpp.event.list({ limit: 3 }, function(err, events) {
 // 异步调用
});
```
```python
Python
import pingpp
pingpp.api_key = 'sk_test_ibbTe5jLGCi5rzfH4OqPW9KC'
res = pingpp.Event.all(limit=3)
```
```go
Go
import (pingpp "github.com/pingplusplus/pingpp-go")
event, err := client.list(params)
```
```cs
C#
Dictionary<String, Object> params = new Dictionary<String, Object>();
params.Add("limit", 3);
    try {
        EventList evts = Event.list(params);
        Console.WriteLine(evts);
    } catch (Exception e) {
        Console.WriteLine(e.Message.ToString());
}
```
**返回**

返回一个已存在的 `event` 对象列表或者一个错误，详见 [错误](https://www.pingxx.com/api#错误)。

#### 返回示例
```json
{
   "object": "list",
   "url": "/v1/events",
   "has_more": true,
   "data": [
     {
        "id": "evt_lqVSy5gbL0A68pS8YKvJzdWZ",
        "created": 1430915345,
        "livemode": true,
        "object": "event",
        "data": {
            "object": {
                "id": "ch_ebT0y9iPGCKCL0aPy9X1WLmT",
                "object": "charge",
                "created": 1430915284,
                "livemode": true,
                "paid": true,
                "refunded": false,
                "app": "app_Xz9iXLn9ebX1SOe1",
                "channel": "wx",
                "order_no": "as223af2ds",
                "client_ip": "127.0.0.1",
                "amount": 100,
                "amount_settle": 100,
                "currency": "cny",
                "subject": "Your Subject",
                "body": "Your Body",
                "extra": [],
                "time_paid": 1430915344,
                "time_expire": 1431001684,
                "time_settle": null,
                "transaction_no": "1001680021201505060112980000",
                   "refunds": {
                    "object": "list",
                        "url": "/v1/charges/ch_ebT0y9iPGCKCL0aPy9X1WLmT/refunds",
                        "has_more": false,
                        "data": []
                    },
                    "amount_refunded": 0,
                    "failure_code": null,
                    "failure_msg": null,
                    "metadata": [],
                    "credential": [],
                    "description": null
                }
            },
    "pending_webhooks": 0,
    "type": "charge.succeeded",
    "request": "iar_0K8m90CCeDK8PabXD00yfTq"
    }
  ]
}
```

## 附加参数说明
### 支付渠道属性值

channel属性值 | 支付渠道名称
---|---
isv_qr|线下用户主扫
isv_scan|线下用户被扫
isv_wap|线下固定码

### 支付渠道 extra 参数说明

**isv_qr 线下用户主扫**

参数 | 类型 |是否必须 | 描述
---- | ----  | ---- | ----
pay_channel | *string* |  required | 当支付具体渠道（不同接入商渠道的支持会有差异，目前是迅联的），支持：alipay、wx
terminal_id | *string(1-8)* |  required | 终端号，要求不同终端此号码不一样，会显示在对账单中，如`A01`、`SH008`等。如没有终端概念，可使用00000001。
goods_list | *array* | optional | 商品列表，详情请参考：[goods_list 参数说明](#goods_list参数说明)
chcd_discount | *string(1-13)* |   optional | 返回信息，渠道优惠（单位：元）
mer_discount | *string(1-13)* |  optional | 返回信息，商户优惠（单位：元）
buyer_account | *string(1-64)* |   optional | 返回信息，渠道账号
buyer_user_id | *string(1-64)* |   optional | 返回信息，渠道账号ID


**isv_scan 线下用户被扫**

参数 | 类型 | 是否必须 | 描述
---- | ----| ---- | ----
scan_code | *string(1-32)* | required | 客户端软件中展示的条码值，扫码设备扫描获取
terminal_id | *string(1-8)*| required | 终端号，要求不同终端此号码不一样，会显示在对账单中，如`A01`、`SH008`等
goods_list | *array*| optional | 商品列表，详情请参考：[goods_list 参数说明](#goods_list参数说明)
pay_channel | *string*| optional |用户支付渠道
chcd_discount | *string(1-13)* |  optional | 返回信息，渠道优惠（单位：元）
mer_discount | *string(1-13)* |  optional | 返回信息，商户优惠（单位：元）
buyer_account | *string(1-64)* |  optional | 返回信息，渠道账号
buyer_user_id | *string(1-64)* |  optional | 返回信息，渠道账号ID

**isv_wap 线下固定码**

参数 | 类型 | 是否必须 | 描述
---- | ---- | ---- | ----
pay_channel | *string*  | required | 支付具体渠道（不同接入商渠道的支持会有差异），支持：alipay、wx
result_url | *string(1-120)*  | required | 前台通知地址，支付成功或失败后，需要跳转到的地址URL
terminal_id | *string(1-8)* | required | 终端号，如没有终端概念，可使用00000001
goods_list | *array(1-8192)*  | optional | 商品列表，详情请参考：[goods_list 参数说明](#goods_list参数说明)
chcd_discount | *string(1-13)* |  optional | 返回信息，渠道优惠（单位：元）
mer_discount | *string(1-13)* |  optional | 返回信息，商户优惠（单位：元）
buyer_account | *string(1-64)* |  optional | 返回信息，渠道账号
buyer_user_id | *string(1-64)* |  optional | 返回信息，渠道账号ID


#### goods_list 参数说明
**上送格式为:**  
```json
[{"goods_id":"iphone6s16G","unified_goods_id":"1001","goods_name":"iPhone6s 16G","goods_num":"1","price":"528800","goods_category":"123456","body":"苹果手机16G","show_url":"https://www.example.com"},{"goods_id":"iphone6s32G","unified_goods_id":"1002","goods_name":"iPhone6s 32G","goods_num":"1","price":"608800","goods_category":"123789","body":"苹果手机32G","show_url":"https://www.example.com"}]
```

参数 | 类型 | 是否必须 | 描述 | 示例
---- | ---- | ---- | ---- | ---- 
goods_name| *string* | required |商品名称 | iphone6s16G
price|*int*| required |单价（单位：分） | 1001
goods_num|*int*| required |数量 | 1
goods_id|*string*| required |商户定义商品编号（一般商品条码） | iphone6s16G
unified_goods_id|*string*| optional |统一商品编号 | 1001
goods_category|*string*| optional |商品类目 | 123456
body|*string*| optional |商品描述信息 | 苹果手机16G
show_url|*string*| optional |商品的展示网址 | https://www.example.com