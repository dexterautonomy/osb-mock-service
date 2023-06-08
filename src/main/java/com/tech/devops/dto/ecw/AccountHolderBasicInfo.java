package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountHolderBasicInfo {
	private String msisdn;
    private String firstname;
    private String surname;
    @JsonProperty("profilename")
    private String profileName;
    @JsonProperty("internalidentity")
    private String internalIdentity;
	@JsonProperty("defaultfris")
    private FinancialResourceInformations financialResourceInformations;
	@JsonProperty("loyaltypointsaccountfri")
    private String loyaltyPointsAccountFRI;
	@JsonProperty("acceptedtc")
    private Object acceptedTermsAndConditions;
	@JsonProperty("accountholderstatus")
    private String accountHolderStatus;
	@JsonProperty("bankdomainname")
    private String bankDomainName;
	@JsonProperty("hasparent")
    private String hasParent;
    @JsonProperty("languagecode")
    private Language language;
    @JsonProperty("children")
    private Object children;
}
