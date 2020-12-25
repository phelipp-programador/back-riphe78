package com.phddigital.riphe78.service;

import com.phddigital.riphe78.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DestaqueServiceTest {
    @Autowired
    DestaqueService service;

    @Test
    public void destaque() {

        Optional<List<Item>> selectDestaque = service.selectDestaque();
        if (selectDestaque.isPresent()) {
            selectDestaque.get().forEach(i -> System.out.println(i.getLoja().getNome()));
        }

    }
}
