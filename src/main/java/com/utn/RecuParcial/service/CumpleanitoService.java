package com.utn.RecuParcial.service;

import com.utn.RecuParcial.model.Cumpleanitos;
import com.utn.RecuParcial.model.Persona;
import com.utn.RecuParcial.repository.CumpleanitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CumpleanitoService {

    @Autowired
    CumpleanitoRepository cumpleanitoRepository;
    @Autowired
    PersonaService personaService;

    public void add(Cumpleanitos cumple) {
        cumpleanitoRepository.save(cumple);
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
        Persona invitado = personaService.getByID(idPersona);
        cumple.getInvitados().add(invitado);
        cumpleanitoRepository.save(cumple);

    }
}
