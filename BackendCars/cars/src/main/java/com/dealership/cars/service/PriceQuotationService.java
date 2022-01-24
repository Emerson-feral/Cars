package com.dealership.cars.service;

import com.dealership.cars.entity.Car;
import com.dealership.cars.entity.PriceQuotation;
import com.dealership.cars.enums.PriceQuotationStatus;
import com.dealership.cars.repository.ICarRepository;
import com.dealership.cars.repository.IPriceQuotationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceQuotationService {

    @Autowired
    private IPriceQuotationRepository priceQuotationRepository;

    @Autowired
    private ICarRepository carRepository; 
    

    public PriceQuotation openQuotation(Car car){
        PriceQuotation priceQuotation = new PriceQuotation();
        priceQuotation.setCar(car);

        return priceQuotationRepository.save(priceQuotation);
    }

    public PriceQuotation closeQuotation(PriceQuotation priceQuotation){
        if(priceQuotation.getId() == null){
            throw new IllegalArgumentException("ID is required");
        }

        if(priceQuotation.getPrice() == null){
            throw new IllegalArgumentException("Price is required");
        }

        priceQuotation.setStatus(PriceQuotationStatus.CLOSED);

        PriceQuotation priceQuotationClosed = priceQuotationRepository.save(priceQuotation);

        carRepository.save(priceQuotation.getCar());

        return priceQuotationClosed;
    }
}
