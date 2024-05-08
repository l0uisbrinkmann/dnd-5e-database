package com.louisbrinkmann.dnd5edatabase;
import com.louisbrinkmann.dnd5edatabase.json.JS2JPGenerator;
import com.louisbrinkmann.dnd5edatabase.json.JacksonDeserializer;
//import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
//import com.louisbrinkmann.dnd5edatabase.models.spells.Spells;
//import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import com.sun.codemodel.JCodeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Dnd5eDatabaseApplication {
//	private static SpellRepository spellRepository;
//
//	@Autowired
//	public Dnd5eDatabaseApplication(SpellRepository spellRepository) {
//		this.spellRepository = spellRepository;
//	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Dnd5eDatabaseApplication.class, args);
		JCodeModel codeModel = new JCodeModel();
		URL jsonSpells = new File("./src/main/resources/schemas/spells/spells.json").toURI().toURL();
		File targetClassDirectory = new File("./src/main/java");
		JS2JPGenerator.generatePojosForSchema(jsonSpells, targetClassDirectory, "com.louisbrinkmann.dnd5edatabase.models.spells","Spells");
//		File phbSpellsFile = new File("./src/main/resources/data/spells/spells-phb.json");
//		JacksonDeserializer<Spells> spellsDeserializer = new JacksonDeserializer<>();
//		Set<Spell> phbSpells = spellsDeserializer.deserialize(phbSpellsFile, Spells.class).getSpell();
//		spellRepository.saveAll(phbSpells);
//		List<Spell> retrievedSpells = spellRepository.findAll();
//		log.info("Spells retrieved from the database:");
//		for(Spell spell : retrievedSpells){
//			log.info(spell.getName());
//		}
	}
}
