package pl.kacperg.airlines.exchange;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpExchangeService implements ExchangeService {

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/a/";

    @Override
    public Float getRate(String currency) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Table> forEntity = restTemplate.getForEntity(URL + currency, Table.class);
        Table body = forEntity.getBody();
        if (body != null) {
            return Float.parseFloat(String.valueOf(body.getRates().get(0).getMid()));
        } else {
            return 0f;
        }
    }

    @Override
    public Float exchange(String currency, Double amount) {
        return Float.parseFloat(String.valueOf(getRate(currency) * amount));
    }
}
