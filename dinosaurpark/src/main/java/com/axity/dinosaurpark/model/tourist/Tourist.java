package com.axity.dinosaurpark.model.tourist;

import com.axity.dinosaurpark.validations.StringValidation;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Tourist {
    private final int id;
    private static int add;
    private final String name;
    @Setter
    private TouristStatus status;
    private BigDecimal moneySpent;
    private List<String> visitedZones;

    public Tourist(String name) {
        StringValidation.validateString(name);

        this.id = add++;
        this.name = name;
    }

    public void spend(BigDecimal price){
        this.moneySpent = this.moneySpent.add(price);
    }

    public void recordVisit(String zone){
        this.visitedZones.add(zone);
    }
}
