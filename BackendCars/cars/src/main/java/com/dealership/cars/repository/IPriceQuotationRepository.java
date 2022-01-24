package com.dealership.cars.repository;
import com.dealership.cars.entity.PriceQuotation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceQuotationRepository extends CrudRepository<PriceQuotation,Integer>{

    PriceQuotation save(PriceQuotation priceQuotation);
    
}
