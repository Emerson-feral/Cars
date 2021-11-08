package com.dealership.cars.controller;


import com.dealership.cars.entity.Car;
import com.dealership.cars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/Car/{id}")
    public Car findCarById(@PathVariable Integer id){
        return service.getCarById(id);
    }

    @GetMapping("/Car/{model}")
    public Car findCarByModel(@PathVariable String model){
        return service.getCarByModel(model);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCar(@PathVariable Integer id){
        return service.deleteCar(id);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car){
        return service.disableCarAttribute(car);
    }

    


}
