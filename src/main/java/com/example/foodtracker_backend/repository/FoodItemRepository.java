package com.example.foodtracker_backend.repository;

import com.example.foodtracker_backend.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    
    // Custom query methods
    
    // Find by name
    List<FoodItem> findByName(String name);

    // Find by name containing a specific string (for search functionality)
    List<FoodItem> findByNameContaining(String name);

    // Find by calories less than a specific value
    List<FoodItem> findByCaloriesLessThan(double calories);

    // Find by protein greater than a specific value
    List<FoodItem> findByProteinGreaterThan(double protein);
}
