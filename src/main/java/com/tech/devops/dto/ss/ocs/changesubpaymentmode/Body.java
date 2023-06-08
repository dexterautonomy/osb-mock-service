package com.tech.devops.dto.ss.ocs.changesubpaymentmode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeSubPaymentModeResultMsg")
    private ChangeSubPaymentModeResultMsg changeSubPaymentModeResultMsg = new ChangeSubPaymentModeResultMsg();
}
