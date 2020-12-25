package com.phddigital.riphe78.repository;

import java.util.List;

import com.phddigital.riphe78.model.Categoria;
import com.phddigital.riphe78.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    //List<Item> findByNomeContains(String nome);
    @Query(nativeQuery = true,value = "Select * From ITEM  WHERE LOWER(NOME) LIKE Lower(concat(:nome,'%')) ")
    List<Item> findByNomeContains(@Param("nome") String nome);
    @Query(nativeQuery = true,value = "Select * From ITEM  WHERE CATEGORIA_ID=:id")
     List<Item> findByCategoria(@Param("id") Integer id);

}
