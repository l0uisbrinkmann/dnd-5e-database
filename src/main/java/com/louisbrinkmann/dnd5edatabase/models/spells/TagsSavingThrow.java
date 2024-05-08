
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum TagsSavingThrow {

    STRENGTH("strength"),
    CONSTITUTION("constitution"),
    DEXTERITY("dexterity"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma");
    private final String value;
    private final static Map<String, TagsSavingThrow> CONSTANTS = new HashMap<String, TagsSavingThrow>();

    static {
        for (TagsSavingThrow c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TagsSavingThrow(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static TagsSavingThrow fromValue(String value) {
        TagsSavingThrow constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
