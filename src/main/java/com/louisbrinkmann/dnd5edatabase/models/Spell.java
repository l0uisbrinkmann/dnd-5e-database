package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Getter
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
    private Boolean verbal = false;
    private Boolean somatic = false;
    private String material = "";
    private String duration;
    private Boolean concentration = false;
    @Lob
    private String description;
    @Lob
    private String higherLevelDescription;
    private List<RAWClass> classes;
    @ManyToOne
    private Source source;
}
