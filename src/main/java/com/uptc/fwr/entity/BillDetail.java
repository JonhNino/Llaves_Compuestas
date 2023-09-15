package com.uptc.fwr.entity;

import jakarta.persistence.*;


@Entity
@Table(name="DETALLES_COMPRA")
public class BillDetail {
    @Id
    @Column(name="ID_DETALLE")
    private Long id;
    @Column(name="ID_COMPRA",insertable = false, updatable = false)
    private Long billId;
    @Column(name="ID_LIBRO",insertable = false, updatable = false)
    private Long bookId;
    @Column(name="CANTIDAD")
    private int quantity;
    @ManyToOne
    @JoinColumn(name="ID_COMPRA")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name="ID_LIBRO")
    private Book book;

    public BillDetail() {
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", billId=" + billId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }
}
