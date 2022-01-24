package com.dealership.cars.service;

import com.dealership.cars.entity.Brand;
import com.dealership.cars.entity.Car;
import com.dealership.cars.repository.ICarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private ICarRepository repository;
    @Autowired
    private BrandService brandService;

  

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

        if(car.getBrand() == null){
            throw new IllegalArgumentException("The car brand is empty");
        }

        Iterable<Brand> allBrands = brandService.getBrands();

        for (Brand brand : allBrands) {
            if(car.getBrand().getId() != brand.getId() ){
                throw new IllegalArgumentException("This car brand doesn't exist");
            } 
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
    public Iterable<Car> getCars(String model,Brand brand){
        Car filter = new Car();
        filter.setModel(model);
        filter.setBrand(brand);
        filter.setIsEnabled(true);
        Example <Car> example = Example.of(filter); 

        return repository.findAll(example);

        
       /*  if(model != null && brand != null){
            return repository.findByModelAndBrand(model,brand); 
        }
        
        if(model != null){
            return repository.findByModel(model);
        }

        if(brand != null){
            return repository.findByBrand(brand);
        }
        
        return repository.findAll(); */

    }

    public Car getCarById(Integer id){
        Car car = repository.findById(id).orElse(null);

        if( car != null){
            if(car.getIsEnabled()){
                return car;
            }
        }
        return null;
    }

    //Delete
    public String deleteCar(Integer id){
        repository.deleteById(id);
        return "Car removed " + id ;
    }

    //Update
    public Car disableCarAttribute(Car car){
        Car atualCar = repository.findById(car.getId()).orElse(null);
        if(atualCar != null){
            atualCar.setIsEnabled(false);
            return repository.save(atualCar);
        }
        return null;
        
    }
     
}

