package com.utn.RecuParcial.api;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
public class EuroResponse {

    @SerializedName("dolar")
    private Euro euro;


}
