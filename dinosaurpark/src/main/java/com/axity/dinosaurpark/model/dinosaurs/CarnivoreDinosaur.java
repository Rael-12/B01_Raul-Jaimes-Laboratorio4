package com.axity.dinosaurpark.model.dinosaurs;

import java.math.BigDecimal;

public class CarnivoreDinosaur extends Dinosaur{
    public CarnivoreDinosaur(String name, String species){
        super(name, species, BigDecimal.valueOf(500.0));
    }

    @Override
    public String getDiet() {
        return "CARNIVORE";
    }

    @Override
    public double getDangerLevel() {
        return 0.9;
    }
}
