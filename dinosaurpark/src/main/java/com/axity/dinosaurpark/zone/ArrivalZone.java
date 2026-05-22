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
        return 0;
    }

    @Override
    public int getMaxCapacity() {
        return 0;
    }

    @Override
    public void enter(Tourist tourist) {
        //if()
        
    }

    @Override
    public void exit(Tourist tourist) {

    }

    public void addTourist(Tourist tourist) {
        waitingQueue.offer(tourist);
    }
}
