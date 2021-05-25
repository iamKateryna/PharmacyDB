package com.apothecary.demo.mvp.api.dto;

import com.apothecary.demo.mvp.entities.Drug;
import lombok.Data;

@Data
public class StorageDTO {
    private String componentName;
    private int drugId;
    private int amount;
    private int criticalAmount;
    private float price;
}
