package com.utn.RecuParcial.model;

public enum TypePersona {
    JUGADOR("Jugador"),
    REPRESENTANTE("Representante"),
    AMIGO("Amigo");
    private String descripcion;

    TypePersona(String descripcion) {
        this.descripcion = descripcion;
    }

    public static TypePersona find(final String value) {
        for (TypePersona p : values()) {
            if (p.toString().equalsIgnoreCase(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypePersona: %s", value));
    }

    public String getDescripcion() {
        return descripcion;
    }
}
