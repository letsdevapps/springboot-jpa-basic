package com.pro.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private LocalDate birthDate;
    
    public User() {}
    public User(Long id, String name, String email, LocalDate birthDate) {
    	this.id = id;
    	this.name = name;
    	this.email = email;
    	this.birthDate = birthDate;
    }
}