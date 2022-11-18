package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryCustomerInfoResult {

    @JsonProperty("Customer")
    public Customer customer=new Customer();
    @JsonProperty("Subscriber")
    public Subscriber subscriber=new Subscriber();
    @JsonProperty("Account")
    public Account account=new Account();

}
