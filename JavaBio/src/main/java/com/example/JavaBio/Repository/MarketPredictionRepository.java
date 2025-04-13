package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.MarketPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPredictionRepository extends JpaRepository<MarketPrediction, Long> {
    // You can add custom query methods if needed, for example:
    // List<MarketPrediction> findByProductId(Integer productId);
}
