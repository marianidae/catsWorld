package org.softuni.catssss.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "breeds")
public class BreedsEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany
    private List<ModelEntity> models;

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
}
