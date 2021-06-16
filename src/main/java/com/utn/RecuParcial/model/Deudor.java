package com.utn.RecuParcial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Deudor {

        private String nombre;

        private CurrencyType currency;

        private String amount;



}
