package com.example.KodeCraft_Backend.repository;

import com.example.KodeCraft_Backend.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
//    long countByReadFalse();
}
