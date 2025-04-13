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

    // Represents the product ID for which this prediction is made.
    private Integer productId;

    // The start and end of the forecast period.
    private LocalDate forecastStart;
    private LocalDate forecastEnd;

    // The model output: predicted demand.
    private Integer predictedDemand;

    // For record-keeping, we store the price used during prediction.
    private Double predictedPrice;

    // The reference to the model training run that produced this prediction.
    private Integer modelRunId;

    // A measure of confidence in the prediction (e.g. percentage).
    private Double confidence;

    // The timestamp when the prediction was created. This is automatically set on insertion.
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

    // No setter for createdAt – it is set upon creation.
}
