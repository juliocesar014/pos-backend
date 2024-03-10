package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.service.ClubeService;
import com.kamikase.web.posbackend.model.dto.ClubeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {
    @Autowired
    private ClubeService service;


    @PostMapping
    public ResponseEntity<Clube> cadastrar(@RequestBody Clube clube) {
        clube = service.cadastrar(clube);
        return ResponseEntity.ok(clube);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clube> alterar(@PathVariable Integer id, @RequestBody Clube clube) {
        clube.setId(id);
        Clube clubeAlterado = service.alterar(clube);
        return ResponseEntity.ok(clubeAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubeResponseDTO> consultarPorId(@PathVariable Integer id) {
        Clube clube = service.consultarPorId(id);


        ClubeResponseDTO dto = new ClubeResponseDTO();
        dto.setId(clube.getId());
        dto.setNome(clube.getNome());
        dto.setEstado(clube.getEstado());
        dto.setEmail(clube.getEmail());
        dto.setCnpj(clube.getCnpj());
        dto.setDataCriacao(clube.getDataCriacao());

        return ResponseEntity.ok(dto);
    }


    @GetMapping
    public ResponseEntity<List<ClubeResponseDTO>> listarTodos() {
        List<Clube> clubes = service.listar();


        List<ClubeResponseDTO> dtos = new ArrayList<>();


        for (Clube clube : clubes) {
            ClubeResponseDTO dto = new ClubeResponseDTO();
            dto.setId(clube.getId());
            dto.setNome(clube.getNome());
            dto.setEstado(clube.getEstado());
            dto.setEmail(clube.getEmail());
            dto.setCnpj(clube.getCnpj());
            dto.setDataCriacao(clube.getDataCriacao());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClubeResponseDTO>> listarPorNome(@PathVariable String nome) {
        List<Clube> clubes = service.listarPorNome(nome);

        List<ClubeResponseDTO> dtos = new ArrayList<>();


        for (Clube clube : clubes) {
            ClubeResponseDTO dto = new ClubeResponseDTO();
            dto.setId(clube.getId());
            dto.setNome(clube.getNome());
            dto.setEstado(clube.getEstado());
            dto.setEmail(clube.getEmail());
            dto.setCnpj(clube.getCnpj());
            dto.setDataCriacao(clube.getDataCriacao());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }
}
