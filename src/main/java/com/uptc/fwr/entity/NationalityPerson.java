package com.uptc.fwr.entity;

import com.uptc.fwr.entity.key.NationalityPersonPk;
import jakarta.persistence.*;

@Entity
@Table(name= "NACIONALIDADES_PERSONAS")
@IdClass(NationalityPersonPk.class)
public class NationalityPerson {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_NACIONALIDAD")
    private Nationality nationality;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_PERSONA")
    private Person person;
    private int anio;

    public NationalityPerson() {
    }

    public NationalityPerson(Nationality nationality, Person person, int anio) {
        this.nationality = nationality;
        this.person = person;
        this.anio = anio;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "NationalityPerson{" +
                "nationality=" + nationality +
                ", person=" + person +
                ", anio=" + anio +
                '}';
    }
}
