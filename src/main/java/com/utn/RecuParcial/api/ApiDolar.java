package com.utn.RecuParcial.api;





import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "dolar", url = "${api.dolar.url}")

public interface ApiDolar {

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        List<DolarResponse> getDolarEnchages();

}
