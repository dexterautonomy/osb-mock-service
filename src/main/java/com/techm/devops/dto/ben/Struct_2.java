package com.techm.devops.dto.ben;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Struct_2 {
    @JsonProperty("member1")
    private Member_4 mem4;
    @JsonProperty("member2")
    private Member_2 mem2;
    @JsonProperty("member")
    private Member_1 mem1;
}
