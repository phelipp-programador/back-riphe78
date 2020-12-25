package com.phddigital.riphe78.service;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Model;
import com.phddigital.riphe78.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements com.phddigital.riphe78.service.Service {
    @Autowired
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void save(Item entity) {
        // TODO Auto-generated method stub
        repository.save(entity);
    }

    public List<Item> localiza(String value) {
        return toOptional(repository.findByNomeContains(value))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Item> selectByCategoria(Integer id) {

        return toOptional(repository.findByCategoria(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    private Optional<List<Item>> toOptional(List<Item> items) {
        return (items.size() > 0) ? Optional.of(items) : Optional.empty();

    }

    public Item update(Integer id, Item item) {
        return repository.findById(id).map((i) -> {
            item.setId(id);
            repository.save(item);
            return item;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void delete(Integer id) {
        repository.findById(id).map(item -> {
            repository.delete(item);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
