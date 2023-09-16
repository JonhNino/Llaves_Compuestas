package com.uptc.fwr.entity;

import jakarta.persistence.*;

@Entity
@Table(name="NACIONALIDADES")
public class Nationality {

    @Id
    @Column(name="ID_NACIONALIDAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="nationality_seq")
    @SequenceGenerator(name="nationality_seq",sequenceName = "NACIONALIDADES_SEQ",allocationSize = 1)
    private Long id;

    @Column(name="NOMBRE_NACIONALIDAD")
    private String name;

    public Nationality() {
    }

    public Nationality(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nationality(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
