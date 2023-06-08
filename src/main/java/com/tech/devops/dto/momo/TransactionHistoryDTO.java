package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

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
    public LocalDateTime datefrom;
    @JsonProperty("transactiontypes")
    public String transactiontypes;
}