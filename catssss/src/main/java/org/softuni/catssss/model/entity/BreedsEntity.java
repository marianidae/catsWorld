package org.softuni.catssss.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "breeds")
@NamedEntityGraph(
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class BreedsEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "breed")
    private List<ModelEntity> models;

    @OneToMany
    private List<GenderEntity> gender;

    public String getName() {
        return name;
    }

    public BreedsEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BreedsEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }

    public List<GenderEntity> getGender() {
        return gender;
    }

    public BreedsEntity setGender(List<GenderEntity> gender) {
        this.gender = gender;
        return this;
    }
}
