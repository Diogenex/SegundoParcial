package com.utn.RecuParcial.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class Currency {

        @Id
        private Integer id;

        @Enumerated(EnumType.STRING)
        private CurrencyType currencyType;

        private Integer monto;

}
