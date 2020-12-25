package com.phddigital.riphe78.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nome;
    private String urlLogo;
    private boolean premium;
    private Double nota;
    @ManyToOne
    private Categoria categoria;

    private String descricao;

}
