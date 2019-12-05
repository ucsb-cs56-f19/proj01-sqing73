package earthquakes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.nimbusds.oauth2.sdk.client.ClientReadRequest;

import earthquakes.entities.*;
import earthquakes.repositories.*;
import earthquakes.geojson.FeatureCollection;
import earthquakes.searches.LocSearch;
import earthquakes.services.EarthquakeQueryService;
import earthquakes.searches.EqSearch;
import earthquakes.services.LocationQueryService;
import earthquakes.osm.Place;
@Controller
public class LocationsController {
    private LocationRepository locationRepository;

    //@Autowired
    //private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    public LocationsController (LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @GetMapping("/locations/search")
    public String getLocationSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
        return "locations/search";
    }

    @GetMapping("/locations/results")
    public String getLocationResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {

        LocationQueryService l = new LocationQueryService();

        model.addAttribute("locSearch", locSearch);
        String json = l.getJSON(locSearch.getLocation());
        model.addAttribute("json",json);
        List<Place> Places = Place.listFromJson(json);
        model.addAttribute("Places", Places);
        return "locations/results";
    }

    @GetMapping("/locations")
    public String index(Model model) {
        Iterable<Location> locations= locationRepository.findAll();
        model.addAttribute("locations", locations);
        return "locations/index";
    }
}