package com.apothecary.demo.mvp.entities;

import com.apothecary.demo.mvp.entities.enums.TechnologyTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {
    @Id
    @GeneratedValue
    private int id;
    private String components;
    private TechnologyTypes technologyTypes;
    private float preparationTime;


    public Technology(String components, TechnologyTypes technologyTypes, float preparationTime){
        this.components = components;
        this.technologyTypes = technologyTypes;
        this.preparationTime = preparationTime;
    }
}
