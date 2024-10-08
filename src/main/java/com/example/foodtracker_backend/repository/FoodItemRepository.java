package com.example.foodtracker_backend.repository;

import com.example.foodtracker_backend.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    
    List<FoodItem> findByName(String name);

    List<FoodItem> findByNameContaining(String name);

    List<FoodItem> findByCaloriesLessThan(double calories);

    List<FoodItem> findByProteinGreaterThan(double protein);

    List<FoodItem> findByMealtime(String mealtime);
}
