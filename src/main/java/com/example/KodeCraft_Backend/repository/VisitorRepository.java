package com.example.KodeCraft_Backend.repository;

import com.example.KodeCraft_Backend.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @Query("SELECT COUNT(v) FROM Visitor v")
    long totalVisitors();

    @Query("SELECT COUNT(v) FROM Visitor v WHERE v.visitTime >= :time")
    long activeVisitors(@Param("time") LocalDateTime time);
}
