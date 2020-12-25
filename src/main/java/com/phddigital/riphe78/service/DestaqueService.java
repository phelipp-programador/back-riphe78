package com.phddigital.riphe78.service;

import com.phddigital.riphe78.model.Item;
import com.phddigital.riphe78.model.Model;
import com.phddigital.riphe78.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class DestaqueService implements com.phddigital.riphe78.service.Service {
    @Autowired
    private ItemRepository repository;

    @Value(value = "${regra.destaque.nota}")
    private double valorMin;
    @Value(value = "${regra.destaque.limite}")
    private int limit;

    @Override
    public void save(Model entity) {
        // TODO Auto-generated method stub

    }

    /**
     * Se a loja tiver uma nota maior que X ela sera apresentada. apresentara um
     * tamanho maximo de Y
     * 
     *@return Optional<List<Item>>
     */
    public Optional<List<Item>> selectDestaque() {

        List<Item> select = select(repository);
        List<Item> aux = select.stream().filter((Item item) -> item.getLoja().getNota() >= valorMin)
                .sorted(Comparator.comparing(i -> i.getLoja().getNota())).limit(limit)
                .collect(Collectors.toList());

        if (select.size() > 0) {
            return Optional.of(aux);

        }

        return Optional.empty();
    }

}
