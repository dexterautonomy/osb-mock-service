package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Defaultfris {
    @JsonProperty("defaultfri")
    public Defaultfri defaultfri = new Defaultfri();
}
