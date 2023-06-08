package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class QueryCustomerInfoResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader=new ResultHeader();
    @JsonProperty("QueryCustomerInfoResult")
    public QueryCustomerInfoResult queryCustomerInfoResult=new QueryCustomerInfoResult();

}
