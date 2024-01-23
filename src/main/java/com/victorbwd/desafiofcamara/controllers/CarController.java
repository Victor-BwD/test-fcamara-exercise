package com.victorbwd.desafiofcamara.controllers;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.services.CarService;
import com.victorbwd.desafiofcamara.services.VehicleControlService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;
    private VehicleControlService vehicleControlService;

    public CarController(CarService carService, VehicleControlService vehicleControlService) {
        this.carService = carService;
        this.vehicleControlService = vehicleControlService;
    }

    @PostMapping
    public ResponseEntity<Car> insert(@RequestBody CarDTO carData) {
        Car newCar = this.carService.insert(carData);
        this.vehicleControlService.enterVehicle(newCar);

        Date entryDate = new Date();

        newCar.setEntryDate( newCar.setEntryDate(entryDate));
        return ResponseEntity.ok().body(newCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = this.carService.getAll();
        return ResponseEntity.ok().body(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable("id") String id, @RequestBody CarDTO carData) {
        Car updatedCar = this.carService.update(id, carData);
        return ResponseEntity.ok().body(updatedCar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable("id") String id) {
        this.carService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
