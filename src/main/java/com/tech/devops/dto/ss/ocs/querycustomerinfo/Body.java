package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("QueryCustomerInfoResultMsg")
    private QueryCustomerInfoResultMsg queryCustomerInfoResultMsg = new QueryCustomerInfoResultMsg();
}
