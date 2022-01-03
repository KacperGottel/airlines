package pl.kacperg.airlines.exchange;

public interface ExchangeService {

    Float getRate(String currency);
    Float exchange(String currency, Double amount);
}
