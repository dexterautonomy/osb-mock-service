package com.tech.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeAcctCreditLimitResult {

    @JsonProperty("CreditLimit")
    public CreditLimit creditLimit = new CreditLimit();

}