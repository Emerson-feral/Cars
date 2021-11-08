package com.dealership.cars.controller;


import com.dealership.cars.entity.Car;
import com.dealership.cars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    
    @Autowired
    private CarService service;

    @PostMapping("/Car")
    public Car addCar(@RequestBody Car car){
        return service.saveCar(car);
    }

}
