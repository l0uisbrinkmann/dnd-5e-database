package com.louisbrinkmann.dnd5edatabase.services;

import com.louisbrinkmann.dnd5edatabase.models.spells.SchoolOfMagic;
import com.louisbrinkmann.dnd5edatabase.models.spells.Source;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpellServiceTest {

    @Autowired
    SpellService spellService;

    @AfterEach
    void tearDown() {
        spellService.deleteAll();
    }

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

    @Test
    void shouldUpdateSpell() {
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
        spellService.save(spell);

        // Act
        spell = spellService.findByName("Fireball");
        spell.setCastingTime("10 minutes");
        spellService.updateOrInsert(spell);
        Spell fireball = spellService.findByName("Fireball");


        // Assert
        assertEquals("10 minutes", fireball.getCastingTime());
    }
}