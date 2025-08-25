package com.Swiggy.food;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class SwiggyService {
	
    @Autowired
    SwiggyRepository repository;

    public ResponseEntity<Object> savefood(Food food) {
        repository.save(food);
        Map<String, Object> map = new HashMap<>();
        map.put("Message", "Order confirmed");
        map.put("Food", food);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getAllFoods() {
        List<Food> foods = repository.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    public ResponseEntity<Object> getFoodById(int id) {
        Optional<Food> food = repository.findById(id);
        if (food.isPresent()) {
            return new ResponseEntity<>(food.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Food not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> updateFood(int id, Food newFood) {
        Optional<Food> foodOptional = repository.findById(id);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.setHotel(newFood.getHotel());
            food.setDish(newFood.getDish());
            food.setQuantity(newFood.getQuantity());
            food.setPrice(newFood.getPrice());
            repository.save(food);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Food not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteFood(int id) {
        Optional<Food> food = repository.findById(id);
        if (food.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>("Food deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Food not found", HttpStatus.NOT_FOUND);
        }
    }
}
