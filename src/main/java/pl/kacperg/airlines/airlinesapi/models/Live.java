
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
    "updated",
    "latitude",
    "longitude",
    "altitude",
    "direction",
    "speed_horizontal",
    "speed_vertical",
    "is_ground"
})
@Generated("jsonschema2pojo")
public class Live {

    @JsonProperty("updated")
    private String updated;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("altitude")
    private Double altitude;
    @JsonProperty("direction")
    private Double direction;
    @JsonProperty("speed_horizontal")
    private Double speedHorizontal;
    @JsonProperty("speed_vertical")
    private Double speedVertical;
    @JsonProperty("is_ground")
    private Boolean isGround;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("altitude")
    public Double getAltitude() {
        return altitude;
    }

    @JsonProperty("altitude")
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    @JsonProperty("direction")
    public Double getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(Double direction) {
        this.direction = direction;
    }

    @JsonProperty("speed_horizontal")
    public Double getSpeedHorizontal() {
        return speedHorizontal;
    }

    @JsonProperty("speed_horizontal")
    public void setSpeedHorizontal(Double speedHorizontal) {
        this.speedHorizontal = speedHorizontal;
    }

    @JsonProperty("speed_vertical")
    public Double getSpeedVertical() {
        return speedVertical;
    }

    @JsonProperty("speed_vertical")
    public void setSpeedVertical(Double speedVertical) {
        this.speedVertical = speedVertical;
    }

    @JsonProperty("is_ground")
    public Boolean getIsGround() {
        return isGround;
    }

    @JsonProperty("is_ground")
    public void setIsGround(Boolean isGround) {
        this.isGround = isGround;
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
        sb.append(Live.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("updated");
        sb.append('=');
        sb.append(((this.updated == null)?"<null>":this.updated));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("altitude");
        sb.append('=');
        sb.append(((this.altitude == null)?"<null>":this.altitude));
        sb.append(',');
        sb.append("direction");
        sb.append('=');
        sb.append(((this.direction == null)?"<null>":this.direction));
        sb.append(',');
        sb.append("speedHorizontal");
        sb.append('=');
        sb.append(((this.speedHorizontal == null)?"<null>":this.speedHorizontal));
        sb.append(',');
        sb.append("speedVertical");
        sb.append('=');
        sb.append(((this.speedVertical == null)?"<null>":this.speedVertical));
        sb.append(',');
        sb.append("isGround");
        sb.append('=');
        sb.append(((this.isGround == null)?"<null>":this.isGround));
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
