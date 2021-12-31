package pl.kacperg.airlines.airlinesapi;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicReference;

class AviationstackServiceTest {

    final String API_KEY = "8e3944af408f0cce47e591eda39882c1";
    final String url  = "http://api.aviationstack.com/v1/flights?access_key=" + API_KEY;

    @Test
    void  getAllFlightsThenGetConcreteFlightByNumber() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Example> forEntity = restTemplate.getForEntity(url, Example.class);
        Example allFlights = forEntity.getBody();
        assert allFlights != null;
        for (Datum datum : allFlights.getData()) {
            if (datum.getFlight().getNumber().equals("0")){
                System.out.println("true" + datum.getFlight().getNumber());
                break;
            }else {
                System.out.println("false" + allFlights.getData().get(0).getFlight().getNumber());
                break;
            }
        }


    }

}