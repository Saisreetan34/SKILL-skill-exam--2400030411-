package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Restaurant;
import com.klef.soa.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController
{
    @Autowired
    private RestaurantService service;

    @GetMapping("/")
    public String demo()
    {
        return "Spring Boot Restaurant Project";
    }

    // Add Restaurant
    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant r)
    {
        Restaurant restaurant = service.addRestaurant(r);
        return ResponseEntity.status(201).body(restaurant);
    }

    // Display All Restaurants
    @GetMapping("/displayall")
    public ResponseEntity<List<Restaurant>> displayAllRestaurants()
    {
        List<Restaurant> restaurants = service.displayAllRestaurants();
        return ResponseEntity.status(200).body(restaurants);
    }

    // Display Restaurant By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayRestaurantById(@RequestParam Long id)
    {
        Restaurant restaurant = service.displayRestaurantById(id);

        if (restaurant != null)
        {
            return ResponseEntity.status(200).body(restaurant);
        }
        else
        {
            return ResponseEntity.status(404).body("Restaurant ID Not Found");
        }
    }

    // Update Restaurant
    @PutMapping("/update")
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant)
    {
        Restaurant r = service.updateRestaurant(restaurant);

        if (r != null)
        {
            return ResponseEntity.ok(r);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant ID Not Found");
        }
    }

    // Delete Restaurant By ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestaurantById(@PathVariable Long id)
    {
        String message = service.deleteRestaurantById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Display Restaurants By Cuisine
    @GetMapping("/displaybycuisine/{cuisine}")
    public ResponseEntity<List<Restaurant>> displayRestaurantsByCuisine(@PathVariable String cuisine)
    {
        List<Restaurant> restaurants = service.displayRestaurantByCuisine(cuisine);
        return ResponseEntity.status(200).body(restaurants);
    }

    // Display Restaurants By Location
    @GetMapping("/displaybylocation/{location}")
    public ResponseEntity<List<Restaurant>> displayRestaurantsByLocation(@PathVariable String location)
    {
        List<Restaurant> restaurants = service.displayRestaurantByLocation(location);
        return ResponseEntity.status(200).body(restaurants);
    }

    // Restaurant Count 
    @GetMapping("/count")
    public ResponseEntity<String> restaurantCount() 
    {
        Long count = service.restaurantCount();
        String msg = "Total Restaurants = " + count;
        return ResponseEntity.ok(msg);
    }

}