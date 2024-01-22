package com.victorbwd.desafiofcamara.domain.cars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Car(CarDTO carDTO) {
        this.plate = carDTO.plate();
        this.model = carDTO.model();
        this.color = carDTO.color();
        this.type = carDTO.type();
        this.brand = carDTO.brand();
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
}
