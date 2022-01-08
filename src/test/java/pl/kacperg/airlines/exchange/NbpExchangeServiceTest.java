package pl.kacperg.airlines.exchange;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class NbpExchangeServiceTest {

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/a/";

    @Test
    void getRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Table> forEntity = restTemplate.getForEntity(URL + "gbp/", Table.class);
        Table body = forEntity.getBody();
        System.out.println(body.getRates().get(0).getMid());
    }


}