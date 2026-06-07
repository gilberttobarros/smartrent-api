package com.smartrent.api.service;

import com.smartrent.api.entity.Property;
import com.smartrent.api.exception.ResourceNotFoundException;
import com.smartrent.api.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property save (Property property){
        return propertyRepository.save(property);
    }

    public List<Property> findAll (){
        return propertyRepository.findAll();
    }

    public Property findbyId(Long id){
        return propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }
}
