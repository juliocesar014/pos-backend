package com.kamikase.web.posbackend.model.dto;

import lombok.Data;

@Data
public class FaseAtualDTO {
    private Integer fase_id;
    private String nome;
    private String slug;
    private String tipo;
    private String _link;
}
