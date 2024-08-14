package org.softuni.catssss.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.catssss.model.enums.GenderEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private String description;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    private String imageUrl;

    private BigDecimal price;

    private int age;


    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getAge() {
        return age;
    }

    public OfferEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public OfferEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
