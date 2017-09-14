# ChangeLog

## 1.2.0 (2017-08-23)

#### 新增
- 新增订单退款接口
- 新增余额转账balance_transfers接口
- 新增余额赠送接口 balance_bonuses
- 新增用户余额充值接口 /v1/apps/APP_ID/recharges
- 新增分润模板接口

#### 修改
- 子商户对象新增 level, parent_app 字段, 创建参数新增 parent_app 参数
- 提现创建接口新增 settle_account 参数, channel, extra 参数由必填修改为选填.
- order 退款列表 order_refund 变更为 refund 对象
- 原 order 退款创建、查询列表返回的 order_refund 变更为 refund 对象.
- order 对象新增charge对象列表, actual_amount 参数;
- 订单支付接口支持传商户订单号, 此时支付的商户订单号不等于订单的商户订单号;
- 原 /v1/recharge 接口废弃, 请使用新用户余额充值接口
- 原用户余额转账 transfers 接口废弃, 请使用 balance_transfers 接口
- 原余额提现 withdrawals 废弃, 请使用 /v1/apps/APP_ID/withdrawals 接口
- 原余额收款接口 receipts 废弃, 请使用 balance_bonus 接口
- 原 asset_transactions、transaction_statistics接口下线.

## 1.1.0 (2017-03-28)
#### 新增
- 子商户应用（SubApp）及渠道参数（Channel）接口
- 分润相关接口（Royalty，RoyaltySettlement，RoyaltyTransaction）
- 用户新增结算账户（SettleAccount）

#### 修改
- AssetTransaction 字段删除及增加
- Order 增加字段
- TransactionStatistics 增加字段
- User 增加字段

## 1.0.0 (2016-12-27)
#### 新增
- 用户收款接口 receipts

#### 修改
- 拆分出账户系统 SDK
- 统计、批量提现等对象字段变更
- transfer 移到 Balance 类
- 提现列表增加 total_withdrawals_amount 字段

