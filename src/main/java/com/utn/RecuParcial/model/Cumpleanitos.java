package com.utn.RecuParcial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Cumpleanitos {

    @Id
    private Integer id;

    private String fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Persona cumplianero;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    @Size(max = 10)
    private Set<Persona> invitados;



}
