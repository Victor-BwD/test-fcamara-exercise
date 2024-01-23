package com.victorbwd.desafiofcamara.repositories;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

}
