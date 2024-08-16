package com.example.foodtracker_backend.service;

import com.example.foodtracker_backend.model.FoodItem;
import com.example.foodtracker_backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    // Create or update a food item
    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    // Find all food items
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    // Find a food item by ID
    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    // Find food items by name
    public List<FoodItem> getFoodItemsByName(String name) {
        return foodItemRepository.findByName(name);
    }

    // Find food items by name containing a specific string
    public List<FoodItem> searchFoodItemsByName(String name) {
        return foodItemRepository.findByNameContaining(name);
    }

    // Find food items with calories less than a specific value
    public List<FoodItem> getFoodItemsByCaloriesLessThan(double calories) {
        return foodItemRepository.findByCaloriesLessThan(calories);
    }

    // Find food items with protein greater than a specific value
    public List<FoodItem> getFoodItemsByProteinGreaterThan(double protein) {
        return foodItemRepository.findByProteinGreaterThan(protein);
    }

    // Delete a food item by ID
    public void deleteFoodItemById(Long id) {
        foodItemRepository.deleteById(id);
    }
}
