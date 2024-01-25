package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.domain.cars.exceptions.CarNotFoundException;
import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import com.victorbwd.desafiofcamara.domain.establishment.exceptions.EstablishmentNotFoundException;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import com.victorbwd.desafiofcamara.helper.PlateValidation;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    private EstablishmentService establishmentService;

    public CarService(CarRepository carRepository, EstablishmentService establishmentService) {
        this.carRepository = carRepository;
        this.establishmentService = establishmentService;
    }

    public Car insert(CarDTO carData) {
        Establishment establishment = this.establishmentService.getById(carData.establishmentId()).orElseThrow(EstablishmentNotFoundException::new);

        Car newCar = new Car(carData);

        PlateValidation plateValidation = new PlateValidation();

        if(!plateValidation.validateBrazilianPlate(newCar.getPlate())) {
            throw new IllegalArgumentException("Invalid plate");
        }

        Date entryDate = new Date();
        newCar.setEntryDate(entryDate);

        newCar.setEstablishment(establishment);

        this.carRepository.save(newCar);
        return newCar;
    }

    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    public Car update(String id, CarDTO carData) {
        Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        this.establishmentService.getById(carData.establishmentId()).ifPresent(car::setEstablishment);

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
