package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import com.gridnine.testing.log.FilterLog;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StandByOnEarthFilter implements FlightFilter {
    private static final int HOURS = 2;

    @Override
    public List<Flight> doFilter(List<Flight> flightList) {
        List<Flight> resultFlight = new ArrayList<>();
        List<Flight> loggedFlights = new ArrayList<>();

        for (Flight flight : flightList) {
            List<Segment> segments = flight.getSegments();
            long hoursOnEarth = 0;

            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    long duration = Duration.between(segments.get(i).getArrivalDate(),
                            segments.get(i + 1).getDepartureDate()).toHours();
                    hoursOnEarth += duration;
                }

                if (hoursOnEarth < HOURS) {
                    resultFlight.add(flight);
                } else {
                    loggedFlights.add(flight);
                }

            } else {
                resultFlight.add(flight);
            }
        }

        FilterLog.logResults(String.format("Общее время, проведённое на земле превышает %s часа", HOURS),
                loggedFlights);
        return resultFlight;

    }
}