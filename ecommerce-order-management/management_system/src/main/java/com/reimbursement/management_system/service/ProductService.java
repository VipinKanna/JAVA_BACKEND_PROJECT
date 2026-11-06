package com.reimbursement.management_system.service;
import java.util.List;
import com.reimbursement.management_system.model.Product;
import com.reimbursement.management_system.dto.ProductRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.reimbursement.management_system.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> addProducts(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setStock(productRequestDto.getStock());
        product.setCategory(productRequestDto.getCategory());
        productRepository.save(product);
        return List.of(product);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}