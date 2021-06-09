package com.utn.RecuParcial.service;


import com.utn.RecuParcial.model.Amigo;
import com.utn.RecuParcial.model.Jugador;
import com.utn.RecuParcial.model.Persona;
import com.utn.RecuParcial.model.Representante;
import com.utn.RecuParcial.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;


    public void add(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Persona getByID(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }

    public void addjugadorToPerson(Integer id, Integer idJugador) {
        Persona persona = getByID(id);
        if(persona instanceof Representante){
            Persona jugador = getByID(idJugador);
            if(jugador instanceof Jugador){
                ((Representante) persona).getJugadorList().add((Jugador) jugador);
                personaRepository.save(persona);
            }
        }


    }

    public void addAmigoToPerson(Integer id, Integer idAmigo) {
        Persona persona = getByID(id);
        if(persona instanceof Representante){
            Persona amigo = getByID(idAmigo);
            if(amigo instanceof Amigo){
                ((Representante) persona).getAmigoList().add((Amigo) amigo);
                personaRepository.save(persona);
            }
        }
    }
}
