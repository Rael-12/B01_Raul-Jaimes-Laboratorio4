package com.axity.dinosaurpark.model.dinosaurs;

import java.math.BigDecimal;

public class HerbivoreDinosaur extends Dinosaur{
    public HerbivoreDinosaur(String name, String species) {
        super(name, species, BigDecimal.valueOf(200.00));
    }

    @Override
    public String getDiet() {
        return "HERBIVORE";
    }

    @Override
    public double getDangerLevel() {
        return 0.2;
    }
}
