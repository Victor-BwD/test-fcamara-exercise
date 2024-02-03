package com.victorbwd.desafiofcamara.helper;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class CarValidator {
    public static void validateNonNullFields(Car car) {
        Field[] fields = car.getClass().getDeclaredFields();

        Stream<Field> requiredFields = Arrays.stream(fields)
                .filter(field -> field.getDeclaredAnnotation(NotNull.class) != null);

        boolean anyNull = requiredFields.anyMatch(field -> {
            field.setAccessible(true);
            try {
                return field.get(car) == null;
            } catch (IllegalAccessException error) {
                error.printStackTrace();
                return true;
            }
        });

        if (anyNull) {
            throw new IllegalArgumentException("One or more fields in the request body are null");
        }
    }
}
