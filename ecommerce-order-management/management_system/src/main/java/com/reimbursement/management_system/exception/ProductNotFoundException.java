package com.reimbursement.management_system.exception;

import com.reimbursement.management_system.model.Product;
import com.reimbursement.management_system.repository.ProductRepository;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}