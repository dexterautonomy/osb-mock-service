package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductInst {

    @JsonProperty("ProductID")
    public String productID;
    @JsonProperty("PrimaryFlag")
    public String primaryFlag;
    @JsonProperty("PackageFlag")
    public String packageFlag;
    @JsonProperty("NetworkType")
    public String networkType;
    @JsonProperty("ProductType")
    public String productType;

}
