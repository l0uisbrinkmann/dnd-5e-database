package com.louisbrinkmann.dnd5edatabase.models.spells;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Spells {
    private List<Spell> spells;
}
