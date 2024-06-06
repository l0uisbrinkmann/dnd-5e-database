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
            log.warn("Could not save source " + spell.getSource().getBook() + " page " + spell.getSource().getPage(), e);
        }
        try{
            spellRepository.save(spell);
        } catch (Exception e){
            throw new RuntimeException("Could not save spell " + spell.getName());
        }
    }

    public void saveAll(List<Spell> spells){
        for(Spell s : spells){
            try{
                save(s);
            } catch (RuntimeException e){
                log.warn("Could not save spell " + s.getName());
            }
        }
    }

    public void updateOrInsertAll(List<Spell> spells){
        for(Spell s : spells){
            try{
                sourceRepository.save(s.getSource());
            } catch (Exception e){
                log.warn("Could not save source {} page {}", s.getSource().getBook(), s.getSource().getPage(), e);
            }
            try{
                updateOrInsert(s);
            } catch (Exception e){
                log.warn("Could not save nor update spell {}.", s.getName());
            }
        }
    }

    public void updateOrInsert(Spell spell){
        spellRepository.updateOrInsert(spell);
    }

    public List<Spell> findAll(){
        return spellRepository.findAll();
    }

    public Spell findByName(String name){
        return spellRepository.findByName(name);
    }

    public void deleteAll(){
        spellRepository.deleteAll();
    }
}
