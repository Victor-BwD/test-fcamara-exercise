package com.victorbwd.desafiofcamara.controllers;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.services.CarService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> insert(@RequestBody CarDTO carData) {
        Car newCar = this.carService.insert(carData);
        return ResponseEntity.ok().body(newCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = this.carService.getAll();
        return ResponseEntity.ok().body(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathParam("id") String id, @RequestBody CarDTO carData) {
        Car updatedCar = this.carService.update(id, carData);
        return ResponseEntity.ok().body(updatedCar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathParam("id") String id) {
        this.carService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
