import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {
    
    List<Trip> smallTripsList = TripFactory.generateTrips(10);
    System.out.println("All generated trips");
    smallTripsList.forEach(System.out::println);

    System.out.println("\nPARTIE 1");
    Partie1 partie1 = new Partie1();
    System.out.println("\nLong and Expensive Trips");
    partie1.longAndExpensiveTrips(smallTripsList).forEach(System.out::println);
    System.out.println("\nBad Trips");
    partie1.badTrips(smallTripsList).forEach(System.out::println);
    System.out.println("\nRecent Trips");
    partie1.recentTrips(smallTripsList).forEach(System.out::println);

    System.out.println("\n\nPARTIE 2");
    Partie2 partie2 = new Partie2();
    System.out.println("\nCount by City");
    System.out.println(partie2.countByCity(smallTripsList));
    System.out.println("\nRevenue by Driver");
    System.out.println(partie2.revenueByDriver(smallTripsList));
    System.out.println("\nAverage Duration by City");
    System.out.println(partie2.avgDurationByCity(smallTripsList));

    System.out.println("\n\nPARTIE 3");
    Partie3 partie3 = new Partie3();
    System.out.println("\nTop 10 Expensive Trips (up to 10)");
    partie3.top10ExpensiveTrips(smallTripsList).forEach(System.out::println);
    System.out.println("\nBest Trip");
    partie3.bestTrip(smallTripsList).ifPresent(System.out::println);

    System.out.println("\n\nPARTIE 4");
    Partie4 partie4 = new Partie4();
    System.out.println("\nTotal Revenue (Sequential)");
    System.out.println(partie4.totalRevenueSequential(smallTripsList));
    System.out.println("\nTotal Revenue (Parallel)");
    System.out.println(partie4.totalRevenueParallel(smallTripsList));
    System.out.println("\nCount by City (Parallel)");
    System.out.println(partie4.countByCityParallel(smallTripsList));
    System.out.println("\nPremium Trips (Parallel)");
    partie4.premiumTripsParallel(smallTripsList).forEach(System.out::println);
}