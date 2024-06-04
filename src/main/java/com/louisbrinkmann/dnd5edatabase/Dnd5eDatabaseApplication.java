package com.louisbrinkmann.dnd5edatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.deserializers.SpellCollectionDeserializer;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import com.louisbrinkmann.dnd5edatabase.services.SpellService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Dnd5eDatabaseApplication {

	private static SpellService spellService;

	@Autowired
	public Dnd5eDatabaseApplication(SpellService spellService) {
		this.spellService = spellService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Dnd5eDatabaseApplication.class, args);
		SpellCollectionDeserializer spellCollectionDeserializer = new SpellCollectionDeserializer();
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addDeserializer(SpellCollection.class, spellCollectionDeserializer);
		objectMapper.registerModule(simpleModule);
		File spellFilesIndex = new File("./src/main/resources/data/spells/index.json");
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject obj = (JSONObject) jsonParser.parse(new FileReader(spellFilesIndex));
            for (Object o : obj.keySet()) {
                File spellsFile = new File("./src/main/resources/data/spells/" + obj.get(o));
                List<Spell> spells = objectMapper.readValue(spellsFile, SpellCollection.class).getSpells();
                spellService.saveAll(spells);
            }
		} catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

		List<Spell> savedSpells = spellService.findAll();
		log.info("Found " + savedSpells.size() + " spells in database.");

    }
}
