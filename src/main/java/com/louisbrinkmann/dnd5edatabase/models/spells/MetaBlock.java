
package com.louisbrinkmann.dnd5edatabase.models.spells;

import javax.annotation.processing.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Generated("jsonschema2pojo")
public class MetaBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Dependencies dependencies;
    @OneToOne(cascade = CascadeType.PERSIST)
    private OtherSources otherSources;

    public Dependencies getDependencies() {
        return dependencies;
    }

    public void setDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public MetaBlock withDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
        return this;
    }

    public OtherSources getOtherSources() {
        return otherSources;
    }

    public void setOtherSources(OtherSources otherSources) {
        this.otherSources = otherSources;
    }

    public MetaBlock withOtherSources(OtherSources otherSources) {
        this.otherSources = otherSources;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetaBlock.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("dependencies");
        sb.append('=');
        sb.append(((this.dependencies == null)?"<null>":this.dependencies));
        sb.append(',');
        sb.append("otherSources");
        sb.append('=');
        sb.append(((this.otherSources == null)?"<null>":this.otherSources));
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
        result = ((result* 31)+((this.otherSources == null)? 0 :this.otherSources.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.dependencies == null)? 0 :this.dependencies.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetaBlock) == false) {
            return false;
        }
        MetaBlock rhs = ((MetaBlock) other);
        return ((((this.otherSources == rhs.otherSources)||((this.otherSources!= null)&&this.otherSources.equals(rhs.otherSources)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.dependencies == rhs.dependencies)||((this.dependencies!= null)&&this.dependencies.equals(rhs.dependencies))));
    }

}
