package com.reimbursement.management_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.management_system.dto.ProductRequestDto;
import com.reimbursement.management_system.model.Product;
import com.reimbursement.management_system.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProducts(productRequestDto);
    }
    @GetMapping("/allproducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}