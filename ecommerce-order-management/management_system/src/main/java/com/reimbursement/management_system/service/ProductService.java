package com.reimbursement.management_system.service;
import java.util.List;
import com.reimbursement.management_system.exception.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursement.management_system.dto.ProductRequestDto;
import com.reimbursement.management_system.dto.ProductResponseDto;
import com.reimbursement.management_system.model.Product;
import com.reimbursement.management_system.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProducts(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setStock(productRequestDto.getStock());
        product.setCategory(productRequestDto.getCategory());
        productRepository.save(product);
        return mapToResponse(product);
    }
    public ProductResponseDto mapToResponse(Product product){

        ProductResponseDto response = new ProductResponseDto();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategory(product.getCategory());
        return response;
    }
    public List<ProductResponseDto> getProducts(){
        return productRepository.findAll().stream().map(product -> mapToResponse(product)).toList();
    }
    public ProductResponseDto getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return mapToResponse(product);
    }

}