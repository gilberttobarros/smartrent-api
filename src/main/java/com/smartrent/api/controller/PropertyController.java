package com.smartrent.api.controller;

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
    public Property save (@Valid @RequestBody Property property){
        return propertyService.save(property);
    }

    @GetMapping
    public List<Property> findAll (){
        return propertyService.findAll();
    }

    @GetMapping("/{id}")
    public Property findById (@PathVariable Long id){
        return propertyService.findbyId(id);
    }
}
