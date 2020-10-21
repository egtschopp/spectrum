package us.etschopp.spectrum.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import us.etschopp.spectrum.domain.Restaurant;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RestaurantRepositoryIntegrationTest {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    public void setup() {
        CommandLineRunner runner = ctx.getBean(CommandLineRunner.class);
        try {
            runner.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertRecordsOnStart() {
        Page<Restaurant> restaurants = restaurantRepository.findAll(PageRequest.of(0, 10));
        assertEquals("getNumberOfElements count is not matching", 10, restaurants.getNumberOfElements());
        assertEquals("getTotalElements count is not matching", 38, Math.toIntExact(restaurants.getTotalElements()));
    }
}
