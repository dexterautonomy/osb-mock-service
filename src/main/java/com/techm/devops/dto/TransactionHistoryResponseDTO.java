package com.techm.devops.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("gettransactionhistoryresponse")
public class TransactionHistoryResponseDTO {
//    The two annotations below are extremely very important when dealing with XML and lists or arrays (VERY IMPORTANT)
    @JacksonXmlElementWrapper(localName = "transactionhistoryentries")
    @JacksonXmlProperty(localName = "transactionhistoryentry")
    public List<Transactionhistoryentry> transactionhistoryentries;
}
