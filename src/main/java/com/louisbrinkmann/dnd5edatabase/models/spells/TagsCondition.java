
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum TagsCondition {

    BLINDED("blinded"),
    CHARMED("charmed"),
    DEAFENED("deafened"),
    EXHAUSTION("exhaustion"),
    FRIGHTENED("frightened"),
    GRAPPLED("grappled"),
    INCAPACITATED("incapacitated"),
    INVISIBLE("invisible"),
    PARALYZED("paralyzed"),
    PETRIFIED("petrified"),
    POISONED("poisoned"),
    PRONE("prone"),
    RESTRAINED("restrained"),
    STUNNED("stunned"),
    UNCONSCIOUS("unconscious");
    private final String value;
    private final static Map<String, TagsCondition> CONSTANTS = new HashMap<String, TagsCondition>();

    static {
        for (TagsCondition c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TagsCondition(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static TagsCondition fromValue(String value) {
        TagsCondition constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
