package com.louisbrinkmann.dnd5edatabase.jsonImport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

class SpellImporterTest {
    private SpellImporter spellImporter;

    @BeforeEach
    void setUp() {
        spellImporter = new SpellImporter();
    }

    @Test
    void shouldImportSpellsFromFile() {
        spellImporter.importFile(new File("./src/test/resources/phb-spells.json"));
    }
}