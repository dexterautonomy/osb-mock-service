package com.techm.devops.dto.spn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultHeader {
    @JsonProperty("CommandId")
    public String commandId = "123456789";
    @JsonProperty("Version")
    public String version = "1";
    @JsonProperty("TransactionId")
    public String transactionId = "1234567890-789854212";
    @JsonProperty("SequenceId")
    public String sequenceId = "zxdfguiop098765432";
    @JsonProperty("ResultCode")
    public String resultCode = "405000000";
    @JsonProperty("OrderId")
    public String orderId = "0987654321";
    @JsonProperty("ResultDesc")
    public String resultDesc = "Operation successful";
    @JsonProperty("OperationTime")
    public String operationTime = "1234567890";
}