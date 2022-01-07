package pl.kacperg.airlines.apiendpoints;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Certificate {

    private String userCovidCertificate;
    private String userPersonals;


}
