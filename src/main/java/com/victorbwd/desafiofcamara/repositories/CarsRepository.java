package com.victorbwd.desafiofcamara.repositories;

import com.victorbwd.desafiofcamara.domain.cars.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Cars, String> {

}
