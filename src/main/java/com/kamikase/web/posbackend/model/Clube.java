package com.kamikase.web.posbackend.model;


import com.kamikase.web.posbackend.validator.EmailValidation;
import com.kamikase.web.posbackend.validator.NomeValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;


import java.io.Serializable;


@Getter
@Setter
@Entity
public class Clube implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    @NotEmpty(message = "O nome não pode ser nulo nem em branco")
    @NomeValidation
    private String nome;
    @NotEmpty(message = "O estado não pode ser nulo nem em branco")
    private String estado;
    @Email
    @EmailValidation
    private String email;
    @CNPJ
    private String cnpj;
//    @NotEmpty(message = "A data de criação não pode ser nulo nem em branco")
    private Integer dataCriacao;

}
