package com.dealership.cars.controller;


import com.dealership.cars.entity.PriceQuotation;

import com.dealership.cars.service.PriceQuotationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceQuotationController {
    
    @Autowired
    private PriceQuotationService service;

    @GetMapping("/quotations")
    public Iterable<PriceQuotation> findAllQuotations(){
        return service.getQuotations(); 
    }


    @PostMapping("/closed_quotations")
    public PriceQuotation closeQuotation(@RequestBody PriceQuotation priceQuotation){
        return service.closeQuotation(priceQuotation);
    }


}
