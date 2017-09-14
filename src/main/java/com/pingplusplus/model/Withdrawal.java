package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.AppBasedResource;

import java.util.HashMap;
import java.util.Map;

public class Withdrawal extends AppBasedResource {
    String id;
    String object;
    String app;
    Integer amount;
    String assetTransaction;
    String balanceTransaction;
    String channel;
    Long created;
    String description;
    Map<String, Object> extra;
    String failureMsg;
    Integer fee;
    Boolean livemode;
    Map<String, Object> metadata;
    String operationUrl;
    String orderNo;
    String source;
    String status;
    Long timeCanceled;
    Long timeSucceeded;
    String user;
    Integer userFee;
    String settleAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAssetTransaction() {
        return assetTransaction;
    }

    public void setAssetTransaction(String assetTransaction) {
        this.assetTransaction = assetTransaction;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public void setBalanceTransaction(String balanceTransaction) {
        this.balanceTransaction = balanceTransaction;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeCanceled() {
        return timeCanceled;
    }

    public void setTimeCanceled(Long timeCanceled) {
        this.timeCanceled = timeCanceled;
    }

    public Long getTimeSucceeded() {
        return timeSucceeded;
    }

    public void setTimeSucceeded(Long timeSucceeded) {
        this.timeSucceeded = timeSucceeded;
    }

    public Integer getUserFee() {
        return userFee;
    }

    public void setUserFee(Integer userFee) {
        this.userFee = userFee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount;
    }

    /**
     * 创建 withdrawal
     *
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Withdrawal create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(Withdrawal.class), params, Withdrawal.class);
    }

    /**
     * 查询 withdrawal
     *
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Withdrawal retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Withdrawal.class, id), null, Withdrawal.class);
    }

    /**
     * 查询 withdrawal 列表
     *
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static WithdrawalCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(Withdrawal.class), params, WithdrawalCollection.class);
    }

    /**
     * 更新 withdrawal
     *
     * @param id
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Withdrawal update(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.PUT, instanceURL(Withdrawal.class, id), params, Withdrawal.class);
    }

    /**
     * 取消 withdrawal
     *
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Withdrawal cancel(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return update(id, params);
    }

    /**
     * 确认 withdrawal
     *
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Withdrawal confirm(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "pending");
        return update(id, params);
    }

    /**
     * 创建 withdrawal
     *
     * @params userId
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static Withdrawal create(String userId, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        if (params != null) {
            params.put("user", userId);
        }
        return request(RequestMethod.POST, classURL(Withdrawal.class), params, Withdrawal.class);
    }

    /**
     * 查询 withdrawal
     *
     * @param userId
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static Withdrawal retrieve(String userId, String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(RequestMethod.GET, instanceURL(Withdrawal.class, id), null, Withdrawal.class);
    }

    /**
     * 查询 withdrawal 列表
     *
     * @param userId
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static WithdrawalCollection list(String userId, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        if (params != null) {
            params.put("user", userId);
        }
        return request(RequestMethod.GET, classURL(Withdrawal.class), params, WithdrawalCollection.class);
    }

    /**
     * 更新 withdrawal
     *
     * @param userId
     * @param id
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static Withdrawal update(String userId, String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(RequestMethod.PUT, instanceURL(Withdrawal.class, id), params, Withdrawal.class);
    }

    /**
     * 取消 withdrawal
     *
     * @param userId
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static Withdrawal cancel(String userId, String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return update(userId, id, params);
    }

    /**
     * 确认 withdrawal
     *
     * @param userId
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    @Deprecated
    public static Withdrawal confirm(String userId, String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "pending");
        return update(userId, id, params);
    }
}
