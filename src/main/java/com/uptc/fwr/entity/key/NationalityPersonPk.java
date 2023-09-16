package com.uptc.fwr.entity.key;

import com.uptc.fwr.entity.Nationality;
import com.uptc.fwr.entity.Person;

import java.io.Serializable;

public class NationalityPersonPk implements Serializable {

    private Nationality nationality;

    private Person person;

    public NationalityPersonPk() {
    }

    public NationalityPersonPk(Nationality nationality, Person person) {
        this.nationality = nationality;
        this.person = person;
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


}
