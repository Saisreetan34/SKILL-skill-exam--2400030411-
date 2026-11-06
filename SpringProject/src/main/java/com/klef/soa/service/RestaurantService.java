package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Restaurant;

public interface RestaurantService
{
    Restaurant addRestaurant(Restaurant r);
    Restaurant updateRestaurant(Restaurant r);
    List<Restaurant> displayAllRestaurants();

    Restaurant displayRestaurantById(Long id);

    String deleteRestaurantById(Long id);

    List<Restaurant> displayRestaurantByCuisine(String cuisine);

    List<Restaurant> displayRestaurantByLocation(String location);

    Long restaurantCount();
}