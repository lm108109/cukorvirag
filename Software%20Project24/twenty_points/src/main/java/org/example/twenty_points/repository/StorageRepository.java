package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    Storage findByIngredientName(String name);

    @Query(nativeQuery = true, value = "select max(id) from users")
    Long findMaxId();
}
