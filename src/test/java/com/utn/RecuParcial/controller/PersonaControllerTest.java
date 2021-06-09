package com.utn.RecuParcial.controller;

import com.utn.RecuParcial.AbstractController;
import com.utn.RecuParcial.service.PersonaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PersonaController.class)
class PersonaControllerTest extends AbstractController {

    @MockBean
    private PersonaService personaService;

    @Test
    void addPersona() {
    }

    @DisplayName("Testeando método getAllPerson")
    @Test
    void getAll() throws Exception{
        final ResultActions resultActions = givenController().perform(MockMvcRequestBuilders
                .get("/persona")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(HttpStatus.OK.value(), resultActions.andReturn().getResponse().getStatus());
    }

    @Test
    void getPersonById() {
    }

    @Test
    void deletePersona() {
    }

    @Test
    void addJugadorToPerson() {
    }

    @Test
    void addAmigoToPerson() {
    }
}