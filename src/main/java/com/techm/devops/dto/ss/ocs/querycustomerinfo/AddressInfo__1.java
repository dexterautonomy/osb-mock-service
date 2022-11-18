package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressInfo__1 {

    @JsonProperty("AddressKey")
    public String addressKey;
    @JsonProperty("Address1")
    public String address1;
    @JsonProperty("Address2")
    public String address2;
    @JsonProperty("Address3")
    public String address3;
    @JsonProperty("Address4")
    public String address4;
    @JsonProperty("PostCode")
    public String postCode;

}