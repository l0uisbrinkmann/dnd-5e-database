package com.louisbrinkmann.dnd5edatabase.services;

import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.repositories.SourceRepository;
import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SpellService {
    @Autowired
    SpellRepository spellRepository;
    @Autowired
    SourceRepository sourceRepository;

    public void save(Spell spell){
        try{
            sourceRepository.save(spell.getSource());
        } catch (Exception e){
            log.warn("Could not save source " + spell.getSource().toString(), e);
        }
        try{
            spellRepository.save(spell);
        } catch (Exception e){
            throw new RuntimeException("Could not save spell " + spell.toString());
        }
    }

    public List<Spell> findAll(){
        return spellRepository.findAll();
    }
}
