package com.phddigital.riphe78.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private double valor;
    private String urlImage;
    @ManyToOne
    private Loja loja;
    @ManyToOne
    private Categoria categoria;
}
