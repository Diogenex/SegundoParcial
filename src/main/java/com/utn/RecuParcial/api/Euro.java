package com.utn.RecuParcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Euro {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("compra")
    private Float compra;

    @SerializedName("venta")
    private Float venta;


}
