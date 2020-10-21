package us.etschopp.spectrum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import us.etschopp.spectrum.domain.Restaurant;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, UUID> {
    Page<Restaurant> findByNameLikeOrCityOrGenreLike(String name, String city, String genre, Pageable pageable);
}
