package com.utn.RecuParcial.api;

import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
@Slf4j
public class ApiCallService {

    @CircuitBreaker(name = "Euros", fallbackMethod = "fallback")
    public EuroResponse getCotiEuro() throws IOException, InterruptedException {

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=genedolar&opc=ta"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        final EuroResponse euroResponse = new Gson().fromJson(response.body(), EuroResponse.class);
        System.out.println(euroResponse);
        return euroResponse;
    }

    @CircuitBreaker(name = "Dolar", fallbackMethod = "fallbackdolar")
    public DolarResponse getCotiDolar() throws IOException, InterruptedException {

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=dolar"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        final DolarResponse dolarResponse = new Gson().fromJson(response.body(), DolarResponse.class);
        System.out.println(dolarResponse);
        return dolarResponse;
    }


    public EuroResponse fallback(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return EuroResponse.builder().build();
    }

    public DolarResponse fallbackdolar(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return DolarResponse.builder().build();
    }

}
