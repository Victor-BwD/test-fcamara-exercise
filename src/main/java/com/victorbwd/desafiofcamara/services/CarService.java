package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.domain.cars.exceptions.CarNotFoundException;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car insert(CarDTO carData) {
          Car car = new Car(carData);
          Date entryDate = new Date();
          car.setEntryDate(entryDate);
          this.carRepository.save(car);
          return car;
    }

    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    public Car update(String id, CarDTO carData) {
        Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        if (carData.plate() != null && !carData.plate().isEmpty()) {
            car.setPlate(carData.plate());
        }
        if (carData.model() != null && !carData.model().isEmpty()) {
            car.setModel(carData.model());
        }
        if (carData.color() != null && !carData.color().isEmpty()) {
            car.setColor(carData.color());
        }
        if (carData.type() != null && !carData.type().isEmpty()) {
            car.setType(carData.type());
        }
        if (carData.brand() != null && !carData.brand().isEmpty()) {
            car.setBrand(carData.brand());
        }
        if (carData.active() != null) {
            car.setActive(carData.active());

            if(car.getActive().equals(Boolean.FALSE)) {
                Date exitDate = new Date();
                car.setExitDate(exitDate);
            }
        }

        this.carRepository.save(car);

        return car;
    }

    public void delete(String id) {
        Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        this.carRepository.delete(car);
    }
}
