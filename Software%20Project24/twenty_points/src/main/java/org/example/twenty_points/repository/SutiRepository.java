package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.Suti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SutiRepository extends JpaRepository<Suti, Long> {

    Suti findSutiByName(String name);

    @Query(nativeQuery = true, value = "select max(id) from cookie")
    Long findMaxId();

}
