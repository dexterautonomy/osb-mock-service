package com.techm.devops.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonRootName("gettransactionhistoryrequest")
public class TransactionHistoryDTO {
    @JsonProperty("fri")
    public String fri;
    @JsonProperty("otherfri")
    public String otherfri;
    @JsonProperty("transactionstatus")
    public String transactionstatus;
    @JsonProperty("datefrom")
    public String datefrom;
    @JsonProperty("transactiontypes")
    public String transactiontypes;
}