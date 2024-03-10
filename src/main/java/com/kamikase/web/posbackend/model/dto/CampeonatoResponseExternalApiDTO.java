package com.kamikase.web.posbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CampeonatoResponseExternalApiDTO {

    private Integer campeonato_id;
    private String nome;
    private String slug;
    private String nome_popular;

    @JsonProperty("edicao_atual")
    private EdicaoAtualDTO edicao_atual;

    @JsonProperty("fase_atual")
    private FaseAtualDTO fase_atual;

    private String rodada_atual;
    private String status;
    private String tipo;
    private String logo;
    private String regiao;
    private String _link;

}

