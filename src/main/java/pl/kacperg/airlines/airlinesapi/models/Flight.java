
package pl.kacperg.airlines.airlinesapi.models;

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
    "number",
    "iata",
    "icao",
    "codeshared"
})
@Generated("jsonschema2pojo")
public class Flight {

    @JsonProperty("number")
    private String number;
    @JsonProperty("iata")
    private String iata;
    @JsonProperty("icao")
    private String icao;
    @JsonProperty("codeshared")
    private Object codeshared;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
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

    @JsonProperty("codeshared")
    public Object getCodeshared() {
        return codeshared;
    }

    @JsonProperty("codeshared")
    public void setCodeshared(Object codeshared) {
        this.codeshared = codeshared;
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
        sb.append(Flight.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("iata");
        sb.append('=');
        sb.append(((this.iata == null)?"<null>":this.iata));
        sb.append(',');
        sb.append("icao");
        sb.append('=');
        sb.append(((this.icao == null)?"<null>":this.icao));
        sb.append(',');
        sb.append("codeshared");
        sb.append('=');
        sb.append(((this.codeshared == null)?"<null>":this.codeshared));
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
