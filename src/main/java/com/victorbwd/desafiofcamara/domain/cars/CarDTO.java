package com.victorbwd.desafiofcamara.domain.cars;

import java.util.Date;

public record CarDTO(String plate, String model, String color, String type, String brand, Date entryDate, Date exitDate) {
}
