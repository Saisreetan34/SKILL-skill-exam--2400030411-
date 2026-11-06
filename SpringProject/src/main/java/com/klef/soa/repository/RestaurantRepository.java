package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Restaurant;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

 
    List<Restaurant> findByCuisine(String cuisine);

  
    List<Restaurant> findByLocation(String location);

}