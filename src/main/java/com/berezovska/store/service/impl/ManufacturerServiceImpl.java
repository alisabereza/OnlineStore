package com.berezovska.store.service.impl;

import com.berezovska.store.controller.exception.ManufacturerAlreadyExistsException;
import com.berezovska.store.controller.exception.ManufacturerNotExistsException;
import com.berezovska.store.model.Manufacturer;
import com.berezovska.store.repository.ManufacturerRepository;
import com.berezovska.store.service.ManufacturerService;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public @Data
class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger LOG = LogManager.getLogger(ManufacturerServiceImpl.class);

    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public void setRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getAll() {
        LOG.debug("get All Manufacturers: ");
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getById(UUID id) {
        LOG.debug("get Manufacturer by ID: ");
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotExistsException(String.format("Manufacturer with id = %s not found", id)));
    }

    @Override
    public void save(Manufacturer entity) {
        LOG.debug("Saving Manufacturer: ");
        if (manufacturerRepository.findByName(entity.getName()).isPresent()) {
            throw new ManufacturerAlreadyExistsException("Manufacturer already exists: " + entity.getName());
        }
        manufacturerRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        LOG.debug("Deleting Manufacturer: ");
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Manufacturer update(Manufacturer entity) {
        LOG.debug("Updating Manufacturer: ");
        return manufacturerRepository.save(entity);
    }


    @Override
    public Manufacturer getByName(String name) {
        LOG.debug("gGet Manufacturer by Name: ");
        return manufacturerRepository.findByName(name)
                .orElseThrow(() -> new ManufacturerNotExistsException("Manufacturer not found "));
    }
}
