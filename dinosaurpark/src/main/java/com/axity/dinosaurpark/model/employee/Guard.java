package com.axity.dinosaurpark.model.employee;

import com.axity.dinosaurpark.model.dinosaurs.Dinosaur;
import com.axity.dinosaurpark.model.dinosaurs.DinosaurStatus;

import java.math.BigDecimal;
import java.util.List;

public class Guard extends Worker{

    protected Guard(String name, BigDecimal dailySalary) {
        super(name, dailySalary);
    }

    public void recaptureEscapedDinosaurs(List<Dinosaur> dinosaurs) {
        for (Dinosaur dinosaur : dinosaurs) {
            if(dinosaur.getStatus().equals(DinosaurStatus.ESCAPED))
                dinosaur.returnToEnclosure();
        }
    }

    @Override
    public String getRole() {
        return "Guard";
    }
}
