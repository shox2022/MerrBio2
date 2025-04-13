package com.example.JavaBio.Service;

import com.example.JavaBio.Entity.Product;
import com.example.JavaBio.Entity.Request;
import com.example.JavaBio.Repository.OrderService;
import com.example.JavaBio.Repository.ProductRepository;
import com.example.JavaBio.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public  class OrderServiceImpl implements OrderService {

    private final RequestRepository requestRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(RequestRepository requestRepository, ProductRepository productRepository) {
        this.requestRepository = requestRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Request placeOrder(Request order){
        // Validate that the requested product exists
        Optional<Product> productOpt = productRepository.findById(order.getProductId());
        if (!productOpt.isPresent()){
            throw new RuntimeException("Product with ID " + order.getProductId() + " not found.");
        }
        // Set the order status and timestamp appropriately
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        return requestRepository.save(order);
    }
}