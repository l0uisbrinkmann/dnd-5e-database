package com.louisbrinkmann.dnd5edatabase.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SpellCollection {
    List<Spell> spells;
}
