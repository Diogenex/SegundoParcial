package com.utn.RecuParcial.controller;



import com.utn.RecuParcial.model.Currency;
import com.utn.RecuParcial.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrecyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public void addCurrency(@RequestBody Currency currency) {
        currencyService.add(currency);
    }

    @GetMapping
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id) {
        return currencyService.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Integer id){
        currencyService.delete(id);
    }


}
