package com.louisbrinkmann.dnd5edatabase.models.spells;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private Integer level;
    @Builder.Default
    private Boolean srd = false;
    @NotNull
    private SchoolOfMagic schoolOfMagic;
    @NotNull
    private String castingTime;
    @NotNull
    private String range;
    @Builder.Default
    private Boolean verbal = false;
    @Builder.Default
    private Boolean somatic = false;
    private String material;
    @NotNull
    private String duration;
    @Builder.Default
    private Boolean concentration = false;
    @Lob
    @NotNull
    private String description;
    @Lob
    private String higherLevelDescription;
    @NotNull
    @ManyToOne
    private Source source;
}
