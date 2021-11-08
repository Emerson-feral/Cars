package com.dealership.cars.service;

import com.dealership.cars.entity.Car;
import com.dealership.cars.repository.IcarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private IcarRepository repository;

    private final Double MIN_CAR_PRICE = 10.000;

    //Post
    public Car saveCar(Car car){

        car.setIsEnabled(true);
         
        if(car.getModel() == null){
            throw new IllegalArgumentException("The car model is empty");
        }

        if(car.getVersion() == null){
            throw new IllegalArgumentException("The car version is empty");
        }

        if(car.getYear() == null){
            throw new IllegalArgumentException("The car year is empty");
        }

        if(car.getPrice() == null){
            throw new IllegalArgumentException("The car price is empty");
        }

        if(car.getPrice() < MIN_CAR_PRICE){
            throw new IllegalArgumentException("The car price have to be higher than " + MIN_CAR_PRICE);
        }
        
        return repository.save(car);
        
    }

    //Get
    public Iterable<Car> getCars(){
        return repository.findAll();
    }

    public Car getCarByModel(String model){
        return repository.findByModel(model);
    }

    public Car getCarById(Integer id){
        return repository.findById(id).orElse(null);
    }

    //Delete
    public String deleteCar(Integer id){
        repository.deleteById(id);
        return "Car removed " + id ;
    }

    //Update
    public Car disableCarAttribute(Car car){
        Car atualCar = repository.findById(car.getId()).orElse(null);
        atualCar.setIsEnabled(false);
        return repository.save(atualCar);
        
    }
     
}

