package exo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.Trip;

public class Partie1 {

    private final Predicate<Trip> isLongTrip = trip -> trip.distanceKm() > 10;

    private final Predicate<Trip> isExpensiveTrip = trip -> trip.price() > 20;

    private final Predicate<Trip> isBadTrip = trip -> trip.rating() < 3;

    private final Predicate<Trip> isRecentTrip = trip -> {
        LocalDate tripDate = trip.startTime().toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        return tripDate.equals(today) || tripDate.equals(yesterday);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isLongTrip.and(isExpensiveTrip))
                .collect(Collectors.toList());
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isBadTrip)
                .collect(Collectors.toList());
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isRecentTrip)
                .collect(Collectors.toList());
    }
}