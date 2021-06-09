package com.utn.RecuParcial.controller;

import com.utn.RecuParcial.model.Cumpleanitos;
import com.utn.RecuParcial.model.Persona;
import com.utn.RecuParcial.service.CumpleanitoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cumpleanito")
public class CumpleanitoController {

    @Autowired
    CumpleanitoService cumpleanitoService;

    @Operation(summary = "Ingresar un cumpleaños ")
    @PostMapping
    public void addCumpleanito(@RequestBody Cumpleanitos cumple) {
        cumpleanitoService.add(cumple);
    }

    @Operation(summary = "Obtener todos los cumpleaños ")
    @GetMapping
    public List<Cumpleanitos> getAll() {
        return cumpleanitoService.getAll();
    }

    @Operation(summary = "Obtener cumpleaño por Id ")
    @GetMapping("/{id}")
    public Cumpleanitos getCumpleById(@PathVariable Integer id) {
        return cumpleanitoService.getByID(id);
    }

    @Operation(summary = "Saber deudores de una fiesta ")
    @GetMapping("/deudores/{id}")
    public Set<Persona> getDeudoresInvitados(@PathVariable Integer id) {
        return cumpleanitoService.getInvitados(id);
    }
    @Operation(summary = "Borrar Cumple ")
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
