package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private static final Function<Trip, String> tripToCity = Trip::city;
    private static final Function<Trip, String> tripToDriverId = Trip::driverId;
    private static final ToDoubleFunction<Trip> tripToPrice = Trip::price;
    private static final ToDoubleFunction<Trip> tripToDuration = Trip::durationMin;

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        tripToCity,
                        Collectors.counting()
                ));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        tripToDriverId,
                        Collectors.summingDouble(tripToPrice)
                ));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        tripToCity,
                        Collectors.averagingDouble(tripToDuration)
                ));
    }
}
