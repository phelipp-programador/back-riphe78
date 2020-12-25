package com.phddigital.riphe78.controller;

import java.util.List;
import java.util.Optional;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.service.DestaqueService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/destaques")
public class DestaqueController {
    private final DestaqueService service;

    public DestaqueController(DestaqueService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> select() {

        return service.selectDestaque().orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

}
