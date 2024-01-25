package com.victorbwd.desafiofcamara.report;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.report.ReportDTO;
import com.victorbwd.desafiofcamara.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private CarRepository carRepository;

    public ReportService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ReportDTO getEntryTotal() {

        List<Car> cars = this.carRepository.findAll();

        int total = 0;

        for (Car car : cars) {
            if(car.getExitDate() == null) {
                total++;
            }
        }

        return new ReportDTO(total);
    }
}
