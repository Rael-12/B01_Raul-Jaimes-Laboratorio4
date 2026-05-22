package com.axity.dinosaurpark.model.dinosaurs;

import com.axity.dinosaurpark.validations.StringValidation;
import lombok.Getter;

import java.math.BigDecimal;

import static com.axity.dinosaurpark.model.dinosaurs.DinosaurStatus.*;

@Getter
public abstract class Dinosaur {
    private final int id;
    private static int add;
    private final String name, species;
    private DinosaurStatus status;
    private final BigDecimal feedingCostPerDay;

    protected Dinosaur(String name, String species, BigDecimal feedingCostPerDay) {
        StringValidation.validateString(name);
        StringValidation.validateString(species);
        validateCost(feedingCostPerDay);

        this.id = add++;
        this.name = name;
        this.species = species;
        this.feedingCostPerDay = feedingCostPerDay;
    }

    public abstract String getDiet();        // "CARNIVORE" o "HERBIVORE"
    public abstract double getDangerLevel(); // 0.0 a 1.0

    // Métodos concretos — iguales para todos
    public void escape()           { status = ESCAPED;     }
    public void recapture()        { status = RECAPTURED;  }
    public void returnToEnclosure(){ status = IN_ENCLOSURE;}

    private static void validateCost(BigDecimal cost){
        if(cost == null)
            throw new IllegalArgumentException("The field is empty");

        if(cost.signum() <= 0)
            throw new IllegalArgumentException("The cost must be greater than zero");
    }
}
