package com.utn.RecuParcial.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data

public class DolarResponse {

    @SerializedName("casa")
    @JsonProperty("casa")
    private Casa casas;



}
