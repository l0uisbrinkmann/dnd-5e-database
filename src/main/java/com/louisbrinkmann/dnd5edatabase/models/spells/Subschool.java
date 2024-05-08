
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum Subschool {

    CONTAMINATED("contaminated");
    private final String value;
    private final static Map<String, Subschool> CONSTANTS = new HashMap<String, Subschool>();

    static {
        for (Subschool c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    Subschool(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static Subschool fromValue(String value) {
        Subschool constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
