package com.phddigital.riphe78.repository;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {


}
