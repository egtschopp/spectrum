package us.etschopp.spectrum.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import us.etschopp.spectrum.domain.Restaurant;
import us.etschopp.spectrum.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Page<Restaurant> list(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    public Page<Restaurant> findByNameLikeOrCityOrGenreLike(String name, String city, String genre, Pageable pageable) {
        return restaurantRepository.findByNameLikeOrCityOrGenreLike(name, city, genre, pageable);
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> save(List<Restaurant> restaurants) {
        return (List<Restaurant>) restaurantRepository.saveAll(restaurants);
    }

}
