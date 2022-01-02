package pl.kacperg.airlines.airlinesapi.flights;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kacperg.airlines.airlinesapi.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AviationstackService implements FlightService {

    private static final String API_KEY = "9ce497b5d511a32ab850f557ed05d196";
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

    @Override
    public Set<String> getFlightNumbers(Example allFlights) {
        return allFlights.getData().stream().map(Datum::getFlight).map(Flight::getNumber).collect(Collectors.toSet());
    }

    @Override
    public List<Datum> searchFlight(String departureIcao, String arrivalIcao, String date, String number, String airline) {

        String numberParam = "&flight_number=" + number;
        String airlineParam = "&airline_name=" + airline;
        String dateParam = "";    //Request with this param is additionally paid.
        String departureParam = "&dep_icao=" + departureIcao;
        String arrivalParam = "&arr_icao=" + arrivalIcao;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Example> forEntity = restTemplate.getForEntity(
                URL + numberParam + airlineParam + dateParam + departureParam + arrivalParam,
                Example.class);
        return Objects.requireNonNull(forEntity.getBody()).getData();
    }
}
