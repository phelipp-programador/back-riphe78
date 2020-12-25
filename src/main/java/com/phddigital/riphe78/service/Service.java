package com.phddigital.riphe78.service;

import java.util.List;
import java.util.Optional;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Model;

import com.phddigital.riphe78.model.Promocao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface Service {

    default Optional update(JpaRepository repository, Integer id, Model entity) {
        return repository.findById(id).map((e) -> {
            entity.setId(id);
            repository.save(entity);
            return Optional.of(e);
        });


    }

    default Optional select(JpaRepository repository) {
        List aux = repository.findAll();
        return (aux.size() > 0) ? Optional.of(aux) : Optional.empty();
    }

    default Optional delete(JpaRepository repository, Integer id) {
        return repository.findById(id).map(entity -> {
            repository.delete(entity);
            return Optional.of(entity);
        });

    }
}



