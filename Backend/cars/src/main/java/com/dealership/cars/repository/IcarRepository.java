package com.dealership.cars.repository;

import com.dealership.cars.entity.Car;

import org.springframework.data.repository.CrudRepository;

public interface IcarRepository extends CrudRepository<Car,Integer> {
    
}
