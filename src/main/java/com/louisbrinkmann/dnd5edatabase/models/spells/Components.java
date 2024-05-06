package com.louisbrinkmann.dnd5edatabase.models.spells;

import com.louisbrinkmann.dnd5edatabase.models.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Components implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean verbal;

    private Boolean somatic;

    private String material;

    public Components(Boolean verbal, Boolean somatic, String material) {
        this.verbal = verbal;
        this.somatic = somatic;
        this.material = material;
    }
}
