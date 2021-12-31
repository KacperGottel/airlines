package pl.kacperg.airlines.airlinesapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
