package com.dealership.cars.controller;

import com.dealership.cars.entity.Brand;
import com.dealership.cars.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    private BrandService service;

    @PostMapping("/brands")
    public Brand saveBrand(@RequestBody Brand brand){
        return service.saveBrand(brand);
    }

    @GetMapping("/brands")
    public Iterable<Brand> allBrand(){
        return service.getBrands();
    }

    @DeleteMapping("/brands/{id}")
    public String deleteBrand(@PathVariable Integer id){
        return service.deleteBrand(id);
    }
    
}
