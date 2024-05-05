package com.louisbrinkmann.dnd5edatabase.jsonDeserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spells;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpellsDeserializerTest {


    @Test
    void shouldDeserializeSpellsFromJsonFile() throws IOException {
        File json = new File("./src/test/resources/phb-spells.json");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Spells.class, new SpellsDeserializer());
        mapper.registerModule(module);

        Spells spells = mapper.readValue(json, Spells.class);
        assertNotEquals(0, spells.getSpells().size());
    }

}