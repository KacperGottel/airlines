
package pl.kacperg.airlines.airlinesapi;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "registration",
    "iata",
    "icao",
    "icao24"
})
@Generated("jsonschema2pojo")
public class Aircraft {

    @JsonProperty("registration")
    private String registration;
    @JsonProperty("iata")
    private String iata;
    @JsonProperty("icao")
    private String icao;
    @JsonProperty("icao24")
    private String icao24;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("registration")
    public String getRegistration() {
        return registration;
    }

    @JsonProperty("registration")
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @JsonProperty("iata")
    public String getIata() {
        return iata;
    }

    @JsonProperty("iata")
    public void setIata(String iata) {
        this.iata = iata;
    }

    @JsonProperty("icao")
    public String getIcao() {
        return icao;
    }

    @JsonProperty("icao")
    public void setIcao(String icao) {
        this.icao = icao;
    }

    @JsonProperty("icao24")
    public String getIcao24() {
        return icao24;
    }

    @JsonProperty("icao24")
    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Aircraft.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("registration");
        sb.append('=');
        sb.append(((this.registration == null)?"<null>":this.registration));
        sb.append(',');
        sb.append("iata");
        sb.append('=');
        sb.append(((this.iata == null)?"<null>":this.iata));
        sb.append(',');
        sb.append("icao");
        sb.append('=');
        sb.append(((this.icao == null)?"<null>":this.icao));
        sb.append(',');
        sb.append("icao24");
        sb.append('=');
        sb.append(((this.icao24 == null)?"<null>":this.icao24));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
