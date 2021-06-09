package com.utn.RecuParcial.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
public class Representante extends Persona {

    private Integer pesoDeLaBoveda;
    private Integer montoTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
     List<Jugador> jugadorList;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="amigo_id")
    Set<Amigo> amigoList;

    @Override
    public TypePersona typePersona() {
        return TypePersona.REPRESENTANTE;
    }

    public Integer getPesoDeLABoveda() {
        Integer total = 0;
        for (Jugador jugador : jugadorList) {
            total += jugador.getCurrency().getMonto() ;
        }
        return total * 1;
    }

    public Integer getMontoTotal() {

        Integer total = 0;

        for (Jugador jugador : jugadorList) {

            if (jugador.getCurrency().getCurrencyType() == CurrencyType.DOLAR)
                total += jugador.getCurrency().getMonto() * CurrencyType.DOLAR.getCotizacion();
            else if
                (jugador.getCurrency().getCurrencyType() == CurrencyType.EURO)
                total += jugador.getCurrency().getMonto() * CurrencyType.EURO.getCotizacion();

        }
        return total;
    }


}
