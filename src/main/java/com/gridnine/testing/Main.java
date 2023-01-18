package com.gridnine.testing;

import com.gridnine.testing.filter.*;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterStrategyContext filterStrategyContext = new FilterStrategyContext();

        FlightFilter currentTimeFilter = new CurrentTimeFilter();
        filterStrategyContext.setFilter(currentTimeFilter);
        printResults(filterStrategyContext.doFilter(flights));

        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        filterStrategyContext.setFilter(arrivalBeforeDepartureFilter);
        printResults(filterStrategyContext.doFilter(flights));

        FlightFilter filter = new StandByOnEarthFilter();
        filterStrategyContext.setFilter(filter);
        printResults(filterStrategyContext.doFilter(flights));
    }

    private static void printResults(List<Flight> flightsList) {
        flightsList.forEach(System.out::println);
        System.out.println();
    }
}