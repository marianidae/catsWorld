package org.softuni.catssss.model.entity;

import jakarta.persistence.*;
import org.softuni.catssss.model.enums.TypeBreedEnum;


@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private TypeBreedEnum category;

    @ManyToOne
    private BreedsEntity breed;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public TypeBreedEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(TypeBreedEnum category) {
        this.category = category;
        return this;
    }

    public BreedsEntity getBreed() {
        return breed;
    }

    public ModelEntity setBreed(BreedsEntity breed) {
        this.breed = breed;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", breed=" + breed +
                '}';
    }
}
