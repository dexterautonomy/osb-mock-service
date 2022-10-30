package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Credentialslist {
    @JsonProperty("credentials")
    public Credentials credentials = new Credentials();
}
