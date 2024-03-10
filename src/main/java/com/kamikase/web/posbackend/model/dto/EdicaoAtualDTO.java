package com.kamikase.web.posbackend.model.dto;

import lombok.Data;

@Data
public class EdicaoAtualDTO {
    private Integer edicao_id;
    private String temporada;
    private String nome;
    private String nome_popular;
    private String slug;
}
