package com.apothecary.demo.mvp.entities;

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
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue
    private int id;
    private String componentName;
    @OneToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
    private int amount;
    private int criticalAmount;
    private float price;

    public Storage(Drug drug, String componentName, int amount, int criticalAmount, float price){
        this.componentName = componentName;
        this.drug = drug;
        this.amount = amount;
        this.criticalAmount = criticalAmount;
        this.price = price;

    }

}
