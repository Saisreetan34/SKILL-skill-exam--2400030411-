package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Restaurant;
import com.klef.soa.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    private RestaurantRepository repo;

    @Override
    public Restaurant addRestaurant(Restaurant r)
    {
        return repo.save(r);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant r)
    {
        Optional<Restaurant> optional = repo.findById(r.getRestaurantId());

        if(optional.isPresent())
        {
            Restaurant restaurant = optional.get();

            restaurant.setRestaurantName(r.getRestaurantName());
            restaurant.setCuisine(r.getCuisine());
            restaurant.setLocation(r.getLocation());
            restaurant.setRating(r.getRating());
            restaurant.setContactNumber(r.getContactNumber());

            return repo.save(restaurant);
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<Restaurant> displayAllRestaurants()
    {
        return repo.findAll();
    }

    @Override
    public Restaurant displayRestaurantById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteRestaurantById(Long id)
    {
        boolean flag = repo.existsById(id);

        if(flag)
        {
            repo.deleteById(id);
            return "Restaurant Deleted Successfully";
        }
        else
        {
            return "Restaurant ID Not Found";
        }
    }

    @Override
    public List<Restaurant> displayRestaurantByCuisine(String cuisine)
    {
        return repo.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> displayRestaurantByLocation(String location)
    {
        return repo.findByLocation(location);
    }

    @Override
    public Long restaurantCount()
    {
        return repo.count();
    }
}