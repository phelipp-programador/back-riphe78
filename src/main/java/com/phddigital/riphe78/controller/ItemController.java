package com.phddigital.riphe78.controller;

import java.util.List;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/item")

public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/search")

    public List<Item> findByName(@RequestParam("name") String name) {

        return service.localiza(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/search/{id}")
    public List<Item> selectOrderCategory(@PathVariable Integer id) {
        return service.selectByCategoria(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
