package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;

import java.util.List;

public class FilterStrategyContext {
    private FlightFilter filter;

    public void setFilter(FlightFilter filter) {
        this.filter = filter;
    }

    public List<Flight> doFilter(List<Flight> flights) {
        return filter.doFilter(flights);
    }
}
