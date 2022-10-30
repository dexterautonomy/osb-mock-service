package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Defaultfri {
    @JsonProperty("fri")
    public String fri = "123456789";
    @JsonProperty("currency")
    public Currency currency = new Currency();
}
