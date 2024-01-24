package com.victorbwd.desafiofcamara.domain.cars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    private String id;
    private String plate;
    private String model;
    private String color;
    private String type;
    private String brand;
    private Boolean active;
    private Date entryDate;
    private Date exitDate;

    public Car(CarDTO carDTO) {
        this.plate = carDTO.plate();
        this.model = carDTO.model();
        this.color = carDTO.color();
        this.type = carDTO.type();
        this.brand = carDTO.brand();
        this.active = carDTO.active();
        this.entryDate = carDTO.entryDate();
        this.exitDate = carDTO.exitDate();
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }
}
