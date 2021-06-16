package com.utn.RecuParcial.api.Crack;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CrackResponse {

    @SerializedName("data")
    private List<JugadorPromesa> Jugadores;

}
