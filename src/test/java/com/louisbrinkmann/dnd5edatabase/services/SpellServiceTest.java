package com.louisbrinkmann.dnd5edatabase.services;

import com.louisbrinkmann.dnd5edatabase.models.spells.SchoolOfMagic;
import com.louisbrinkmann.dnd5edatabase.models.spells.Source;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpellServiceTest {

    @Autowired
    SpellService spellService;

    @Test
    void shouldSaveSpellWithSource() {
        // Arrange
        Source source = new Source("PHB", 270);
        Spell spell = Spell.builder()
                .name("Fireball")
                .level(3)
                .schoolOfMagic(SchoolOfMagic.EVOCATION)
                .castingTime("1 action")
                .range("60 feet")
                .duration("instantaneous")
                .description("You hurl a ball of fire at a point you can see within range.")
                .source(source)
                .build();

        // Act
        spellService.save(spell);
        Spell fireball = spellService.findByName("Fireball");

        // Assert
        assertNotEquals(null, fireball);
    }
}