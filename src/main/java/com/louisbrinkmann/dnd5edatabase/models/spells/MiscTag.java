
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public enum MiscTag {

    AAD("AAD"),
    ADV("ADV"),
    DFT("DFT"),
    FMV("FMV"),
    HL("HL"),
    LGT("LGT"),
    LGTS("LGTS"),
    MAC("MAC"),
    OBJ("OBJ"),
    OBS("OBS"),
    PIR("PIR"),
    PRM("PRM"),
    PS("PS"),
    RO("RO"),
    SCL("SCL"),
    SMN("SMN"),
    SGT("SGT"),
    THP("THP"),
    TP("TP"),
    UBA("UBA");
    private final String value;
    private final static Map<String, MiscTag> CONSTANTS = new HashMap<String, MiscTag>();

    static {
        for (MiscTag c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MiscTag(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static MiscTag fromValue(String value) {
        MiscTag constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
