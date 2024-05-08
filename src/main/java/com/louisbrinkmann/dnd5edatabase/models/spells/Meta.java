
package com.louisbrinkmann.dnd5edatabase.models.spells;

import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Generated("jsonschema2pojo")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ritual;
    private Boolean technomagic;

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    public Meta withRitual(Boolean ritual) {
        this.ritual = ritual;
        return this;
    }

    public Boolean getTechnomagic() {
        return technomagic;
    }

    public void setTechnomagic(Boolean technomagic) {
        this.technomagic = technomagic;
    }

    public Meta withTechnomagic(Boolean technomagic) {
        this.technomagic = technomagic;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Meta.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("ritual");
        sb.append('=');
        sb.append(((this.ritual == null)?"<null>":this.ritual));
        sb.append(',');
        sb.append("technomagic");
        sb.append('=');
        sb.append(((this.technomagic == null)?"<null>":this.technomagic));
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
        result = ((result* 31)+((this.ritual == null)? 0 :this.ritual.hashCode()));
        result = ((result* 31)+((this.technomagic == null)? 0 :this.technomagic.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Meta) == false) {
            return false;
        }
        Meta rhs = ((Meta) other);
        return ((((this.ritual == rhs.ritual)||((this.ritual!= null)&&this.ritual.equals(rhs.ritual)))&&((this.technomagic == rhs.technomagic)||((this.technomagic!= null)&&this.technomagic.equals(rhs.technomagic))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }

}
