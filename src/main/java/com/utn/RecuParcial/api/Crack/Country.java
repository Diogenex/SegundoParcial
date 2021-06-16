package com.utn.RecuParcial.api.Crack;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {

    @SerializedName("country_id")
    private String country_id;

    @SerializedName("name")
    private String name;

    @SerializedName("country_code")
    private String country_code;

    @SerializedName("continent")
    private String continent;
}
