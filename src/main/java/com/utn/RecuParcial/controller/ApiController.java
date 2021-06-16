package com.utn.RecuParcial.controller;


import com.utn.RecuParcial.api.*;
import com.utn.RecuParcial.api.Crack.CrackResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiCallService apiCallService;

    @Autowired
    private ApiDolar api;

    @GetMapping("/euro")
    public List<EuroResponse> getCotiEuro() throws IOException, InterruptedException {
        return apiCallService.getCotiEuro();
    }

     @GetMapping("/dolar")
     public List<DolarResponse> getDolar() throws IOException, InterruptedException {
       return apiCallService.getCotiDolar();
    }

    @GetMapping("/dolar1")
    public List<DolarResponse> getDolar1() throws IOException, InterruptedException {
        return api.getDolarEnchages();
    }

    @Operation(summary = "Obtiene una lista de jugadores Mayores a 1.80 de altura y Menor de 20 años.")
    @GetMapping("/promesas")
    public CrackResponse getCracks() throws IOException, InterruptedException {
        return apiCallService.getCracks();
    }



}
