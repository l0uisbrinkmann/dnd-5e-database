package com.louisbrinkmann.dnd5edatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.jsonDeserialization.SpellsDeserializer;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spells;
import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import jakarta.annotation.security.RunAs;
import lombok.extern.slf4j.Slf4j;
import org.attoparser.output.TextOutputMarkupHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Dnd5eDatabaseApplication {
	private static SpellRepository spellRepository;

	@Autowired
	public Dnd5eDatabaseApplication(SpellRepository spellRepository) {
		this.spellRepository = spellRepository;
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Dnd5eDatabaseApplication.class, args);
		File directory = new File("./src/test/resources/data/spells");
		File[] files = directory.listFiles();
		List<Spell> spells = new ArrayList<>();
		long start = System.currentTimeMillis();
        assert files != null : "No files in directory " + directory.getAbsolutePath();
        for(File file : files){
			if(file.getName().contains(".json")){
				ObjectMapper mapper = new ObjectMapper();
				SimpleModule module = new SimpleModule();
				module.addDeserializer(Spells.class, new SpellsDeserializer());
				mapper.registerModule(module);

				spells.addAll(mapper.readValue(file, Spells.class).getSpells());
			}
		}
		long finish = System.currentTimeMillis();
		log.info(spells.size() + " spells have been read from " + files.length + " files in " + (finish - start) + " milliseconds.");

		for(Spell spell : spells){
			Context context = new Context();
			context.setVariable("spell", spell);
			ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
			templateResolver.setTemplateMode(TemplateMode.TEXT);
			templateResolver.setPrefix("templates/");
			templateResolver.setSuffix(".md");
			TemplateEngine templateEngine = new TemplateEngine();
			templateEngine.setTemplateResolver(templateResolver);
			File outputDirectory = new File(System.getProperty("user.home") + "/repos/dnd-5e-obsidian-wiki/wiki");
			String fileName = spell.getName();
			if(fileName.contains("/")){
				fileName = fileName.replace("/", " - ");
			}
			File outputFile = new File(outputDirectory, fileName + ".md");
			try{
				outputFile.createNewFile();
			} catch (IOException e){
				log.error(e.getMessage());
			}
			Writer writer = new FileWriter(outputFile);
			templateEngine.process("spell", context, writer);
		}

		// TODO: Write Services to ensure that all objects are saved in the correct order
		// e.g.: Save the Book before saving the Source before saving the spell
		// spellRepository.saveAll(spells);
	}
}
