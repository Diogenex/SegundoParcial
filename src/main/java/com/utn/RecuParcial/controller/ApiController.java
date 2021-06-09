package com.utn.RecuParcial.controller;


import com.utn.RecuParcial.api.ApiCallService;
import com.utn.RecuParcial.api.DolarResponse;
import com.utn.RecuParcial.api.EuroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiCallService apiCallService;

    @GetMapping("/euro")
    public EuroResponse getCotiEuro() throws IOException, InterruptedException {
        return apiCallService.getCotiEuro();
    }

     @GetMapping("/dolar")
     public DolarResponse getNba() throws IOException, InterruptedException {
       return apiCallService.getCotiDolar();
    }


}
