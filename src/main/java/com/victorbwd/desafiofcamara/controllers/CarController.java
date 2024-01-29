package com.victorbwd.desafiofcamara.controllers;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.services.CarService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> insert(@Valid @RequestBody CarDTO carData) {
        Car newCar = this.carService.insert(carData);
        URI uri = URI.create("/api/car/" + newCar.getId());
        return ResponseEntity.created(uri).body(newCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = this.carService.getAll();
        return ResponseEntity.ok().body(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable("id") String id, @RequestBody CarDTO carData)  {
        Car updatedCar = this.carService.update(id, carData);
        return ResponseEntity.ok().body(updatedCar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable("id") String id) {
        this.carService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
