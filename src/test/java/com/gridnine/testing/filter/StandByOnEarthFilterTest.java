package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StandByOnEarthFilterTest {

    List<Flight> flightList = FlightBuilder.createFlights();

    @Test
    public void doFilter() {
        FlightFilter filter = new StandByOnEarthFilter();
        Assert.assertEquals(flightList.size(), 6);
        List<Flight> result = filter.doFilter(flightList);
        Assert.assertEquals(result.size(), 4);
    }
}