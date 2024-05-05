package com.louisbrinkmann.dnd5edatabase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Duration implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private DurationType type;

    private Integer amount;

    public Duration(DurationType type, Integer amount) {
        this.type = type;
        this.amount = amount;
    }
}
