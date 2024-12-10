package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    Cookie findCookieByName(String name);

    @Query(nativeQuery = true, value = "select max(id) from cookie")
    Long findMaxId();

}
