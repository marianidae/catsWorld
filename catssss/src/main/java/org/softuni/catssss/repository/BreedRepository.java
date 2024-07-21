package org.softuni.catssss.repository;

import org.softuni.catssss.model.entity.BreedsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<BreedsEntity, Long> {
}
