package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AcctInfo {

    @JsonProperty("AcctCode")
    public String acctCode;
    @JsonProperty("UserCustomerKey")
    public String userCustomerKey;
    @JsonProperty("UserCustomer")
    public UserCustomer__1 userCustomer;
    @JsonProperty("RootAcctKey")
    public String rootAcctKey;
    @JsonProperty("AcctBasicInfo")
    public AcctBasicInfo acctBasicInfo;
    @JsonProperty("BillCycleType")
    public String billCycleType;
    @JsonProperty("AcctType")
    public String acctType;
    @JsonProperty("PaymentType")
    public String paymentType;
    @JsonProperty("AcctClass")
    public String acctClass;
    @JsonProperty("CurrencyID")
    public String currencyID;
    @JsonProperty("AcctPayMethod")
    public String acctPayMethod;
    @JsonProperty("AddressInfo")
    public List<AddressInfo__2> addressInfo = null;
    @JsonProperty("BillCycleOpenDate")
    public String billCycleOpenDate;
    @JsonProperty("BillCycleEndDate")
    public String billCycleEndDate;

}