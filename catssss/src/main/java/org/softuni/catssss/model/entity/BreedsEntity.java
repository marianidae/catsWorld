package org.softuni.catssss.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "breeds")
public class BreedsEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany
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
