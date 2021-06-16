package com.utn.RecuParcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;



@Data
public class Euro {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("compra")
    private String compra;

    @SerializedName("venta")
    private String venta;


}
