package com.utn.RecuParcial.controller;

import com.utn.RecuParcial.AbstractController;
import com.utn.RecuParcial.api.ApiCallService;
import com.utn.RecuParcial.api.Crack.CrackResponse;
import com.utn.RecuParcial.api.Crack.JugadorPromesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ApiController.class)
class ApiControllerTest extends AbstractController {

    private ApiCallService apiService;

   // private static List<JugadorPromesa> jugadores = (List<JugadorPromesa>) JugadorPromesa.builder().firstname("Leandro").build();
    private static CrackResponse EMPTY = CrackResponse.builder().build();
   // private static CrackResponse response =  CrackResponse.builder().Jugadores(jugadores).build();

    @BeforeEach
    public void setUp() {
        apiService = mock(ApiCallService.class);

    }

    @DisplayName("Testeando método promesas")
    @Test
    void getCracks() throws IOException, InterruptedException {
        //given
      //  when(apiService.getCracks().thenReturn(response));
        //Then
        CrackResponse respuesta = apiService.getCracks();

        //Assert
        //assertEquals(HttpStatus.OK, respuesta.);

    }
    @DisplayName("Testeando método")
    @Test
    void getallCracks() throws Exception {
        final ResultActions resultActions = givenController().perform(MockMvcRequestBuilders
                .get("/api/promesas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(HttpStatus.OK.value(), resultActions.andReturn().getResponse().getStatus());
    }
}