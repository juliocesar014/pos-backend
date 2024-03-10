
package com.kamikase.web.posbackend.client;

import java.util.List;


import com.kamikase.web.posbackend.model.dto.CampeonatoResponseExternalApiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(value = "getcampeonatos", url = "https://api.api-futebol.com.br/v1")
public interface GetCampeonatoExternalAPIClient {
    @GetMapping("/campeonatos")
    List<CampeonatoResponseExternalApiDTO> listarCampeonatos(@RequestHeader("Authorization") String token);
}

