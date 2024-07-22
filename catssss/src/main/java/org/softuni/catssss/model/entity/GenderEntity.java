package org.softuni.catssss.model.entity;

import jakarta.persistence.*;
import org.softuni.catssss.model.enums.GenderEnum;

@Entity
@Table(name = "genders")
public class GenderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne
    private BreedsEntity breeds;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public GenderEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public GenderEntity setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public BreedsEntity getBreeds() {
        return breeds;
    }

    public GenderEntity setBreeds(BreedsEntity breeds) {
        this.breeds = breeds;
        return this;
    }
}
