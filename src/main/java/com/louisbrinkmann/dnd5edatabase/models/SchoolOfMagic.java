package com.louisbrinkmann.dnd5edatabase.models;

import lombok.Getter;

@Getter
public enum SchoolOfMagic {
    ABJURATION("Abjuration", "Specializes in protective spells, creating barriers, and negating magic.", 'A'),
    CONJURATION("Conjuration", "Focuses on spells that transport objects or creatures from one location to another.", 'C'),
    DIVINATION("Divination", "Centers on spells that reveal information, whether in the past, present, or future.", 'D'),
    ENCHANTMENT("Enchantment", "Involves spells that affect the minds of others, influencing or controlling their behavior.", 'E'),
    EVOCATION("Evocation", "Emphasizes spells that manipulate energy to create powerful effects, often offensive.", 'V'),
    ILLUSION("Illusion", "Specializes in spells that deceive the senses or create false images.", 'I'),
    NECROMANCY("Necromancy", "Deals with spells that manipulate life and death, often considered taboo.", 'N'),
    TRANSMUTATION("Transmutation", "Focuses on spells that change the properties of matter or creatures.", 'T');

    private final String name;
    private final String description;
    private final Character abbreviation;

    SchoolOfMagic(String name, String description, Character abbreviation) {
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return name + " (" + abbreviation + "): " + description;
    }

    public static SchoolOfMagic fromAbbreviation(Character abbreviation) {
        for (SchoolOfMagic school : values()) {
            if (school.getAbbreviation().equals(abbreviation)) {
                return school;
            }
        }
        throw new IllegalArgumentException("No magic school found with abbreviation: " + abbreviation);
    }
}
