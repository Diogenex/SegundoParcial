package com.utn.RecuParcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DolarResponse {

    @SerializedName("casa")
    private List<Casa> casas;


}
