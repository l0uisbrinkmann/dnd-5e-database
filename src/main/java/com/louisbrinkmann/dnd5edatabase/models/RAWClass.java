package com.louisbrinkmann.dnd5edatabase.models;

import lombok.Getter;

@Getter
public enum RAWClass {
    BARBARIAN("Barbarian", "A fierce warrior of primitive background who can enter a battle rage."),
    BARD("Bard", "An inspiring magician whose power echoes the music of creation."),
    CLERIC("Cleric", "A priestly champion who wields divine magic in service of a higher power."),
    DRUID("Druid", "A priest of the Old Faith, wielding the powers of nature and adopting animal forms."),
    FIGHTER("Fighter", "A master of martial combat, skilled with a variety of weapons and armor."),
    MONK("Monk", "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection."),
    PALADIN("Paladin", "A holy warrior bound to a sacred oath."),
    RANGER("Ranger", "A warrior who uses martial prowess and nature magic to combat threats on the edges of civilization."),
    ROGUE("Rogue", "A scoundrel who uses stealth and trickery to overcome obstacles and enemies."),
    SORCERER("Sorcerer", "A spellcaster who draws on inherent magic from a gift or bloodline."),
    WARLOCK("Warlock", "A wielder of magic that is derived from a bargain with an extraplanar entity."),
    WIZARD("Wizard", "A scholarly magic-user capable of manipulating the structures of reality.");

    private final String name;
    private final String description;

    RAWClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
