package com.phddigital.riphe78.service;

import com.phddigital.riphe78.model.Promocao;
import com.phddigital.riphe78.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PromocaoService implements com.phddigital.riphe78.service.Service {
    @Value(value = "${regra.promocao.percentmin}")
    private double percentMin;
    @Autowired
    private final PromocaoRepository repository;

    public PromocaoService(PromocaoRepository repository) {
        this.repository = repository;
    }

    public void save(Promocao entity) {
        // TODO Auto-generated method stub
        if (entity.getDescontoPercent() >= percentMin) {
            repository.save(entity);
        }
    }

    public Promocao delete(Integer id) {
       Optional<Promocao> optional= delete(repository, id);
       return optional.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Promocao update(Integer id, Promocao entity) {
        Optional<Promocao> update = update(repository, id, entity);
        return update.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Promocao> select() {
        Optional<List<Promocao>> select = select(repository);

        return select.orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }


}
