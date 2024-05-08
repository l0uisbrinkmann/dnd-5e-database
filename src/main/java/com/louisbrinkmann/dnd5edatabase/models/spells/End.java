
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;


/**
 * The examples given are short forms that are automatically expanded to "discharged", "dispelled" & "triggered".
 * Homebrew files should state custom end conditions in full.
 * 
 */
@Generated("jsonschema2pojo")
public enum End {

    DISPEL("dispel"),
    TRIGGER("trigger"),
    DISCHARGE("discharge");
    private final String value;
    private final static Map<String, End> CONSTANTS = new HashMap<String, End>();

    static {
        for (End c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    End(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static End fromValue(String value) {
        End constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
