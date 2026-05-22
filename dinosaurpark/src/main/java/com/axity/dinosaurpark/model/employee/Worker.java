package com.axity.dinosaurpark.model.employee;

import com.axity.dinosaurpark.validations.StringValidation;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class Worker {
    private final int id;
    private static int add;
    private final String name;
    private final BigDecimal dailySalary;

    protected Worker(String name, BigDecimal dailySalary) {
        StringValidation.validateString(name);
        validateSalary(dailySalary);

        this.id = add++;
        this.name = name;
        this.dailySalary = dailySalary;
    }

    private static void validateSalary(BigDecimal salary) {
        if(salary == null)
            throw new IllegalArgumentException("Salary cannot be null");

        if(salary.signum() <= 0)
            throw new IllegalArgumentException("The salary must not be less than or equal to zero");
    }

    public abstract String getRole();
}

