package com.example.JavaBio.Controller;

import com.example.JavaBio.Entity.MarketPrediction;
import com.example.JavaBio.Repository.MarketPredictionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MarketTrendController {

    private final MarketPredictionRepository predictionRepository;

    public MarketTrendController(MarketPredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    @GetMapping("/market-trends")
    public String showMarketTrends(Model model) {
        // Fetch all market predictions from the shared database.
        // You can also add filters (e.g., only show predictions for the next week) if needed.
        List<MarketPrediction> marketTrends = predictionRepository.findAll();
        model.addAttribute("marketTrends", marketTrends);
        // Return the name of the Thymeleaf template that will render this data.
        return "market-trends";  // This expects a template file 'market-trends.html'
    }
}
