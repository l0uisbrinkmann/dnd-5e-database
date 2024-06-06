package com.louisbrinkmann.dnd5edatabase.jsonReaders;

import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpellCollectionReaderTest {

    @Test
    void shouldReadSpellDirectory() {
        // Arrange
        File spellDirectory = new File("./src/test/resources/data/spells/spellDirectory");

        // Act
        List<SpellCollection> spellCollections = SpellCollectionReader.readSpellDirectory(spellDirectory);

        // Assert
        assertNotEquals(0, spellCollections.size());
    }

    @Test
    void shouldReadSpellFile() throws IOException {
        // Arrange
        File spellFile = new File("./src/test/resources/data/spells/spellDirectory/spells-phb.json");

        // Act
        SpellCollection spellCollection = SpellCollectionReader.readSpellFile(spellFile);

        // Assert
        assertFalse(spellCollection.getSpells().isEmpty());
    }
}