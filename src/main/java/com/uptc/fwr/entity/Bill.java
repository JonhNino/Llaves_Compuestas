package com.uptc.fwr.entity;

import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.GeneratedValueResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="COMPRAS")
public class Bill {

    @Id
    @Column(name = "ID_COMPRA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_seq")
    @SequenceGenerator(name="bill_seq",sequenceName = "COMPRAS_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "ID_PERSONA", insertable = false, updatable = false)
    private Long personId;
    @Column(name = "FECHA")
    private Date fecha;
    @JoinColumn(name ="ID_PERSONA")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person person;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.PERSIST)
    private List<BillDetail> billDetails;

    public Bill() {
    }

    public Bill(Long personId, Date fecha) {
        this.personId = personId;
        this.fecha = fecha;
    }

    public Bill(Date fecha, Person person) {
        this.fecha = fecha;
        this.person = person;
    }

    public Bill(Date fecha) {
        this.fecha = fecha;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", personId=" + personId +
                ", fecha=" + fecha +
                '}';
    }
}
