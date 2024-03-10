package com.kamikase.web.posbackend.model.dto;

import lombok.Data;

@Data
public class ClubeResponseDTO {
    private Integer id;
    private String nome;
    private String estado;
    private String email;
    private String cnpj;
    private Integer dataCriacao;

}
