package com.victorbwd.desafiofcamara.domain.cars;

import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public record CarDTO(@NotNull String plate, @NotNull String model, @NotNull String color, @NotNull String type, @NotNull String brand, Boolean active, Date entryDate, Date exitDate, String establishmentId) {
}
