package org.softuni.catssss.repository;



import org.softuni.catssss.model.entity.BreedsEntity;
import org.softuni.catssss.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    List<ModelEntity> findAllByBreedId (Long id);

}
