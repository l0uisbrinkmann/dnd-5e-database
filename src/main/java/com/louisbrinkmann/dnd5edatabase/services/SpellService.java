package com.louisbrinkmann.dnd5edatabase.services;

import com.louisbrinkmann.dnd5edatabase.models.Spell;
import com.louisbrinkmann.dnd5edatabase.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {
    @Autowired
    private SpellRepository spellRepository;

    public List<Spell> getAll() {
        return spellRepository.findAll();
    }
}
