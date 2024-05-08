
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
public class OtherSources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Keys are other sources to be loaded; values are `otherSources` sources from that source to search for.
     * 
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Monster monster;

    /**
     * Keys are other sources to be loaded; values are `otherSources` sources from that source to search for.
     * 
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Keys are other sources to be loaded; values are `otherSources` sources from that source to search for.
     * 
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public OtherSources withMonster(Monster monster) {
        this.monster = monster;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OtherSources.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("monster");
        sb.append('=');
        sb.append(((this.monster == null)?"<null>":this.monster));
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
        result = ((result* 31)+((this.monster == null)? 0 :this.monster.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OtherSources) == false) {
            return false;
        }
        OtherSources rhs = ((OtherSources) other);
        return (((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.monster == rhs.monster)||((this.monster!= null)&&this.monster.equals(rhs.monster))));
    }

}
