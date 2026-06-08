package com.smartrent.api.service;

import com.smartrent.api.dto.OwnerDto;
import com.smartrent.api.dto.PropertyResponseDto;
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

   public PropertyResponseDto save (Property property){
        Property saved = propertyRepository.save(property);
        return toDTO(saved);
   }

    public List<PropertyResponseDto> findAll (){
        return propertyRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public List<PropertyResponseDto> findByCity (String city){
        return propertyRepository.findByCity(city)
                .stream().map(this::toDTO)
                .toList();
    }

    public PropertyResponseDto findById(Long id){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        return toDTO(property);
    }

    private PropertyResponseDto toDTO (Property property){
        PropertyResponseDto dto = new PropertyResponseDto();
        dto.setId(property.getId());
        dto.setTitle(property.getTitle());
        dto.setDescription(property.getDescription());
        dto.setAddress(property.getAddress());
        dto.setCity(property.getCity());
        dto.setPricePerMonth(property.getPricePerMonth());
        dto.setTotalArea(property.getTotalArea());
        dto.setRooms(property.getRooms());
        dto.setAvailable(property.getAvailable());

        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(property.getOwner().getId());
        ownerDto.setName(property.getOwner().getName());
        ownerDto.setEmail(property.getOwner().getEmail());
        dto.setOwner(ownerDto);
        return dto;
    }

    public void delete (Long id){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        propertyRepository.delete(property);
    }

    public PropertyResponseDto update (Long id, Property updated ){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        property.setTitle(updated.getTitle());
        property.setDescription(updated.getDescription());
        property.setAddress(updated.getAddress());
        property.setCity(updated.getCity());
        property.setPricePerMonth(updated.getPricePerMonth());
        property.setTotalArea(updated.getTotalArea());
        property.setRooms(updated.getRooms());
        property.setAvailable(updated.getAvailable());
        return toDTO(propertyRepository.save(property));
    }
}
