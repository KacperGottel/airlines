package pl.kacperg.airlines.airlinesapi.flights;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kacperg.airlines.airlinesapi.*;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AviationstackService implements FlightService {

    private static final String API_KEY = "0e5124cc765a71ffcadc3d24f926b638";
    private static final String URL = "http://api.aviationstack.com/v1/flights?access_key=" + API_KEY;

    @Override
    public Example getAllFlights() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Example> forEntity = restTemplate.getForEntity(URL, Example.class);
        return forEntity.getBody();
    }

    @Override
    public Datum getDatumByFlightNumber(String number) {
        Example allFlights = getAllFlights();
        Datum datum = null;
        for (Datum d : allFlights.getData()) {
            if (d.getFlight().getNumber().equals(number)) {
                datum = d;
                break;
            }

        }
        return datum;
    }

    @Override
    public Set<Departure> getDeparturesList(Example allFlights) {
        return allFlights.getData().stream().map(Datum::getDeparture).collect(Collectors.toSet());
    }

    @Override
    public Set<Arrival> getArrivalsList(Example allFlights) {
        return allFlights.getData().stream().map(Datum::getArrival).collect(Collectors.toSet());
    }

    @Override
    public Set<Airline> getAirlinesList(Example allFlights) {
        return allFlights.getData().stream().map(Datum::getAirline).collect(Collectors.toSet());
    }
}
