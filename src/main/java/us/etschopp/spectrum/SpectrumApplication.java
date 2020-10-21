package us.etschopp.spectrum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import us.etschopp.spectrum.domain.Restaurant;
import us.etschopp.spectrum.service.RestaurantService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class SpectrumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpectrumApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RestaurantService restaurantService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Restaurant>> typeReference = new TypeReference<List<Restaurant>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/restaurantData.json");
			try {
				List<Restaurant> restaurants = mapper.readValue(inputStream,typeReference);
				restaurantService.save(restaurants);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

}
