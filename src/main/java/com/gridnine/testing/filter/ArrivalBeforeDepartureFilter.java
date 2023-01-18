package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import com.gridnine.testing.log.FilterLog;

import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDepartureFilter implements FlightFilter {

    @Override
    public List<Flight> doFilter(List<Flight> flightList) {

        List<Flight> loggedFlights = new ArrayList<>();
        List<Flight> resultFlights = new ArrayList<>();

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                    loggedFlights.add(flight);
                } else {
                    resultFlights.add(flight);
                    break;
                }
            }
        }
        FilterLog.logResults("Перелеты, где имеются сегменты с датой прилёта раньше даты вылета",
                loggedFlights);
        return resultFlights;
    }
}

