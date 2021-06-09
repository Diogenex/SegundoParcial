package com.utn.RecuParcial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Amigo extends Persona {

    private String profesion;
    private String statusSocial;

    @Override
    public TypePersona typePersona() {
        return TypePersona.AMIGO;
    }
}
