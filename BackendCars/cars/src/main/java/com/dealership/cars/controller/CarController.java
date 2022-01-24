package com.dealership.cars.controller;


import com.dealership.cars.entity.Brand;
import com.dealership.cars.entity.Car;
import com.dealership.cars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    
    @Autowired
    private CarService service;

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car){
        return service.saveCar(car);
    }

    @GetMapping("/cars")
    public Iterable<Car> findAllCars(@RequestParam(required = false) String model,@RequestParam(required = false) Brand brand){
        return service.getCars(model,brand); 
    }
    
    @GetMapping("/cars/{id}")
    public Car findCarById(@PathVariable Integer id){
        return service.getCarById(id);
    }

    @DeleteMapping("cars/{id}")
    public String deleteCar(@PathVariable Integer id){
        return service.deleteCar(id);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@RequestBody Car car , @PathVariable Integer id){
        car.setId(id);
        return service.disableCarAttribute(car);

    }

}
