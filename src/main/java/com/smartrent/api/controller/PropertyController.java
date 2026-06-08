package com.smartrent.api.controller;

import com.smartrent.api.dto.PropertyResponseDto;
import com.smartrent.api.entity.Property;
import com.smartrent.api.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public PropertyResponseDto save (@Valid @RequestBody Property property){
        return propertyService.save(property);
    }

    @GetMapping
    public List<PropertyResponseDto> findAll (){
        return propertyService.findAll();
    }

    @GetMapping("/{id}")
    public PropertyResponseDto findById (@PathVariable Long id){
        return propertyService.findById(id);
    }

    @GetMapping("/search")
    public List<PropertyResponseDto> findByCity (@RequestParam String city){
        return propertyService.findByCity(city);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        propertyService.delete(id);
    }

    @PutMapping("/{id}")
    public PropertyResponseDto update (@PathVariable Long id, @Valid @RequestBody Property property){
        return propertyService.update(id, property);
    }
}
