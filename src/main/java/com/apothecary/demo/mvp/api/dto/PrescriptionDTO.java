package com.apothecary.demo.mvp.api.dto;

import com.apothecary.demo.mvp.entities.Drug;
import lombok.Data;

import java.util.List;

@Data
public class PrescriptionDTO {

    private String doctor;
    private String signature;
    private int stamp;
    private String patient;
    private int age;
    private String diagnosis;
    private int drugId;
    private int amount;

}
