package com.axity.dinosaurpark.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Ticket {
    private final long id;
    private static int add;
    private final int touristId;
    private final BigDecimal price;
    private final String category;
    private final LocalDateTime issuedAt;

    public Ticket(long id, int touristId, BigDecimal price,
                  String category) {

        this.id = add++;
        this.touristId = touristId;
        this.price = price;
        this.category = category;
        this.issuedAt = LocalDateTime.now();
    }

}
