package com.dealership.cars.service;

import com.dealership.cars.entity.Brand;
import com.dealership.cars.entity.Car;
import com.dealership.cars.repository.IBrandRepository;
import com.dealership.cars.repository.ICarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    
    @Autowired
    private IBrandRepository repository;
    @Autowired
    private ICarRepository carRepository;


    public Brand saveBrand(Brand brand){
        if(brand != null){
            return repository.save(brand);
        }
        return null;
    }

    public Iterable<Brand> getBrands(){
        return repository.findAll();
    }

    public String deleteBrand(Integer id) {

        Iterable<Car> allcars = carRepository.findAll();
       
        for (Car car : allcars) {
            if(car.getBrand().getId() == id){
                throw new IllegalArgumentException("It is not possible to remove the brand, there is a car using this brand ");
            }
        }
        
        repository.deleteById(id);
        
        return "Brand removed " + id;
        
    }
}
