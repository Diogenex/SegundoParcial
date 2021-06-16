package com.utn.RecuParcial.controller;


import com.utn.RecuParcial.api.*;
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




}
