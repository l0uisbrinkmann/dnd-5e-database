
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
public class Duration__1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 
     * (Required)
     * 
     */
    private Duration__1 .Type type;
    private Integer amount;
    private Boolean upTo;

    /**
     * 
     * (Required)
     * 
     */
    public Duration__1 .Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Duration__1 .Type type) {
        this.type = type;
    }

    public Duration__1 withType(Duration__1 .Type type) {
        this.type = type;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Duration__1 withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Boolean getUpTo() {
        return upTo;
    }

    public void setUpTo(Boolean upTo) {
        this.upTo = upTo;
    }

    public Duration__1 withUpTo(Boolean upTo) {
        this.upTo = upTo;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Duration__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("upTo");
        sb.append('=');
        sb.append(((this.upTo == null)?"<null>":this.upTo));
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
        result = ((result* 31)+((this.upTo == null)? 0 :this.upTo.hashCode()));
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Duration__1) == false) {
            return false;
        }
        Duration__1 rhs = ((Duration__1) other);
        return (((((this.upTo == rhs.upTo)||((this.upTo!= null)&&this.upTo.equals(rhs.upTo)))&&((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        TURN("turn"),
        ROUND("round"),
        MINUTE("minute"),
        HOUR("hour"),
        DAY("day"),
        WEEK("week"),
        MONTH("month"),
        YEAR("year");
        private final String value;
        private final static Map<String, Duration__1 .Type> CONSTANTS = new HashMap<String, Duration__1 .Type>();

        static {
            for (Duration__1 .Type c: values()) {
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

        public static Duration__1 .Type fromValue(String value) {
            Duration__1 .Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
