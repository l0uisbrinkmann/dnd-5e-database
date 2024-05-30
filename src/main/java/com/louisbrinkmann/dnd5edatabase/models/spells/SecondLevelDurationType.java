package com.louisbrinkmann.dnd5edatabase.models.spells;

import lombok.Getter;

@Getter
public enum SecondLevelDurationType {
    TURN("turns"),
    ROUND("rounds"),
    MINUTE("minutes"),
    HOUR("hours"),
    DAY("days"),
    WEEK("weeks"),
    MONTH("months"),
    YEAR("years");

    final String plural;

    SecondLevelDurationType(String plural) {
        this.plural = plural;
    }
}
