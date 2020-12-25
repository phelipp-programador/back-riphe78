package com.phddigital.riphe78.service;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Model;
import com.phddigital.riphe78.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements com.phddigital.riphe78.service.Service {
    @Autowired
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void save(Model entity) {
        // TODO Auto-generated method stub
        com.phddigital.riphe78.service.Service.super.save(repository, entity);
    }

    public Optional<List<Item>> localiza(String value) {
        return toOptional(repository.findByNomeContains(value));
    }
    public Optional<List<Item>> selectByCategoria(Integer id) {

        return toOptional(repository.selectByCategoria(id));
    }
    private Optional<List<Item>> toOptional(List<Item> items){
        System.out.println("Quantidade de item " + items.size());
        if(items.size()>0){
            return Optional.of(items);
        }
        return  Optional.empty();
    }

}
