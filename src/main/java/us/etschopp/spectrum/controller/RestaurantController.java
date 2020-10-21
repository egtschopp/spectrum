package us.etschopp.spectrum.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.etschopp.spectrum.domain.Restaurant;
import us.etschopp.spectrum.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public Page<Restaurant> list(Pageable pageable) {
        return restaurantService.list(pageable);
    }

    @GetMapping("/search")
    public Page<Restaurant> findByNameLikeOrCityOrGenreLike(String name, String city, String genre, Pageable pageable)  {
        return restaurantService.findByNameLikeOrCityOrGenreLike(name, city, genre, pageable);
    }

}
