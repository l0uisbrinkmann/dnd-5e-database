package com.louisbrinkmann.dnd5edatabase;
import com.louisbrinkmann.dnd5edatabase.models.*;
import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import com.louisbrinkmann.dnd5edatabase.services.SpellService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.*;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Dnd5eDatabaseApplication {
	private static SpellService spellService;

	@Autowired
	public Dnd5eDatabaseApplication(SpellService spellService) {
		this.spellService = spellService;
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Dnd5eDatabaseApplication.class, args);
		Source phbSource = new Source(SourceBook.PLAYERS_HANDBOOK, 150);
		Spell fireBall = Spell.builder()
				.name("Fireball")
				.level(3)
				.schoolOfMagic(SchoolOfMagic.EVOCATION)
				.castingTime("1 action")
				.range("150 feet")
				.verbal(true)
				.somatic(true)
				.material("a tiny ball of bat guano and sulfur")
				.duration("Instantaneous")
				.description("A bright streak flashes from your pointing finger to a point you choose within range and then blossoms with a low roar into an explosion of flame. Each creature in a 20-foot-radius sphere centered on that point must make a Dexterity saving throw. A target takes 8d6 fire damage on a failed save, or half as much damage on a successful one.\n" +
						"The fire spreads around corners. It ignites flammable objects in the area that aren't being worn or carried.")
				.higherLevelDescription("When you cast this spell using a spell slot of 4th level or higher, the damage increases by 1d6 for each slot level above 3rd.")
				.classes(List.of(RAWClass.SORCERER, RAWClass.WIZARD))
				.source(phbSource)
				.build();
		spellService.save(fireBall);
		List<Spell> spells = spellService.findAll();
		for(Spell s : spells){
			System.out.println(s.getName());
		}
	}
}
