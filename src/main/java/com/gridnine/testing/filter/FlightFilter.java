package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> doFilter(List<Flight> flightList);

}
