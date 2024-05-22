package com.louisbrinkmann.dnd5edatabase.repositories;

import com.louisbrinkmann.dnd5edatabase.models.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Integer> {
}
