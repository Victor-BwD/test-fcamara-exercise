package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import com.victorbwd.desafiofcamara.domain.vehicleControl.VehicleControl;
import com.victorbwd.desafiofcamara.repositories.VehicleControlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleControlService {
    private VehicleControlRepository vehicleControlRepository;

    public VehicleControlService(VehicleControlRepository vehicleControlRepository) {
        this.vehicleControlRepository = vehicleControlRepository;
    }

    public VehicleControl enterVehicle(Car car) {
        VehicleControl vehicleControl = new VehicleControl(car);
        return vehicleControlRepository.save(vehicleControl);
    }

    public List<VehicleControl> getAll() {
        return this.vehicleControlRepository.findAll();
    }

    public void delete(String id) {
        VehicleControl vehicleControl = this.vehicleControlRepository.findById(id).orElseThrow();
        this.vehicleControlRepository.delete(vehicleControl);
    }
}
