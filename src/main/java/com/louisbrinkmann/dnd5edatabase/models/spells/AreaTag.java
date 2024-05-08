
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum AreaTag {

    ST("ST"),
    MT("MT"),
    R("R"),
    N("N"),
    C("C"),
    Y("Y"),
    H("H"),
    L("L"),
    S("S"),
    Q("Q"),
    W("W");
    private final String value;
    private final static Map<String, AreaTag> CONSTANTS = new HashMap<String, AreaTag>();

    static {
        for (AreaTag c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AreaTag(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static AreaTag fromValue(String value) {
        AreaTag constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
