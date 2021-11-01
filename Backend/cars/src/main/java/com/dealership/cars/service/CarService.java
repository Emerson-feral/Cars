package com.dealership.cars.service;

import com.dealership.cars.entity.Car;
import com.dealership.cars.repository.IcarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private IcarRepository repository;

    private Double minCarPrice = 10.000;

    //Post
    public Car saveCar(Car car){
        if(car.getModel() == null && car.getVersion() == null && car.getYear() == null && car.getPrice() == null){
            throw new IllegalArgumentException("The car attributes are empty");
        }else{
            if(car.getPrice() < minCarPrice){
                throw new IllegalArgumentException("The car price must be more than 10.000");
            }else{
                return repository.save(car);
            }
        }
        
    }

    //Get
    public Iterable<Car> getCars(){
        return repository.findAll();
    }

    public Car getCarById(Integer id){
        return repository.findById(id).orElse(null);
    }

    //Delete
    public String deleteCar(Integer id){
        repository.deleteById(id);
        return "Car removed " + id ;
    }
     
}

