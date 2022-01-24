package com.dealership.cars.repository;

import com.dealership.cars.entity.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends CrudRepository<Car,Integer>, QueryByExampleExecutor<Car> {
    Iterable<Car> findByModel(String model);
    Iterable<Car> findByModelAndBrand(String model, String brand);
}
