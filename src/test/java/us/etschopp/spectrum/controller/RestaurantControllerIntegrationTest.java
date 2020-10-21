package us.etschopp.spectrum.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantControllerIntegrationTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetRestaurants() {

        String expected = "{\"content\":[{\"id\":\"651628a1-9cea-4755-ac68-eaed5a0bb188\"" +
                ",\"name\":\"A Chef's Kitchen\",\"address1\":\"501 Prince George St\",\"city\":\"Williamsburg\"" +
                ",\"state\":\"VA\",\"zip\":\"23185\",\"lat\":\"37.272483\",\"telephone\":\"(757) 564-8500\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,American,Social,Food and Dining,Restaurants,Seafood\"" +
                ",\"website\":\"http://www.achefskitchen.biz\",\"genre\":\"American,Seafood,International,Asian,Cafe\"" +
                ",\"hours\":\"Tue-Sat 10:00 AM-5:30 PM\",\"attire\":\"business casual\",\"long\":\"-76.707708\"},{\"id\"" +
                ":\"0491b590-5bc4-4899-957a-4659d01b1049\",\"name\":\"Angelo's 677 Prime\",\"address1\":\"677 Broadway\"" +
                ",\"city\":\"Albany\",\"state\":\"NY\",\"zip\":\"12207\",\"lat\":\"42.653271\"" +
                ",\"telephone\":\"(518) 427-7463\"," +
                "\"tags\":\"Social,Food and Dining,Restaurants,Steakhouses,Social,Food and Dining,Restaurants,Seafood,Social,Food and Dining,Restaurants,American\"" +
                ",\"website\":\"http://www.677prime.com\",\"genre\":\"Steak,American,Seafood,International,Traditional\"" +
                ",\"hours\":\"Mon-Fri 11:30 AM-10:00 PM; Sat 5:30 PM-10:00 PM\",\"attire\":\"business casual\"" +
                ",\"long\":\"-73.748583\"},{\"id\":\"b7f72b56-3c89-4d45-9d70-f88d0db62db1\"" +
                ",\"name\":\"Antoine's Restaurant\",\"address1\":\"1100 N Tuttle Ave\",\"city\":\"Sarasota\"" +
                ",\"state\":\"FL\",\"zip\":\"34237\",\"lat\":\"27.347534\",\"telephone\":\"(941) 331-1400\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,French,Social,Food and Dining,Restaurants,Seafood,Social,Food and Dining,Restaurants,International\"" +
                ",\"website\":\"http://www.antoinessarasota.com\",\"genre\":\"European,French,Seafood,Belgian,Vegetarian\"" +
                ",\"hours\":\"Mon-Sat 5:00 PM-9:00 PM\",\"attire\":\"casual\",\"long\":\"-82.513303\"}" +
                ",{\"id\":\"02d3bff4-9381-4abf-914e-787bd6ecc099\",\"name\":\"Artisanal Restaurant\"" +
                ",\"address1\":\"1200 Dobbins Rd\",\"city\":\"Banner Elk\",\"state\":\"NC\",\"zip\":\"28604\"" +
                ",\"lat\":\"36.15378\",\"telephone\":\"(828) 898-5395\",\"tags\":\"Social,Food and Dining,Restaurants,American\"" +
                ",\"website\":\"http://www.artisanalnc.com\",\"genre\":\"American,Contemporary\"" +
                ",\"hours\":\"Tue-Sun 5:30 PM-10:00 PM\",\"attire\":\"business casual\",\"long\":\"-81.840418\"}" +
                ",{\"id\":\"cd273a24-f8de-44f6-8add-028e22229293\",\"name\":\"Boston Lobster Feast\"" +
                ",\"address1\":\"8731 International Dr\",\"city\":\"Orlando\",\"state\":\"FL\",\"zip\":\"32819\"," +
                "\"lat\":\"28.43897\",\"telephone\":\"(407) 248-8606\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,Seafood,Social,Food and Dining,Restaurants,American\"" +
                ",\"website\":\"http://www.bostonlobsterfeast.com\",\"genre\":\"Seafood,International,American,Oysters,Cafe\"" +
                ",\"hours\":\"Mon-Fri 4:00 PM-10:00 PM; Sat-Sun 2:00 PM-10:00 PM\",\"attire\":\"Casual\"" +
                ",\"long\":\"-81.470707\"},{\"id\":\"06e48e5a-6af2-4a04-97dd-fbf61ef46dd6\",\"name\":\"Byrd & Baldwin Bros Steakhouse\"" +
                ",\"address1\":\"116 Brooke Ave\",\"city\":\"Norfolk\",\"state\":\"VA\",\"zip\":\"23510\",\"lat\":\"36.848861\"" +
                ",\"telephone\":\"(757) 222-9191\",\"tags\":\"Social,Food and Dining,Restaurants\",\"website\":\"https://www.byrdbaldwin.com/\"" +
                ",\"genre\":\"Steak\",\"hours\":\"Mon-Thu 5:00 PM-9:30 PM; Fri-Sat 5:00 PM-10:30 PM; Sun 5:00 PM-8:30 PM\"" +
                ",\"attire\":\"business casual\",\"long\":\"-76.291773\"},{\"id\":\"8a936f27-bcf4-485b-9522-219451bc8cec\"" +
                ",\"name\":\"Cafe Cimino Country Inn\",\"address1\":\"616 Main St\",\"city\":\"Sutton\",\"state\":\"WV\"" +
                ",\"zip\":\"26601\",\"lat\":\"38.663967\",\"telephone\":\"(304) 765-2913\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,Italian,Social,Food and Dining,Cafes,Coffee and Tea Houses\"" +
                ",\"website\":\"http://www.cafeciminocountryinn.com\",\"genre\":\"Cafe,Italian,Bistro,Contemporary,Vegetarian\"" +
                ",\"hours\":\"Tue 4:00 PM-9:00 PM; Wed-Sat 5:00 PM-9:00 PM\",\"attire\":\"business casual\"" +
                ",\"long\":\"-80.704248\"},{\"id\":\"ff31ea3b-01e4-4047-8210-d2935322771e\",\"name\":\"Chatham's Place\"" +
                ",\"address1\":\"7575 Dr Phillips Blvd\",\"city\":\"Orlando\",\"state\":\"FL\",\"zip\":\"32819\"" +
                ",\"lat\":\"28.451837\",\"telephone\":\"(407) 345-2992\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,American,Social,Food and Dining,Restaurants,French,Social,Food and Dining,Restaurants,International\"" +
                ",\"website\":\"http://www.chathamsplace.com\",\"genre\":\"American,Traditional,Continental,European,Italian\"" +
                ",\"hours\":\"Open Daily 5:30 PM-10:00 PM\",\"attire\":\"business casual\",\"long\":\"-81.487498\"}" +
                ",{\"id\":\"3fc229de-37a2-4435-8d8b-bb241e95f70f\",\"name\":\"Company of the Cauldron\",\"address1\":\"5 India St\"," +
                "\"city\":\"Nantucket\",\"state\":\"MA\",\"zip\":\"02554\",\"lat\":\"41.284056\",\"telephone\":\"(508) 228-4016\"," +
                "\"tags\":\"Social,Food and Dining,Restaurants,American,Social,Food and Dining,Restaurants,French\"" +
                ",\"website\":\"http://www.companyofthecauldron.com\",\"genre\":\"American,Contemporary,Seafood,Continental,Traditional\"" +
                ",\"hours\":\"Mon 7:00 PM-10:00 PM; Tue-Sat 6:00 PM-11:00 PM; Sun 7:00 PM-10:00 PM\",\"attire\":\"business casual\"" +
                ",\"long\":\"-70.099552\"},{\"id\":\"9ebb46cd-d4db-4a31-b3a9-dfe41b6c329f\",\"name\":\"Earth\",\"address1\":\"354 Goose Rocks Rd\"" +
                ",\"city\":\"Kennebunkport\",\"state\":\"ME\",\"zip\":\"04046\",\"lat\":\"43.413001\",\"telephone\":\"(207) 967-6550\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,American,Social,Bars\",\"website\":\"http://www.earthathiddenpond.com\"" +
                ",\"genre\":\"American,Contemporary\",\"hours\":\"Open Daily 5:30 PM-9:30 PM\",\"attire\":\"Casual\",\"long\":\"-70.428904\"}]" +
                ",\"pageable\":{\"sort\":{\"unsorted\":false,\"sorted\":true,\"empty\":false},\"offset\":0,\"pageNumber\":0," +
                "\"pageSize\":10,\"paged\":true,\"unpaged\":false},\"totalPages\":4,\"totalElements\":38,\"last\":false," +
                "\"number\":0,\"size\":10,\"sort\":{\"unsorted\":false,\"sorted\":true,\"empty\":false},\"numberOfElements\":10,\"first\":true,\"empty\":false}";

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/restaurants")
                    .param("size", "10")
                    .param("sort", "name,asc"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(expected))
                    .andReturn();

            logger.debug("results: ".concat(result.getResponse().getContentAsString()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    void testGetRestaurantsByName() {

        String expected = "{\"content\":[{\"id\":\"0491b590-5bc4-4899-957a-4659d01b1049\",\"name\":\"Angelo's 677 Prime\"" +
                ",\"address1\":\"677 Broadway\",\"city\":\"Albany\",\"state\":\"NY\",\"zip\":\"12207\",\"lat\":\"42.653271\"" +
                ",\"telephone\":\"(518) 427-7463\"" +
                ",\"tags\":\"Social,Food and Dining,Restaurants,Steakhouses,Social,Food and Dining,Restaurants,Seafood,Social,Food and Dining,Restaurants,American\"" +
                ",\"website\":\"http://www.677prime.com\",\"genre\":\"Steak,American,Seafood,International,Traditional\"" +
                ",\"hours\":\"Mon-Fri 11:30 AM-10:00 PM; Sat 5:30 PM-10:00 PM\",\"attire\":\"business casual\"" +
                ",\"long\":\"-73.748583\"}],\"pageable\":{\"sort\":{\"unsorted\":false,\"sorted\":true,\"empty\":false}" +
                ",\"offset\":0,\"pageSize\":10,\"pageNumber\":0,\"unpaged\":false,\"paged\":true},\"totalPages\":1" +
                ",\"totalElements\":1,\"last\":true,\"number\":0,\"size\":10,\"sort\":{\"unsorted\":false,\"sorted\":true" +
                ",\"empty\":false},\"numberOfElements\":1,\"first\":true,\"empty\":false}";

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/restaurants/search")
                    .param("name", "Angelo's 677 Prime")
                    .param("size", "10")
                    .param("sort", "name,asc"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(expected))
                    .andReturn();

            logger.debug("results: ".concat(result.getResponse().getContentAsString()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
