package com.utn.RecuParcial.controller;

import com.utn.RecuParcial.model.Persona;
import com.utn.RecuParcial.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public void addPersona(@RequestBody Persona persona) {
        personaService.add(persona);
    }

    @GetMapping
    public List<Persona> getAll() {
        return personaService.getAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonById(@PathVariable Integer id) {
        return personaService.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id){
         personaService.delete(id);
    }

    @PutMapping("/{id}/jugadores/{idJugador}")
    public void addJugadorToPerson(@PathVariable Integer id, @PathVariable Integer idJugador) {
        personaService.addjugadorToPerson(id,idJugador);
    }

    @PutMapping("/{id}/amigos/{idAmigo}")
    public void addAmigoToPerson(@PathVariable Integer id, @PathVariable Integer idAmigo) {
        personaService.addAmigoToPerson(id,idAmigo);
    }
}
