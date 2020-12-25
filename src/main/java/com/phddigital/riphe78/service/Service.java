package com.phddigital.riphe78.service;

import java.util.List;

import com.phddigital.riphe78.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface Service {

    void save(Model entity);

    default void save(JpaRepository repository, Model entity) {
        repository.save(entity);
    }

    default List select(JpaRepository repository) {
        return repository.findAll();
    }

    default Model select(JpaRepository repository, Integer id) throws Throwable {
        return (Model) repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

}
