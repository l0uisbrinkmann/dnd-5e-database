package com.louisbrinkmann.dnd5edatabase.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpellDeserializerTest {

    private SpellDeserializer spellDeserializer;

    @BeforeEach
    void setUp() {
       spellDeserializer = new SpellDeserializer();
    }

    @Test
    void shouldDeserializeSpellCorrectly() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Spell.class, spellDeserializer);
        objectMapper.registerModule(simpleModule);

        // Act
        Spell spell = objectMapper.readValue(new File("./src/test/resources/data/spells/fireball.json"), Spell.class);

        // Assert
        assertEquals("Fireball", spell.getName());
    }
}