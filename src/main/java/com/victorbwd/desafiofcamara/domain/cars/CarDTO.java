package com.victorbwd.desafiofcamara.domain.cars;

import com.victorbwd.desafiofcamara.domain.establishment.Establishment;

import java.util.Date;

public record CarDTO(String plate, String model, String color, String type, String brand, Boolean active, Date entryDate, Date exitDate, String establishmentId) {
}
