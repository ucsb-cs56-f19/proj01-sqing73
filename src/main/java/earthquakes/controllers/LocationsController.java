package earthquakes.controllers;

import earthquakes.geojson.FeatureCollection;
import earthquakes.searches.LocSearch;
import earthquakes.services.EarthquakeQueryService;
import earthquakes.searches.EqSearch;
import earthquakes.services.LocationQueryService;

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

import com.nimbusds.oauth2.sdk.client.ClientReadRequest;

@Controller
public class LocationsController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/locations/search")
    public String getLocationSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
        return "locations/search";
    }

    @GetMapping("/locations/results")
    public String getLocationResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {

        LocationQueryService LQS = new LocationQueryService();

        model.addAttribute("locSearch", locSearch);
        String json = LQS.getJSON(locSearch.getLocation());
        model.addAttribute("json",json);
        return "locations/results";
    }
}