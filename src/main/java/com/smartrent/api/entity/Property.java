package com.smartrent.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property")
public class Property {
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    @Size(max = 100)
    private String address;

    @NotBlank
    @Column(nullable = false)
    @Size(max = 100)
    private String city;

    @NotNull
    @Column(nullable = false)
    private Double pricePerMonth;

    @NotNull
    @Column(nullable = false)
    private Double totalArea;

    @NotNull
    @Column(nullable = false)
    private Integer rooms;

    @NotNull
    @Column(nullable = false)
    private Boolean available;
}
