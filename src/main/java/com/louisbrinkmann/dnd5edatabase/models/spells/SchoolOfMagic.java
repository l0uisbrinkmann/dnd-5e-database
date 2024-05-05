package com.louisbrinkmann.dnd5edatabase.models.spells;

import com.louisbrinkmann.dnd5edatabase.models.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolOfMagic implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String abbreviation;

    @Column(unique = true)
    private String name;

    public SchoolOfMagic(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public SchoolOfMagic(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
}
