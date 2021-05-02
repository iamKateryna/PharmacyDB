package com.apothecary.demo.mvp.services.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drugs {
    @Id
    private UUID id;
    private String name;
    private Boolean status; //true - available, false - out of stock
    private float price;

    public Drugs(String name, float price){
        this.id = UUID.randomUUID();
        this.name = name;
        this.status = true;
        this.price = price;
    }
}

