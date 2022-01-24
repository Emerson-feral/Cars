package com.dealership.cars.controller;

import com.dealership.cars.entity.Car;
import com.dealership.cars.entity.PriceQuotation;
import com.dealership.cars.enums.PriceQuotationStatus;
import com.dealership.cars.service.PriceQuotationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceQuotationController {
    
    @Autowired
    private PriceQuotationService service;

    @PostMapping("/quotations")
    public PriceQuotation openQuotation(@RequestBody ){
       
    }


}
