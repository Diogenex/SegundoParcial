package com.utn.RecuParcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Response {

    @SerializedName("")
    private DolarResponse dolar;
}
