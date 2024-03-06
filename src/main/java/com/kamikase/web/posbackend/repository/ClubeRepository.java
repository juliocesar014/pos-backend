package com.kamikase.web.posbackend.repository;

import com.kamikase.web.posbackend.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Integer> {

    List<Clube> findByNomeOrderByNomeAsc(String nome);

    @Query("SELECT c FROM Clube c WHERE c.nome = :nome ORDER BY c.nome ASC")
    List<Clube> buscarPorNome(@Param("nome") String nome);
}
