package com.louisbrinkmann.dnd5edatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.jsonDeserializers.SpellCollectionDeserializer;
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
import java.io.FileReader;
import java.io.IOException;
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


    }
}
