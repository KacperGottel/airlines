package pl.kacperg.airlines.airlinesapi.flights;

import pl.kacperg.airlines.airlinesapi.*;

import java.util.Set;

public interface FlightService {

    Example getAllFlights();
    Datum getDatumByFlightNumber(String number);
    Set<Departure> getDeparturesList(Example allFlights);
    Set<Arrival> getArrivalsList(Example allFlights);

    Set<Airline> getAirlinesList(Example allFlights);
}
