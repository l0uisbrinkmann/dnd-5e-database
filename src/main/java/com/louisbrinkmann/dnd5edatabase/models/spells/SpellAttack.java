
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;


/**
 * M: Melee
 *  R: Ranged
 *  O: Other/Unknown
 * 
 */
@Generated("jsonschema2pojo")
public enum SpellAttack {

    M("M"),
    R("R"),
    O("O");
    private final String value;
    private final static Map<String, SpellAttack> CONSTANTS = new HashMap<String, SpellAttack>();

    static {
        for (SpellAttack c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    SpellAttack(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static SpellAttack fromValue(String value) {
        SpellAttack constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
