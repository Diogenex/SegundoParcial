package com.utn.RecuParcial.controller;

import com.utn.RecuParcial.model.Cumpleanitos;
import com.utn.RecuParcial.service.CumpleanitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cumpleanito")
public class CumpleanitoController {

    @Autowired
    CumpleanitoService cumpleanitoService;

    @PostMapping
    public void addCumpleanito(@RequestBody Cumpleanitos cumple) {
        cumpleanitoService.add(cumple);
    }

    @GetMapping
    public List<Cumpleanitos> getAll() {
        return cumpleanitoService.getAll();
    }

    @GetMapping("/{id}")
    public Cumpleanitos getCumpleById(@PathVariable Integer id) {
        return cumpleanitoService.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id){
        cumpleanitoService.delete(id);
    }

    @PutMapping("/{id}/personas/{idPersona}")
    public void addJugadorToPerson(@PathVariable Integer id, @PathVariable Integer idPersona) {
        cumpleanitoService.addPersonToCumple(id,idPersona);
    }

    @PutMapping("/{id}/invitados/{idPersona}")
    public void addInvitados(@PathVariable Integer id, @PathVariable Integer idPersona) {
        cumpleanitoService.addInvitados(id,idPersona);
    }
}
