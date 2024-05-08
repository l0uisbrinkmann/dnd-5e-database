
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


/**
 * Spells
 * <p>
 * 
 * 
 */
@Entity
@Generated("jsonschema2pojo")
public class Spells {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 
     * (Required)
     * 
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Spell> spell = new LinkedHashSet<Spell>();
    @OneToOne(cascade = CascadeType.PERSIST)
    private MetaBlock meta;

    /**
     * 
     * (Required)
     * 
     */
    public Set<Spell> getSpell() {
        return spell;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSpell(Set<Spell> spell) {
        this.spell = spell;
    }

    public Spells withSpell(Set<Spell> spell) {
        this.spell = spell;
        return this;
    }

    public MetaBlock getMeta() {
        return meta;
    }

    public void setMeta(MetaBlock meta) {
        this.meta = meta;
    }

    public Spells withMeta(MetaBlock meta) {
        this.meta = meta;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spells.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("spell");
        sb.append('=');
        sb.append(((this.spell == null)?"<null>":this.spell));
        sb.append(',');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
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
        result = ((result* 31)+((this.spell == null)? 0 :this.spell.hashCode()));
        result = ((result* 31)+((this.meta == null)? 0 :this.meta.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spells) == false) {
            return false;
        }
        Spells rhs = ((Spells) other);
        return ((((this.spell == rhs.spell)||((this.spell!= null)&&this.spell.equals(rhs.spell)))&&((this.meta == rhs.meta)||((this.meta!= null)&&this.meta.equals(rhs.meta))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }

}
