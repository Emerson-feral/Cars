package com.dealership.cars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dealership.cars.enums.PriceQuotationStatus;


@Entity
@Table(name = "price_quotation")
public class PriceQuotation {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private Long price;

    @ManyToOne(optional = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    @Column
    private PriceQuotationStatus status;
    

    public PriceQuotation() {
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public PriceQuotationStatus getStatus() {
        return this.status;
    }

    public void setStatus(PriceQuotationStatus closed) {
        this.status = closed;
    }

}
