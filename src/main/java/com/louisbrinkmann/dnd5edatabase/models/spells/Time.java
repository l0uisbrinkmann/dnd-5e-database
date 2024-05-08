
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Generated("jsonschema2pojo")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    /**
     * 
     * (Required)
     * 
     */
    private Time.Unit unit;
    private String condition;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Time withNumber(Integer number) {
        this.number = number;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Time.Unit getUnit() {
        return unit;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setUnit(Time.Unit unit) {
        this.unit = unit;
    }

    public Time withUnit(Time.Unit unit) {
        this.unit = unit;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Time withCondition(String condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Time.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null)?"<null>":this.unit));
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
        result = ((result* 31)+((this.number == null)? 0 :this.number.hashCode()));
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        result = ((result* 31)+((this.condition == null)? 0 :this.condition.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Time) == false) {
            return false;
        }
        Time rhs = ((Time) other);
        return (((((this.number == rhs.number)||((this.number!= null)&&this.number.equals(rhs.number)))&&((this.unit == rhs.unit)||((this.unit!= null)&&this.unit.equals(rhs.unit))))&&((this.condition == rhs.condition)||((this.condition!= null)&&this.condition.equals(rhs.condition))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }

    @Generated("jsonschema2pojo")
    public enum Unit {

        ACTION("action"),
        BONUS("bonus"),
        REACTION("reaction"),
        ROUND("round"),
        MINUTE("minute"),
        HOUR("hour"),
        SPECIAL("special");
        private final String value;
        private final static Map<String, Time.Unit> CONSTANTS = new HashMap<String, Time.Unit>();

        static {
            for (Time.Unit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Unit(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Time.Unit fromValue(String value) {
            Time.Unit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
