package com.utn.RecuParcial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


enum CurrencyType
{
        DOLAR(140),EURO(160);

        private Integer cotizacion;

        CurrencyType(Integer cotizacion) {
                this.cotizacion = cotizacion;
        }
        public Integer getCotizacion() {
                return cotizacion;
        }

        public static CurrencyType find(final String value) {
                for (CurrencyType v : values()) {
                        if (v.toString().equalsIgnoreCase(value)) {
                                return v;
                        }
                }
                throw new IllegalArgumentException(String.format("Invalid TypeCurrency: %s", value));
        }
}

@Data
@NoArgsConstructor
@Entity
public class Currency {

        @Id
        private Integer id;

        private CurrencyType currencyType;

        private Integer monto;





}
