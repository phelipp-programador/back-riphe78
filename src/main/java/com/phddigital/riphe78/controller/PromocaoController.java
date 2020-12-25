package com.phddigital.riphe78.controller;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Promocao;
import com.phddigital.riphe78.service.ItemService;
import com.phddigital.riphe78.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promocao")

public class PromocaoController {

    private final PromocaoService service;

    @Autowired
    public PromocaoController(PromocaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Promocao> select() {
        return service.select();
    }

    @PostMapping
    public void save(@RequestBody Promocao promocao) {
        service.save(promocao);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
