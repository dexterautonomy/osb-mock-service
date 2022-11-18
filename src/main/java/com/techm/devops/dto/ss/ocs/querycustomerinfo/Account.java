package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Account {

    @JsonProperty("AcctKey")
    public String acctKey;
    @JsonProperty("AcctInfo")
    public AcctInfo acctInfo;

}