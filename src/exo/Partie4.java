package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Partie4 {

    private static final Predicate<Trip> isPremiumTrip = trip -> trip.price() > 30 && trip.rating() > 4;

    public double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .mapToDouble(Trip::price)
                .sum();
    }

    public double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .mapToDouble(Trip::price)
                .sum();
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        Trip::city,
                        Collectors.counting()
                ));
    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        return trips.parallelStream()
                .filter(isPremiumTrip)
                .collect(Collectors.toList());
    }
}
