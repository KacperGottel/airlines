package pl.kacperg.airlines.airlinesapi;

public interface FlightService {

    Example getAllFlights();
    Datum getDatumByFlightNumber(String number);
}
