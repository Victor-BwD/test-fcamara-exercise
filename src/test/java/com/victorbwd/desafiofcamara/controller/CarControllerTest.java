package com.victorbwd.desafiofcamara.controller;

import com.victorbwd.desafiofcamara.controllers.CarController;
import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.domain.cars.exceptions.CarNotFoundException;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import com.victorbwd.desafiofcamara.services.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CarControllerTest {
    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private CarDTO carDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carDTO = new CarDTO("JMO9582", "Fiat", "Verde", "Branco", "Carro", true, new Date(), null, "65b2e1f7e57bd4408d1159dd");
    }

    @Test
    void testInsert() {
        Car newCar = new Car(carDTO);

        when(carService.insert(carDTO)).thenReturn(newCar);

        ResponseEntity<Car> responseEntity = carController.insert(carDTO);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(newCar, responseEntity.getBody());
    }

    @Test
    void testGetAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(carDTO));
        cars.add(new Car(carDTO));

        when(carService.getAll()).thenReturn(cars);

        ResponseEntity<List<Car>> responseEntity = carController.getAll();

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(cars, responseEntity.getBody());
    }

    @Test
    void testUpdate() {
        Car updatedCar = new Car(carDTO);

        when(carService.update("65b2e1f7e57bd4408d1159dd", carDTO)).thenReturn(updatedCar);

        ResponseEntity<Car> responseEntity = carController.update("65b2e1f7e57bd4408d1159dd", carDTO);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(updatedCar, responseEntity.getBody());
    }

    @Test
    void testDelete() {
        ResponseEntity<Car> responseEntity = carController.delete("65b2e1f7e57bd4408d1159dd");

        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
