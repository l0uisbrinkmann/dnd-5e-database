package com.louisbrinkmann.dnd5edatabase;

import com.louisbrinkmann.dnd5edatabase.jsonImport.SpellImporter;
import com.louisbrinkmann.dnd5edatabase.models.Spell;
import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class DataImportTest {
    @Autowired
    SpellRepository spellDataRepository;

    @Test
    void shouldImportSpellsFromJsonFile() {
        File phbSpells = new File("./src/test/resources/phb-spells.json");
        SpellImporter spellImporter = new SpellImporter();

        Spell[] spells = spellImporter.importFile(phbSpells);
        spellDataRepository.saveAll(Arrays.asList(spells));
        List<Spell> spellList = spellDataRepository.findAll();

        assertNotEquals(0, spellList.size());
    }
}
