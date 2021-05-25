package com.apothecary.demo.mvp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    private String patient;
    private String phoneNumber;
    private String adress;
    @ManyToMany
    @JoinColumn(name = "drug_id")
    private List<Drug> drug;
    private boolean released;
    private boolean available;
    private boolean processed;
    private int amount;
    private String createOrderDate;

    public Order(String patient, String phoneNumber, String adress, List<Drug> drug,
                  boolean available,
                 int amount, String createOrderDate) {
        this.patient = patient;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.drug = drug;
        this.released = false;
        this.available = available;
        this.processed = true; //u virobnitstvi
        this.amount = amount;
        this.createOrderDate = createOrderDate;
    }

}

