package com.phddigital.riphe78.model;

import lombok.Data;
import org.dom4j.rule.Mode;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Promocao implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Item item;
    private Double descontoPercent;
    private LocalDate limiteData;
}
