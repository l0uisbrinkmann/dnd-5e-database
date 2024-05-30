package com.louisbrinkmann.dnd5edatabase.repositories;

import com.louisbrinkmann.dnd5edatabase.models.spells.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {
}
