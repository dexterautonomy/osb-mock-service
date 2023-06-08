package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("paymentcompletedrequest")
public class PaymentCompletedRequestDTO {
    @JsonProperty("transactionid")
    public String transactionid;
    @JsonProperty("providertransactionid")
    public String providertransactionid;
    @JsonProperty("newbalance")
    public Newbalance newbalance;
    @JsonProperty("paymenttoken")
    public String paymenttoken;
    @JsonProperty("message")
    public String message;
    @JsonProperty("status")
    public String status;
    @JsonProperty("extension")
    public Object extension;
}