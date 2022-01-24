package com.dealership.cars.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Car")
public class Car {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @NonNull
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_brand")
    private Brand brand;
    
    private String model;
    private String version;
    private Long price;
    private Boolean isEnabled;

    public Car(){

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public Brand getBrand() {
       return brand;
   }

   public void setBrand(Brand brand) {
       this.brand = brand;
   }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}
