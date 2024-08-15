package org.softuni.catssss.repository;

import org.softuni.catssss.model.entity.BreedsEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<BreedsEntity, Long> {

    @EntityGraph(
            value = "breedWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM BreedsEntity b")
    List<BreedsEntity> getAllBreeds();

}
