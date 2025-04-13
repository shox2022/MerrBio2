package com.example.JavaBio.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "market_predictions", schema = "ai_schema")
public class MarketPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    // The product ID for which the prediction is made
    private Integer productId;

    // The forecast period
    private LocalDate forecastStart;
    private LocalDate forecastEnd;

    // Model output: predicted demand (units sold)
    private Integer predictedDemand;

    // Price used for prediction (typically, the current product price)
    private Double predictedPrice;

    // Reference to the model training run that produced this prediction
    private Integer modelRunId;

    // Confidence level (e.g., a percentage)
    private Double confidence;

    // Automatically set timestamp on insertion
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters

    public Long getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Long predictionId) {
        this.predictionId = predictionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDate getForecastStart() {
        return forecastStart;
    }

    public void setForecastStart(LocalDate forecastStart) {
        this.forecastStart = forecastStart;
    }

    public LocalDate getForecastEnd() {
        return forecastEnd;
    }

    public void setForecastEnd(LocalDate forecastEnd) {
        this.forecastEnd = forecastEnd;
    }

    public Integer getPredictedDemand() {
        return predictedDemand;
    }

    public void setPredictedDemand(Integer predictedDemand) {
        this.predictedDemand = predictedDemand;
    }

    public Double getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(Double predictedPrice) {
        this.predictedPrice = predictedPrice;
    }

    public Integer getModelRunId() {
        return modelRunId;
    }

    public void setModelRunId(Integer modelRunId) {
        this.modelRunId = modelRunId;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}