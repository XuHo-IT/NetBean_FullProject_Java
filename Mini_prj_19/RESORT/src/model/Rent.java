package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {
   protected LocalDateTime startTime;
   protected LocalDateTime endTime;

    public Rent(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Rent() {
    }

    public Duration calculateDuration() {
        return Duration.between(startTime, endTime);
    }

    public double calculateCostPerHour(double hourRate) {
        Duration duration = calculateDuration();
        long hours = duration.toHours();
        return hourRate * hours;
    }

    public double calculateCostPerDay(double dayRate) {
        Duration duration = calculateDuration();
        long days = duration.toDays();
        return dayRate * days;
    }

    public double calculateCostPerMonth(double monthRate) {
        Duration duration = calculateDuration();
        long months = duration.toDays() / 30; // Assuming 30 days per month
        return monthRate * months;
    }

    public double calculateCostPerYear(double yearRate) {
        Duration duration = calculateDuration();
        long years = duration.toDays() / 365; // Assuming 365 days per year
        return yearRate * years;
    }

}
