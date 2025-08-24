package it.unisa.railways;

import java.util.List;

public class ExpressTrain /* TODO */ {
    private final int numberOfRestaurantSeats;

    public ExpressTrain(TrainStop departureStation, TrainStop arrivalStation, List<TrainStop> intermediateStops, int numberOfSeats, int numberOfRestaurantSeats, double traveledKMs) {
        /* TODO */
    }

    public int getNumberOfRestaurantSeats() {
        return numberOfRestaurantSeats;
    }

    public double computeMaxRevenues(double serviceRevenuePerKmPerson, double restaurantRevenuePerKmPerson) {
        double restaurantRevenue = this.getTraveledKMs() * this.getNumberOfRestaurantSeats() * restaurantRevenuePerKmPerson;
        return /* TODO */;
    }

}
