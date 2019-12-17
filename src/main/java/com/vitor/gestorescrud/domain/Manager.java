package com.vitor.gestorescrud.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
public class Manager implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registration;
    private String name;
    private String dateOfBirth;
    private String sector;

    public Manager(Integer id, String registration, String name, String dateOfBirth, String sector) {
        super();
        this.id = id;
        this.registration = registration;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sector = sector;
    }
}
