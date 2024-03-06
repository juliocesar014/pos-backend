package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.model.Atleta;
import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.service.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Clube> consultarPorId(@PathVariable Integer id) {
        Clube clube = service.consultarPorId(id);
        return ResponseEntity.ok(clube);
    }

    @GetMapping
    public ResponseEntity<List<Clube>> listarTodos() {
        List<Clube> clubes = service.listar();
        return ResponseEntity.ok(clubes);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Clube>> listarPorNome(@PathVariable String nome) {
        List<Clube> clubes = service.listarPorNome(nome);
        return ResponseEntity.ok(clubes);
    }
}
