package com.java.spring.controller;

import com.java.spring.entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarsController {
    List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(1, "Audi", "A6", 3.0, 2017));
        cars.add(new Car(2, "Ford", "Edge Sport", 2.7, 2016));
    }

    @GetMapping(value = "/car")
    public List<Car> getCars() {
        return cars;
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public Car addCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }


    @PutMapping(value = "car/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Car updateCar(@PathVariable int id, @RequestBody Car car) {
        Optional<Car> optionalCar = cars
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        Car carList = optionalCar.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found car"));
        int index = cars.indexOf(carList);
        car.setId(id);
        cars.set(index, car);
        return car;
    }

    @DeleteMapping(value = "car/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable int id) {
        final boolean carRemoved = cars.removeIf(car -> car.getId() == id);
        if (carRemoved) {
            System.out.println("Car removed");
        } else {
            System.out.println("Not found car with id : " + id);
        }
    }


}
