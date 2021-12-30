
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
    "airport",
    "timezone",
    "iata",
    "icao",
    "terminal",
    "gate",
    "baggage",
    "delay",
    "scheduled",
    "estimated",
    "actual",
    "estimated_runway",
    "actual_runway"
})
@Generated("jsonschema2pojo")
public class Arrival {

    @JsonProperty("airport")
    private String airport;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("iata")
    private String iata;
    @JsonProperty("icao")
    private String icao;
    @JsonProperty("terminal")
    private String terminal;
    @JsonProperty("gate")
    private String gate;
    @JsonProperty("baggage")
    private String baggage;
    @JsonProperty("delay")
    private Integer delay;
    @JsonProperty("scheduled")
    private String scheduled;
    @JsonProperty("estimated")
    private String estimated;
    @JsonProperty("actual")
    private Object actual;
    @JsonProperty("estimated_runway")
    private Object estimatedRunway;
    @JsonProperty("actual_runway")
    private Object actualRunway;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airport")
    public String getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(String airport) {
        this.airport = airport;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    @JsonProperty("terminal")
    public String getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @JsonProperty("gate")
    public String getGate() {
        return gate;
    }

    @JsonProperty("gate")
    public void setGate(String gate) {
        this.gate = gate;
    }

    @JsonProperty("baggage")
    public String getBaggage() {
        return baggage;
    }

    @JsonProperty("baggage")
    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @JsonProperty("scheduled")
    public String getScheduled() {
        return scheduled;
    }

    @JsonProperty("scheduled")
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    @JsonProperty("estimated")
    public String getEstimated() {
        return estimated;
    }

    @JsonProperty("estimated")
    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    @JsonProperty("actual")
    public Object getActual() {
        return actual;
    }

    @JsonProperty("actual")
    public void setActual(Object actual) {
        this.actual = actual;
    }

    @JsonProperty("estimated_runway")
    public Object getEstimatedRunway() {
        return estimatedRunway;
    }

    @JsonProperty("estimated_runway")
    public void setEstimatedRunway(Object estimatedRunway) {
        this.estimatedRunway = estimatedRunway;
    }

    @JsonProperty("actual_runway")
    public Object getActualRunway() {
        return actualRunway;
    }

    @JsonProperty("actual_runway")
    public void setActualRunway(Object actualRunway) {
        this.actualRunway = actualRunway;
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
        sb.append(Arrival.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("airport");
        sb.append('=');
        sb.append(((this.airport == null)?"<null>":this.airport));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null)?"<null>":this.timezone));
        sb.append(',');
        sb.append("iata");
        sb.append('=');
        sb.append(((this.iata == null)?"<null>":this.iata));
        sb.append(',');
        sb.append("icao");
        sb.append('=');
        sb.append(((this.icao == null)?"<null>":this.icao));
        sb.append(',');
        sb.append("terminal");
        sb.append('=');
        sb.append(((this.terminal == null)?"<null>":this.terminal));
        sb.append(',');
        sb.append("gate");
        sb.append('=');
        sb.append(((this.gate == null)?"<null>":this.gate));
        sb.append(',');
        sb.append("baggage");
        sb.append('=');
        sb.append(((this.baggage == null)?"<null>":this.baggage));
        sb.append(',');
        sb.append("delay");
        sb.append('=');
        sb.append(((this.delay == null)?"<null>":this.delay));
        sb.append(',');
        sb.append("scheduled");
        sb.append('=');
        sb.append(((this.scheduled == null)?"<null>":this.scheduled));
        sb.append(',');
        sb.append("estimated");
        sb.append('=');
        sb.append(((this.estimated == null)?"<null>":this.estimated));
        sb.append(',');
        sb.append("actual");
        sb.append('=');
        sb.append(((this.actual == null)?"<null>":this.actual));
        sb.append(',');
        sb.append("estimatedRunway");
        sb.append('=');
        sb.append(((this.estimatedRunway == null)?"<null>":this.estimatedRunway));
        sb.append(',');
        sb.append("actualRunway");
        sb.append('=');
        sb.append(((this.actualRunway == null)?"<null>":this.actualRunway));
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
