package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car insert(CarDTO carData) {
          Car car = new Car(carData);
          this.carRepository.save(car);
          return car;
    }
}
