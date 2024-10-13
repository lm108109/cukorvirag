package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true, value = "select count(*)>0 from users where username= :username and id!= :id")
    boolean isUsedTheUsername(String username, long id);

    boolean existsByUsername(String username);

    @Query(nativeQuery = true, value = "select max(id) from users")
    Long findMaxId();

}
