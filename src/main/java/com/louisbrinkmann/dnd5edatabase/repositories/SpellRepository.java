package com.louisbrinkmann.dnd5edatabase.repositories;

import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Integer> {
    public Spell findByName(String name);
    @Transactional
    default void updateOrInsert(Spell spell){
        save(spell);
    }
}
