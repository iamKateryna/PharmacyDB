package com.apothecary.demo.mvp.api.dto;

import com.apothecary.demo.mvp.entities.Technology;
import com.apothecary.demo.mvp.entities.enums.DrugsTypes;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class DrugDTO {
    private String name;
    private DrugsTypes drugsTypes;
    private int technologyId;
    private float price;
    private String imgLink;
}
