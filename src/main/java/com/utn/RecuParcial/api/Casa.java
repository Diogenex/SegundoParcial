package com.utn.RecuParcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Casa {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("compra")
    private Float compra;

    @SerializedName("venta")
    private Float venta;

    @SerializedName("agencia")
    private String agencia;

}
