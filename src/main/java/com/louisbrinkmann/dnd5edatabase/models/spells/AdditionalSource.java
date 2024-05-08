
package com.louisbrinkmann.dnd5edatabase.models.spells;

import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Generated("jsonschema2pojo")
public class AdditionalSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    private String source;
    private Object page;

    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    public String getSource() {
        return source;
    }

    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    public void setSource(String source) {
        this.source = source;
    }

    public AdditionalSource withSource(String source) {
        this.source = source;
        return this;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public AdditionalSource withPage(Object page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdditionalSource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
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
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdditionalSource) == false) {
            return false;
        }
        AdditionalSource rhs = ((AdditionalSource) other);
        return ((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page))));
    }

}
