package com.reimbursement.management_system.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String description;
    private Double price;
    private Long stock;
    private String category;

}