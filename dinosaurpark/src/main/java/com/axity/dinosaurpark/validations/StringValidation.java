package com.axity.dinosaurpark.validations;

public class StringValidation {
    public static void validateString(String s){
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("The field is empty");
    }
}
