package com.uptc.fwr.entity;

import com.uptc.fwr.entity.key.BookPk;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LIBROS")
@IdClass(BookPk.class)
public class Book {

    @Id
    @Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "LIBROS_SEQ", allocationSize = 1)
    private Long id;
    @Id
    private String isbn;
    @Column(name = "TITULO")
    private String title;
    @Column(name = "PRECIO")
    private Double price;
    @OneToOne(mappedBy = "book")
    private Edition edition;

    @ManyToMany
    @JoinTable(name = "AUTOR_LIBRO",
            joinColumns = {
                    @JoinColumn(name = "ID_LIBRO"),
                    @JoinColumn(name = "ISBN")},
            inverseJoinColumns = @JoinColumn(name = "ID_AUTOR"))
    private List<Person> autors;

    @OneToMany(mappedBy = "book")
    private List<BillDetail> billDetails;


    public Book() {

    }

    public Book(String title, Double price) {

        this.title = title;
        this.price = price;
    }

    public Book(String isbn, String title, Double price) {

        this.isbn= isbn;
        this.title = title;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle(String s) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public List<Person> getAutors() {
        return autors;
    }

    public void setAutors(List<Person> autors) {
        this.autors = autors;
    }

    public String getTitle() {
        return title;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
