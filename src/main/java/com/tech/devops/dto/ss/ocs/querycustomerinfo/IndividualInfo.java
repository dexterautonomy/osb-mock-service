package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndividualInfo {

    @JsonProperty("IDType")
    public String iDType;
    @JsonProperty("IDNumber")
    public String iDNumber;
    @JsonProperty("IDValidity")
    public String iDValidity;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("HomeAddressKey")
    public String homeAddressKey;
    @JsonProperty("Gender")
    public String gender;
    @JsonProperty("Nationality")
    public String nationality;
    @JsonProperty("Birthday")
    public String birthday;
    @JsonProperty("NativePlace")
    public String nativePlace;
    @JsonProperty("MaritalStatus")
    public String maritalStatus;
    @JsonProperty("Education")
    public String education;
    @JsonProperty("Occupation")
    public String occupation;
    @JsonProperty("Salary")
    public String salary;
    @JsonProperty("OfficePhone")
    public String officePhone;
    @JsonProperty("HomePhone")
    public String homePhone;
    @JsonProperty("MobilePhone")
    public String mobilePhone;
    @JsonProperty("Fax")
    public String fax;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("IndividualProperty")
    public IndividualProperty individualProperty;

}
