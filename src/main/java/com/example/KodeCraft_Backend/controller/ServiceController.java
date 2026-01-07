package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ServiceItem;
import com.example.KodeCraft_Backend.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceItemService service;

    @GetMapping
    public List<ServiceItem> getServices() {
        return service.getActiveServices();
    }
}
