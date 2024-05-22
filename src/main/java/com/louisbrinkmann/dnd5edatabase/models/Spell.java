package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer level;
    private SchoolOfMagic schoolOfMagic;
    private String castingTime;
    private String range;
    private Boolean verbal;
    private Boolean somatic;
    private String material;
    private String duration;
    private Boolean concentration;
    private String description;
    private String higherLevelDescription;
    private List<RAWClass> classes;
    private Source source;
}
