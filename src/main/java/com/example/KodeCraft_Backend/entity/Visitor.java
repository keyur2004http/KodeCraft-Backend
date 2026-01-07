package com.example.KodeCraft_Backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;
    private String page;
    private String device;
    private String browser;

    private LocalDateTime visitTime;
}
