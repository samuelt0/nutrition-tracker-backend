package com.example.foodtracker_backend.controller;

import com.example.foodtracker_backend.model.FoodItem;
import com.example.foodtracker_backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @PostMapping
    public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }
}
