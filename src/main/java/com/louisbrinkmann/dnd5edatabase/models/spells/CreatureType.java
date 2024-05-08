
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum CreatureType {

    ABERRATION("aberration"),
    BEAST("beast"),
    CELESTIAL("celestial"),
    CONSTRUCT("construct"),
    DRAGON("dragon"),
    ELEMENTAL("elemental"),
    FEY("fey"),
    FIEND("fiend"),
    GIANT("giant"),
    HUMANOID("humanoid"),
    MONSTROSITY("monstrosity"),
    OOZE("ooze"),
    PLANT("plant"),
    UNDEAD("undead");
    private final String value;
    private final static Map<String, CreatureType> CONSTANTS = new HashMap<String, CreatureType>();

    static {
        for (CreatureType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CreatureType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static CreatureType fromValue(String value) {
        CreatureType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
