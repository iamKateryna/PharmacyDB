package com.apothecary.demo.mvp.api.dto;

import com.apothecary.demo.mvp.entities.enums.TechnologyTypes;
import lombok.Data;

import java.util.List;

@Data
public class TechnologyDTO {
    private String components;
    private TechnologyTypes technologyTypes;
    private float preparationTime;
}
