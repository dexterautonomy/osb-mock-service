package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryBalanceResult {
    @JacksonXmlElementWrapper(localName = "AcctList")
//    @JacksonXmlProperty(localName = "transactionhistoryentry")
//    @JsonProperty("AcctList")
    public final List<AcctList> acctList;

    public QueryBalanceResult() {
        acctList = new ArrayList<>();
        acctList.add(new AcctList());
        acctList.add(new AcctList());
    }
}