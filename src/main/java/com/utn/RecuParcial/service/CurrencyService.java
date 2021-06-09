package com.utn.RecuParcial.service;


import com.utn.RecuParcial.model.Currency;
import com.utn.RecuParcial.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;


    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    public Currency getByID(Integer id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        currencyRepository.deleteById(id);
    }
}
