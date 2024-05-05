package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Column(unique = true)
    String abbreviation;

    @Setter
    @Column(unique = true)
    String name;

    public Book(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
