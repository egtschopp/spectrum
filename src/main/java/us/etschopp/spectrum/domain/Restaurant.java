package us.etschopp.spectrum.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;
import java.util.UUID;

@Entity
@Data
public class Restaurant {
    @Id
    private UUID id;
    private String name;
    private String address1;
    private String city;
    private String state;
    private String zip;
    private String lat;
    @JsonProperty("long")
    private String lon;
    private String telephone;
    private String tags;
    private URL website;
    private String genre;
    private String hours;
    private String attire;
}
