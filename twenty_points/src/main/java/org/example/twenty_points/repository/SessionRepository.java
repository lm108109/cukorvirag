package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(nativeQuery = true, value = "select * from sessions where id = :sessionId and expiration_date > NOW()")
    Optional<Session> getSessionById(@Param("sessionId") Long sessionId);

    @Query(nativeQuery = true, value = "select * from sessions where user_id = :userId order by expiration_date desc limit 1")
    Optional<Session> getLastSessionUserId(@Param("userId") Long sessionId);
}
