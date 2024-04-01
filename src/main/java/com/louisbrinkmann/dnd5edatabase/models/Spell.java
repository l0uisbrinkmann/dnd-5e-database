package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.*;

@Entity
public class Spell {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique=true)
    String name;
}
