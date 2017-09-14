package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.AccountAPIResource;

import java.util.Map;

public class RoyaltyTransaction extends AccountAPIResource {
    String id;
    String object;
    Integer amount;
    Long created;
    String recipientApp;
    String royaltySettlement;
    String settleAccount;
    String sourceUser;
    String status;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getRecipientApp() {
        return recipientApp;
    }

    public void setRecipientApp(String recipientApp) {
        this.recipientApp = recipientApp;
    }

    public String getRoyaltySettlement() {
        return royaltySettlement;
    }

    public void setRoyaltySettlement(String royaltySettlement) {
        this.royaltySettlement = royaltySettlement;
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 查询 royalty_transaction
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
    public static RoyaltyTransaction retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(RoyaltyTransaction.class, id), null, RoyaltyTransaction.class);
    }

    /**
     * 查询 royalty_transaction 列表
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
    public static RoyaltyTransactionCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(RoyaltyTransaction.class), params, RoyaltyTransactionCollection.class);
    }
}
