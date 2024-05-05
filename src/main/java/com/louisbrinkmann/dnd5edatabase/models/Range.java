package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Range implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Distance distance;

    public Range(String type, Distance distance) {
        this.type = type;
        this.distance = distance;
    }
}
