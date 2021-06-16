package com.utn.RecuParcial.api.Crack;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JugadorPromesa {

    @SerializedName("player_id")
    private String player_id;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("age")
    private String age;

    @SerializedName("height")
    private String height;

    @SerializedName("country")
    private Country country;






}
