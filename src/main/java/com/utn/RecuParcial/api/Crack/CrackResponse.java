package com.utn.RecuParcial.api.Crack;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class CrackResponse {

    @SerializedName("data")
    private List<JugadorPromesa> Jugadores;

}
