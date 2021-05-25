package com.apothecary.demo.mvp.api.dto;

import com.apothecary.demo.mvp.entities.Drug;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private String patient;
    private String phoneNumber;
    private String adress;
    private List<Integer> drugId;
    private boolean available;
    private int amount;
    private String createOrderDate;
}
