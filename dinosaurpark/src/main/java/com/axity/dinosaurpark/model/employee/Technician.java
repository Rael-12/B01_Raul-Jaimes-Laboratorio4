package com.axity.dinosaurpark.model.employee;

import com.axity.dinosaurpark.config.ParkConfig;

import java.math.BigDecimal;

public class Technician extends Worker{
    protected Technician(String name, BigDecimal dailySalary) {
        super(name, dailySalary);
    }

    @Override
    public String getRole() {
        return "Technician";
    }
}
