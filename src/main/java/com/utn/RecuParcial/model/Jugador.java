package com.utn.RecuParcial.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Jugador extends Persona {

    private float peso;
    private float altura;
    private int goles;
    private float minutosJugados;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private String fechaNacimiento;

    @Override
    public TypePersona typePersona() {
        return TypePersona.JUGADOR;
    }
}
