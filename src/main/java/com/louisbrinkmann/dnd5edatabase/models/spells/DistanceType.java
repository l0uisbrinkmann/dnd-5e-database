package com.louisbrinkmann.dnd5edatabase.models.spells;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum DistanceType {
    FEET("foot"),
    YARDS("yard"),
    MILES("mile"),
    SELF(),
    TOUCH(),
    UNLIMITED(),
    PLANE(),
    SIGHT();

    String singular;

    DistanceType(String singular) {
        this.singular = singular;
    }
}

