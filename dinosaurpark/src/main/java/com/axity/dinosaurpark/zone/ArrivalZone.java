package com.axity.dinosaurpark.zone;

import com.axity.dinosaurpark.model.tourist.Tourist;
import com.axity.dinosaurpark.validations.StringValidation;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
public class ArrivalZone implements ParkZone{
    private final String name;
    private final int maxCapacity;
    private final Queue<Tourist> waitingQueue;
    private final double ticketPrice;
    private int touristsInside;
    private DatabaseService db;

    public ArrivalZone(int maxCapacity, double ticketPrice) {
        this.name = "Arrival zone";
        this.maxCapacity = maxCapacity;
        this.ticketPrice = ticketPrice;
        this.waitingQueue = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean hasCapacity() {
        return touristsInside < maxCapacity;
    }

    @Override
    public int getCurrentOccupancy() {
        return this.touristsInside;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public void enter(Tourist tourist) {
        if(!hasCapacity())
            return;
        touristsInside++;
    }

    @Override
    public void exit(Tourist tourist) {
        if(touristsInside > 0)
            touristsInside--;
    }

    public void addTourist(Tourist tourist) {
        waitingQueue.offer(tourist);
    }
}
