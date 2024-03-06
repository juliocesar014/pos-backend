package com.kamikase.web.posbackend.service;

import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClubeService {
    @Autowired
    private ClubeRepository repository;

    public Clube cadastrar(Clube clube) {
        return repository.save(clube);
    }

    public List<Clube> listar() {
        return repository.findAll();
    }

    public List<Clube> listarPorNome(String nome) {
        return repository.findByNomeOrderByNomeAsc(nome);
    }

    public Clube alterar(Clube clube) {
        if (Objects.isNull(clube.getId())) {
            throw new RuntimeException();
        }
        return repository.save(clube);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Clube consultarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
