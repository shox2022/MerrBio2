package com.example.JavaBio.Controller;

import com.example.JavaBio.Entity.MarketPrediction;
import com.example.JavaBio.Repository.MarketPredictionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MarketTrendController {

    private final MarketPredictionRepository predictionRepository;
    private final ObjectMapper objectMapper;

    public MarketTrendController(MarketPredictionRepository predictionRepository, ObjectMapper objectMapper) {
        this.predictionRepository = predictionRepository;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/market-trends")
    public String showMarketTrends(Model model) throws JsonProcessingException {
        // Fetch all predictions; you may choose to filter for current/future predictions
        List<MarketPrediction> marketTrends = predictionRepository.findAll();
        // Convert the list to JSON so it can be used in JavaScript
        String marketTrendsJson = objectMapper.writeValueAsString(marketTrends);
        model.addAttribute("marketTrendsJson", marketTrendsJson);
        // Return the name of the Thymeleaf template to render (e.g., market-trends.html)
        return "market-trends";
    }
}