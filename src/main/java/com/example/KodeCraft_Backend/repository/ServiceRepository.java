package com.example.KodeCraft_Backend.repository;

import com.example.KodeCraft_Backend.entity.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceItem, Long> {
    List<ServiceItem> findByActiveTrueOrderByPositionAsc();
}
