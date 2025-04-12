package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
