package com.uptc.fwr.entity;

import jakarta.persistence.*;


@Entity
@Table(name="DETALLES_COMPRA")
public class BillDetail {
    @Id
    @Column(name="ID_DETALLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billDetail_seq")
    @SequenceGenerator(name="billDetail_seq",sequenceName = "DETALLES_COMPRA_SEQ",allocationSize = 1)
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name="ID_LIBRO"),
            @JoinColumn(name="ISBN")
    })
    private Book book;

    public BillDetail() {
    }

    public BillDetail(int quantity, Bill bill, Book book) {
        this.quantity = quantity;
        this.bill = bill;
        this.book = book;
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
