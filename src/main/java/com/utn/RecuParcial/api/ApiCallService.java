package com.utn.RecuParcial.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Service
@Slf4j
public class ApiCallService {


    @CircuitBreaker(name = "Euros", fallbackMethod = "fallback")
    public List<EuroResponse> getCotiEuro() throws IOException, InterruptedException {

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
        Type collectionType = new TypeToken<List<EuroResponse>>(){}.getType();
        final List<EuroResponse> euroResponse =  new Gson()
                .fromJson( response.body() , collectionType);
        return euroResponse;
    }

    @CircuitBreaker(name = "Dolar", fallbackMethod = "fallbackdolar")
    public List<DolarResponse> getCotiDolar() throws IOException, InterruptedException {

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
        Type collectionType = new TypeToken<List<DolarResponse>>(){}.getType();
        final List<DolarResponse> lcs =  new Gson()
                .fromJson( response.body() , collectionType);
        System.out.println(lcs);
        return lcs;
    }


    public List<EuroResponse> fallback(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return null;
    }

    public List<DolarResponse> fallbackdolar(final Throwable t) {
        log.info("Fallback cause, {}", t.toString());
        return  null;
    }

}
