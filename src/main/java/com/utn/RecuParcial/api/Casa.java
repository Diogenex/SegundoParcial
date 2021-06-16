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
    private String compra;

    @SerializedName("venta")
    private String venta;

    @SerializedName("agencia")
    private String agencia;

}
