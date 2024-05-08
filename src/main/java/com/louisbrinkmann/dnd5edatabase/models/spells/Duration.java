
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Generated("jsonschema2pojo")
public class Duration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 
     * (Required)
     * 
     */
    private Duration.Type type;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Duration__1 duration;
    private Boolean concentration;
    private List<End> ends = new ArrayList<End>();
    private String condition;

    /**
     * 
     * (Required)
     * 
     */
    public Duration.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Duration.Type type) {
        this.type = type;
    }

    public Duration withType(Duration.Type type) {
        this.type = type;
        return this;
    }

    public Duration__1 getDuration() {
        return duration;
    }

    public void setDuration(Duration__1 duration) {
        this.duration = duration;
    }

    public Duration withDuration(Duration__1 duration) {
        this.duration = duration;
        return this;
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    public Duration withConcentration(Boolean concentration) {
        this.concentration = concentration;
        return this;
    }

    public List<End> getEnds() {
        return ends;
    }

    public void setEnds(List<End> ends) {
        this.ends = ends;
    }

    public Duration withEnds(List<End> ends) {
        this.ends = ends;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Duration withCondition(String condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Duration.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("concentration");
        sb.append('=');
        sb.append(((this.concentration == null)?"<null>":this.concentration));
        sb.append(',');
        sb.append("ends");
        sb.append('=');
        sb.append(((this.ends == null)?"<null>":this.ends));
        sb.append(',');
        sb.append("condition");
        sb.append('=');
        sb.append(((this.condition == null)?"<null>":this.condition));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.duration == null)? 0 :this.duration.hashCode()));
        result = ((result* 31)+((this.concentration == null)? 0 :this.concentration.hashCode()));
        result = ((result* 31)+((this.condition == null)? 0 :this.condition.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.ends == null)? 0 :this.ends.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Duration) == false) {
            return false;
        }
        Duration rhs = ((Duration) other);
        return (((((((this.duration == rhs.duration)||((this.duration!= null)&&this.duration.equals(rhs.duration)))&&((this.concentration == rhs.concentration)||((this.concentration!= null)&&this.concentration.equals(rhs.concentration))))&&((this.condition == rhs.condition)||((this.condition!= null)&&this.condition.equals(rhs.condition))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.ends == rhs.ends)||((this.ends!= null)&&this.ends.equals(rhs.ends))));
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        INSTANT("instant"),
        TIMED("timed"),
        PERMANENT("permanent"),
        SPECIAL("special");
        private final String value;
        private final static Map<String, Duration.Type> CONSTANTS = new HashMap<String, Duration.Type>();

        static {
            for (Duration.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Duration.Type fromValue(String value) {
            Duration.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
