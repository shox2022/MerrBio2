package com.example.JavaBio.Service;

import com.example.JavaBio.Entity.Product;
import com.example.JavaBio.Repository.ProductRepository;
import com.example.JavaBio.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class ProductServiceImpl implements ProductRepository {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}