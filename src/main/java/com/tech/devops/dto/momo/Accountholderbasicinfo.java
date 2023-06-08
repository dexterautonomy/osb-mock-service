package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Accountholderbasicinfo {
    @JsonProperty("firstname")
    public String firstname = "Chinedu";
    @JsonProperty("surname")
    public String surname = "Ezeigbo";
    @JsonProperty("profilename")
    public String profilename = "Surname And Lastname";
    @JsonProperty("identityvalues")
    public List<String> identityvalues = Arrays.asList("MyIds", "MyCars", "MyMotors", "Lol");
    @JsonProperty("defaultfris")
    public Defaultfris defaultfris = new Defaultfris();
    @JsonProperty("loyaltypointsaccountfri")
    public String loyaltypointsaccountfri = "One billion dollars";
    @JsonProperty("acceptedtc")
    public List<Object> acceptedtc = Arrays.asList("Accept All", "Reject none");
    @JsonProperty("accountholderstatus")
    public String accountholderstatus = "I am an account holder na";
    @JsonProperty("bankdomainname")
    public String bankdomainname = "Bank ESF";
    @JsonProperty("hasparent")
    public String hasparent = "B4 nko";
    @JsonProperty("children")
    public Object children = "Many children";
}
