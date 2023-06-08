package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class SubBasicInfo {

    @JsonProperty("WrittenLang")
    public String writtenLang;
    @JsonProperty("IVRLang")
    public String iVRLang;
    @JsonProperty("SubLevel")
    public String subLevel;
    @JsonProperty("DunningFlag")
    public String dunningFlag;
    @JsonProperty("SubProperty")
    public List<SubProperty> subProperty = null;

}
