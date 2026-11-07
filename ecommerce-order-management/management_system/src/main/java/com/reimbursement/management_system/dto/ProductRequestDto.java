package com.reimbursement.management_system.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message="name must needed")
    private String name;

    @NotBlank(message="description must needed")
    private String description;

    @NotNull(message="price must needed")
    @Positive(message="price must be positive")
    private Double price;

    @NotNull(message="stock must needed")
    @PositiveOrZero(message="stock must be positive or zero")
    private Long stock;
    
    @NotBlank(message="category must needed")
    private String category;

}