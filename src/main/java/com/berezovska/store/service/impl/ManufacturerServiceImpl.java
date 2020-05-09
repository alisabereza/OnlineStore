package com.berezovska.store.service.impl;

import com.berezovska.store.model.Manufacturer;
import com.berezovska.store.repository.ManufacturerRepository;
import com.berezovska.store.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAll() {
       return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getById(UUID id) {
        return manufacturerRepository.getOne(id);
    }

    @Override
    public void save(Manufacturer entity) {
        manufacturerRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Manufacturer update(Manufacturer entity) {
        return manufacturerRepository.save(entity);
    }
}
