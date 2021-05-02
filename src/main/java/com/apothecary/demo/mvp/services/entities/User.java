package com.apothecary.demo.mvp.services.entities;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private UUID id;
    private String name;
    private String phone;
    private String adress;
    private String login;
    private String password;

    public User(String name, String phone, String adress, String login, String password){
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.login = login;
        this.password = password;
    }
}
