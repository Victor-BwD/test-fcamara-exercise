package com.victorbwd.desafiofcamara.domain.vehicleControl;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "vehicleControl")
@Getter
@Setter
@NoArgsConstructor
public class VehicleControl {
    @Id
    private String id;

    private Car car;
    private Date entryDate;
    private Date exitDate;

    public VehicleControl(Car car) {
        this.car = car;
        this.entryDate = new Date();
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }
}
