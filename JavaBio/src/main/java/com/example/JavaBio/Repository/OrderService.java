package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.Request;

public interface OrderService {
    Request placeOrder(Request order);
}