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
public class Prescription {
    @Id
    @GeneratedValue
    private int id;

    private String doctor;
    private String signature;
    private int stamp;
    private String patient;
    private int age;
    private String diagnosis;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
    private int amount;

    public Prescription(String doctor, String signature, int stamp, String patient, int age, String diagnosis,
                        Drug drug, int amount) {
        this.doctor = doctor;
        this.signature = signature;
        this.stamp = stamp;
        this.patient = patient;
        this.age = age;
        this.diagnosis = diagnosis;
        this.drug = drug;
        this.amount = amount;
    }

}
