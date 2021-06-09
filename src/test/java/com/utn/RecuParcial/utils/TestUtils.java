package com.utn.RecuParcial.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utn.RecuParcial.model.Persona;
import com.utn.RecuParcial.model.TypePersona;

import java.time.LocalDate;

public class TestUtils {

    public static String aPersonJSON() {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .setPrettyPrinting().create();

        return gson.toJson(aPersona());
    }


    public static Persona aPersona() {
        Persona p = new Persona() {
            @Override
            public TypePersona typePersona() {
                return TypePersona.REPRESENTANTE;
            }
        };
        p.setId(1);
        p.setName("Guillermo");
        p.setLastName("Copolla");

        return p;
    }


}
