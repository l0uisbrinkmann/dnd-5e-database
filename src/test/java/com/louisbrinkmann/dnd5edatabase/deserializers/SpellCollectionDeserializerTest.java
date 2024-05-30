package com.louisbrinkmann.dnd5edatabase.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpellCollectionDeserializerTest {
    private SpellCollectionDeserializer spellCollectionDeserializer;

    @BeforeEach
    void setUp() {
        spellCollectionDeserializer = new SpellCollectionDeserializer();
    }

    @Test
    void shouldDeserializeSpellsCorrectly() throws IOException {
        // Arrange
        File phbSpells = new File("./src/test/resources/data/spells/spells-phb.json");


        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(SpellCollection.class, spellCollectionDeserializer);
        objectMapper.registerModule(simpleModule);

        // Act
        SpellCollection spellCollection = objectMapper.readValue(phbSpells, SpellCollection.class);
        List<Spell> spells = spellCollection.getSpells();

        // Assert
        assertEquals(361, spells.size());
     }
}