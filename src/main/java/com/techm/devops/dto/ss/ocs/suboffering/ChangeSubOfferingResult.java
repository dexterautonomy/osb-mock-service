package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeSubOfferingResult {

    @JsonProperty("AddOffering")
    public AddOffering addOffering = new AddOffering();
    @JsonProperty("RentDeductionResult")
    public RentDeductionResult rentDeductionResult = new RentDeductionResult();

}