package com.example.foodtracker_backend.controller;

import com.example.foodtracker_backend.model.FoodItem;
import com.example.foodtracker_backend.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    // Create or update a food item
    @PostMapping
    public ResponseEntity<FoodItem> createOrUpdateFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem savedFoodItem = foodItemService.saveFoodItem(foodItem);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.OK);
    }

    // Get all food items
    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    // Get a food item by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
        return foodItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Search food items by name
    @GetMapping("/search")
    public ResponseEntity<List<FoodItem>> searchFoodItemsByName(@RequestParam String name) {
        List<FoodItem> foodItems = foodItemService.searchFoodItemsByName(name);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    // Get food items by calories less than a specific value
    @GetMapping("/calories")
    public ResponseEntity<List<FoodItem>> getFoodItemsByCaloriesLessThan(@RequestParam double calories) {
        List<FoodItem> foodItems = foodItemService.getFoodItemsByCaloriesLessThan(calories);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    // Get food items by protein greater than a specific value
    @GetMapping("/protein")
    public ResponseEntity<List<FoodItem>> getFoodItemsByProteinGreaterThan(@RequestParam double protein) {
        List<FoodItem> foodItems = foodItemService.getFoodItemsByProteinGreaterThan(protein);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    // Delete a food item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItemById(@PathVariable Long id) {
        foodItemService.deleteFoodItemById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
