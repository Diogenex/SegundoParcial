package com.utn.RecuParcial.service;

import com.utn.RecuParcial.api.ApiCallService;
import com.utn.RecuParcial.api.DolarResponse;
import com.utn.RecuParcial.model.*;
import com.utn.RecuParcial.repository.CumpleanitoRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CumpleanitoService {

    @Autowired
    CumpleanitoRepository cumpleanitoRepository;
    @Autowired
    PersonaService personaService;
    @Autowired
    ApiCallService apiService;



    public Cumpleanitos add(Cumpleanitos cumple) {
        return cumpleanitoRepository.save(cumple);
    }


    public List<Cumpleanitos> getAll() {
        return cumpleanitoRepository.findAll();
    }


    public Cumpleanitos getByID(Integer id) {
        return cumpleanitoRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        cumpleanitoRepository.deleteById(id);
    }

    public void addPersonToCumple(Integer id, Integer idPersona) {
        Cumpleanitos cumple = getByID(id);
        Persona cumpleaniero = personaService.getByID(idPersona);
        cumple.setCumplianero(cumpleaniero);
        cumpleanitoRepository.save(cumple);
    }

    public void addInvitados(Integer id, Integer idPersona) {
        Cumpleanitos cumple = getByID(id);
        Jugador invitado = personaService.getJugadorByID(idPersona);
        cumple.getInvitados().add(invitado);
        cumpleanitoRepository.save(cumple);

    }

    public List<Deudor> getInvitados(Integer id) {
        Cumpleanitos cumple = getByID(id);
        Set<Jugador> invitados = cumple.getInvitados();
        List<Deudor> deudores = new ArrayList<>();
        invitados.forEach(
                i -> {
                    try {
                        deudores.add(Deudor.builder()
                                .nombre(i.getName() + " " + i.getLastName())
                                .currency(i.getCurrency().getCurrencyType())
                                .amount(this.calcularMonto(i.getCurrency()))
                                .build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        return deudores;

    }

    public String calcularMonto(Currency currency) throws IOException, InterruptedException {
        Currency curren = new Currency();
        if(currency.getCurrencyType() == CurrencyType.DOLAR) {
            this.apiService.getCotiDolar();
            return ("25.000 / cotizacion del euro precio de compra = 231");
        }
        return "hola";
    }

}
