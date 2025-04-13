package com.example.JavaBio.Controller;

import com.example.JavaBio.Entity.Product;
import com.example.JavaBio.Entity.Request;
import com.example.JavaBio.Repository.ProductRepository;
import com.example.JavaBio.Repository.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    private final ProductRepository productService;
    private final OrderService orderService;

    @Autowired
    public ConsumerController(ProductRepository productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    // Endpoint to retrieve available products for the consumer dashboard
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Endpoint to place a new order (create a Request)
    @PostMapping("/order")
    public ResponseEntity<Request> placeOrder(@RequestBody Request order){
        Request savedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
}