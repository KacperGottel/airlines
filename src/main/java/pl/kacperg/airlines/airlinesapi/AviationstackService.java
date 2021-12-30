package pl.kacperg.airlines.airlinesapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AviationstackService implements FlightsData{

    final String API_KEY = "f0ca7fcfdab5afe841d110e2c7491dc0";
    final String url  = "http://api.aviationstack.com/v1/flights?access_key=" + API_KEY;

    @Override
    public Example getAllFlights() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Example> forEntity = restTemplate.getForEntity(url, Example.class);
        Example body = forEntity.getBody();
        return body;
    }
}
