package com.example.KodeCraft_Backend.service;

import com.example.KodeCraft_Backend.entity.ServiceItem;
import com.example.KodeCraft_Backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItemService {

    @Autowired
    private ServiceRepository repository;

    public List<ServiceItem> getActiveServices() {
        return repository.findByActiveTrueOrderByPositionAsc();
    }

}

