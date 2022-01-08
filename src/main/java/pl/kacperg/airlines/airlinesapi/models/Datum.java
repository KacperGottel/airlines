
package pl.kacperg.airlines.airlinesapi.models;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flight_date",
    "flight_status",
    "departure",
    "arrival",
    "airline",
    "flight",
    "aircraft",
    "live"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("flight_date")
    private String flightDate;
    @JsonProperty("flight_status")
    private String flightStatus;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonProperty("airline")
    private Airline airline;
    @JsonProperty("flight")
    private Flight flight;
    @JsonProperty("aircraft")
    private Aircraft aircraft;
    @JsonProperty("live")
    private Live live;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flight_date")
    public String getFlightDate() {
        return flightDate;
    }

    @JsonProperty("flight_date")
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    @JsonProperty("flight_status")
    public String getFlightStatus() {
        return flightStatus;
    }

    @JsonProperty("flight_status")
    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }

    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("airline")
    public Airline getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @JsonProperty("flight")
    public Flight getFlight() {
        return flight;
    }

    @JsonProperty("flight")
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @JsonProperty("aircraft")
    public Aircraft getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("live")
    public Live getLive() {
        return live;
    }

    @JsonProperty("live")
    public void setLive(Live live) {
        this.live = live;
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
        sb.append(Datum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("flightDate");
        sb.append('=');
        sb.append(((this.flightDate == null)?"<null>":this.flightDate));
        sb.append(',');
        sb.append("flightStatus");
        sb.append('=');
        sb.append(((this.flightStatus == null)?"<null>":this.flightStatus));
        sb.append(',');
        sb.append("departure");
        sb.append('=');
        sb.append(((this.departure == null)?"<null>":this.departure));
        sb.append(',');
        sb.append("arrival");
        sb.append('=');
        sb.append(((this.arrival == null)?"<null>":this.arrival));
        sb.append(',');
        sb.append("airline");
        sb.append('=');
        sb.append(((this.airline == null)?"<null>":this.airline));
        sb.append(',');
        sb.append("flight");
        sb.append('=');
        sb.append(((this.flight == null)?"<null>":this.flight));
        sb.append(',');
        sb.append("aircraft");
        sb.append('=');
        sb.append(((this.aircraft == null)?"<null>":this.aircraft));
        sb.append(',');
        sb.append("live");
        sb.append('=');
        sb.append(((this.live == null)?"<null>":this.live));
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
