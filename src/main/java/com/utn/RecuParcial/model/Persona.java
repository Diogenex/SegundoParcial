package com.utn.RecuParcial.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePersona", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE"),
        @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR"),
        @JsonSubTypes.Type(value = Amigo.class, name = "AMIGO")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona {

    @Id
    private Integer id;

    private String name;
    private String lastName;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePersona typePersona();

}


