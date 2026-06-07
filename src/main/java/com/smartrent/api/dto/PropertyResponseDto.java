package com.smartrent.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyResponseDto {
    private Long id;
    private String title;
    private String description;
    private String address;
    private String city;
    private Double pricePerMonth;
    private Double totalArea;
    private Integer rooms;
    private Boolean available;
    private OwnerDto owner;
}
