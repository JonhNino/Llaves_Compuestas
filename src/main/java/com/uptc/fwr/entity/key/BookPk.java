package com.uptc.fwr.entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class BookPk implements Serializable {
    private Long id;
    private String isbn;

    public BookPk() {
    }

    public BookPk(Long id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookPk{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
