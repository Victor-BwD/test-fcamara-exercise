package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.domain.cars.exceptions.CarNotFoundException;
import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import com.victorbwd.desafiofcamara.domain.establishment.exceptions.EstablishmentNotFoundException;
import com.victorbwd.desafiofcamara.helper.CarValidator;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import com.victorbwd.desafiofcamara.helper.PlateValidation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.Date;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    private final EstablishmentService establishmentService;

    private final PlateValidation plateValidation;

    public CarService(CarRepository carRepository, EstablishmentService establishmentService, PlateValidation plateValidation) {
        this.carRepository = carRepository;
        this.establishmentService = establishmentService;
        this.plateValidation = plateValidation;
    }

    public Car insert(@Validated CarDTO carData) {
        Establishment establishment = this.establishmentService.getById(carData.establishmentId()).orElseThrow(EstablishmentNotFoundException::new);

        Car newCar = new Car(carData);

        CarValidator.validateNonNullFields(newCar);

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
        Car car = this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + id + "."));

        if (carData.establishmentId() != null) {
            this.establishmentService.getById(carData.establishmentId()).ifPresent(car::setEstablishment);
        }
        
        if (carData.plate() != null && !carData.plate().isEmpty()) {

            if(!plateValidation.validateBrazilianPlate(carData.plate())) {
                throw new IllegalArgumentException("Invalid plate");
            }

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
        Car car = this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + id + "."));

        this.carRepository.delete(car);
    }

    public void findById(String id) {
        this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + id + "."));
    }
}
