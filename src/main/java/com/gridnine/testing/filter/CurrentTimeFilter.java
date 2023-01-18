package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import com.gridnine.testing.log.FilterLog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrentTimeFilter implements FlightFilter {

    @Override
    public List<Flight> doFilter(List<Flight> flightList) {
        List<Flight> loggedFlights = new ArrayList<>();
        List<Flight> resultFlights = new ArrayList<>();

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    loggedFlights.add(flight);
                } else {
                    resultFlights.add(flight);
                    break;
                }
            }
        }

        FilterLog.logResults("Перелеты с вылетом до текущего момента времени",
                loggedFlights);
        return resultFlights;
    }
}

