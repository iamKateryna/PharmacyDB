package com.apothecary.demo.mvp.services.entities;

import com.apothecary.demo.mvp.services.entities.enums.DrugsTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadyMadeDrugs extends Drugs{
    private DrugsTypes drugsTypes;
}
