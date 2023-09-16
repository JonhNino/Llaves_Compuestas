package com.uptc.fwr.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="PERSONAS")
public class Person {
    @Id
    @Column(name="ID_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq",sequenceName = "PERSONAS_SEQ",allocationSize = 1)
    private Long id;
    @Column(name="NOMBRES")
    private String name;
    @Column(name="APELLIDOS")
    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<Bill> bills;
    @ManyToMany(mappedBy = "autors")
    private List<Book> books;
    public Person() {

    }

    public Person(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;

    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
