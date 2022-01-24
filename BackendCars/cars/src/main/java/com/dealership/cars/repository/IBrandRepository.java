package com.dealership.cars.repository;

import com.dealership.cars.entity.Brand;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends CrudRepository<Brand,Integer>, QueryByExampleExecutor<Brand> {

    
}
