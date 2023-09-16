package com.uptc.fwr.entity;

import com.uptc.fwr.entity.key.BookPk;
import jakarta.persistence.*;

@Entity
@Table(name="EDICIONES")
public class Edition {

    @EmbeddedId
    private BookPk bookPk;
    @Column(name="ISBN",insertable = false,updatable = false)
    private String isbn;
    @Column(name ="ANIO_PUBLICACION")
    private int year;
    @Column(name ="NUMERO")
    private int number;
    @Column(name ="DESCRIPCION")
    private String description;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name="ID_LIBRO"),
            @JoinColumn(name="ISBN")
    })
    @MapsId
    private Book book;

    public Edition() {
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "bookPk=" + bookPk +
                ", year=" + year +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
