
package com.louisbrinkmann.dnd5edatabase.models.spells;

import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Generated("jsonschema2pojo")
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean v;
    private Boolean s;
    private Object m;
    /**
     * "Royalty" components, as introduced in Acquisitions Incorporated
     * 
     */
    private Boolean r;

    public Boolean getV() {
        return v;
    }

    public void setV(Boolean v) {
        this.v = v;
    }

    public Components withV(Boolean v) {
        this.v = v;
        return this;
    }

    public Boolean getS() {
        return s;
    }

    public void setS(Boolean s) {
        this.s = s;
    }

    public Components withS(Boolean s) {
        this.s = s;
        return this;
    }

    public Object getM() {
        return m;
    }

    public void setM(Object m) {
        this.m = m;
    }

    public Components withM(Object m) {
        this.m = m;
        return this;
    }

    /**
     * "Royalty" components, as introduced in Acquisitions Incorporated
     * 
     */
    public Boolean getR() {
        return r;
    }

    /**
     * "Royalty" components, as introduced in Acquisitions Incorporated
     * 
     */
    public void setR(Boolean r) {
        this.r = r;
    }

    public Components withR(Boolean r) {
        this.r = r;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Components.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("v");
        sb.append('=');
        sb.append(((this.v == null)?"<null>":this.v));
        sb.append(',');
        sb.append("s");
        sb.append('=');
        sb.append(((this.s == null)?"<null>":this.s));
        sb.append(',');
        sb.append("m");
        sb.append('=');
        sb.append(((this.m == null)?"<null>":this.m));
        sb.append(',');
        sb.append("r");
        sb.append('=');
        sb.append(((this.r == null)?"<null>":this.r));
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
        result = ((result* 31)+((this.r == null)? 0 :this.r.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.s == null)? 0 :this.s.hashCode()));
        result = ((result* 31)+((this.m == null)? 0 :this.m.hashCode()));
        result = ((result* 31)+((this.v == null)? 0 :this.v.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Components) == false) {
            return false;
        }
        Components rhs = ((Components) other);
        return ((((((this.r == rhs.r)||((this.r!= null)&&this.r.equals(rhs.r)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.s == rhs.s)||((this.s!= null)&&this.s.equals(rhs.s))))&&((this.m == rhs.m)||((this.m!= null)&&this.m.equals(rhs.m))))&&((this.v == rhs.v)||((this.v!= null)&&this.v.equals(rhs.v))));
    }

}
