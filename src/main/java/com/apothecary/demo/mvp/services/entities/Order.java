package com.apothecary.demo.mvp.services.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private UUID id;
    private int clientId;
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private LocalDateTime startTime;
    private Drugs drugs;
    private int totalSum;


}

