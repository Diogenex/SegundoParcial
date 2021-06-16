package com.utn.RecuParcial.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class EuroResponse {

    @SerializedName("dolar")
    @JsonProperty("dolar")
    private Euro euro;


}
