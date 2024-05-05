package com.louisbrinkmann.dnd5edatabase.models.spells;

import com.louisbrinkmann.dnd5edatabase.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spell implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Source source;

    private Integer level;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private SchoolOfMagic school;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Duration castingTime;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Range castingRange;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Components components;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Duration effectDuration;

    private List<String> entries;

    @ManyToMany
    @JoinColumn(referencedColumnName = "id")
    private List<DamageType> damageTypes;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private SavingThrow savingThrow;

    public Spell(String name, Source source) {
        this.name = name;
        this.source = source;
    }
}
