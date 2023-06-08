package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactInfo {

    @JsonProperty("Title")
    public String title;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("AddressKey")
    public String addressKey;
    @JsonProperty("OfficePhone")
    public String officePhone;
    @JsonProperty("HomePhone")
    public String homePhone;
    @JsonProperty("MobilePhone")
    public String mobilePhone;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Fax")
    public String fax;

}