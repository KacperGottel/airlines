package pl.kacperg.airlines.user.tickets;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Certificate {

    private String userCovidCertificate;
    private String userPersonals;


}
