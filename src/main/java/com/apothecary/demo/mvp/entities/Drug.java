package com.apothecary.demo.mvp.entities;

import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import com.apothecary.demo.mvp.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug{
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private DrugsTypes drugsTypes;
    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;
    private float price;
    private String imgLink;


    public Drug(String name, DrugsTypes drugsTypes, Technology technology,float price, String imgLink){
        this.name = name;
        this.drugsTypes = drugsTypes;
        this.technology = technology;
        this.price = price;
        this.imgLink = imgLink;
    }
}

