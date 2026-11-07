package com.reimbursement.management_system.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.management_system.dto.ProductRequestDto;
import com.reimbursement.management_system.dto.ProductResponseDto;
import com.reimbursement.management_system.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @PostMapping("/addproducts")
    public ProductResponseDto addProducts(@Valid @RequestBody ProductRequestDto productRequestDto) {
        return productService.addProducts(productRequestDto);
    }
    @GetMapping("/allproducts")
    public List<ProductResponseDto> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/productbyid/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
}