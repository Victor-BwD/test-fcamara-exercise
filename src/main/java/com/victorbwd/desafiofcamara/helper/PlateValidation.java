package com.victorbwd.desafiofcamara.helper;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PlateValidation {
    public boolean validateBrazilianPlate(String plate) {
        String regex = "^[A-Z]{3}\\d{4}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(plate);

        return matcher.matches();
    }
}
