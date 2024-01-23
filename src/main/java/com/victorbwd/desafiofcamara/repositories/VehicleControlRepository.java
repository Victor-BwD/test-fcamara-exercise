package com.victorbwd.desafiofcamara.repositories;

import com.victorbwd.desafiofcamara.domain.vehicleControl.VehicleControl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleControlRepository extends MongoRepository<VehicleControl, String> {

}
