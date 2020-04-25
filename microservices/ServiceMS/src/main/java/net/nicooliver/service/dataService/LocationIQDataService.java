package net.nicooliver.service.dataService;

import net.nicooliver.service.data.location.AddressResource;
import net.nicooliver.service.data.location.LocationResource;
import net.nicooliver.service.data.location.LongitudeLatitude;
import net.nicooliver.service.exception.LocationBadRequestException;
import net.nicooliver.service.exception.LocationNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocationIQDataService {
    private static final String LOCATION_IQ_URL_SEARCH =
            "https://eu1.locationiq.com/v1/search.php?key={apiKey}&q={searchString}&format=json";
    private static final String LOCATION_IQ_URL_REVERSE =
            "https://eu1.locationiq.com/v1/reverse.php?key={apiKey}&lat={latitude}&lon={longitude}&format=json";
    private static final String API_KEY = "c74cf32b538d43";

    public LongitudeLatitude getLongitudeLatitudeByAddress(String address) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();
        vars.put("apiKey", API_KEY);
        vars.put("searchString", address);
        try{
            ResponseEntity<LocationResource[]> response =
                    restTemplate.getForEntity(LOCATION_IQ_URL_SEARCH, LocationResource[].class, vars);
            LongitudeLatitude result = new LongitudeLatitude();
            LocationResource[] locations = response.getBody();
            result.setLongitude(locations[0].getLon());
            result.setLatitude(locations[0].getLat());
            return result;
        } catch (RestClientResponseException e) {
            if(e.getRawStatusCode() == 400) {
                throw new LocationNotFoundException("Location was not found");
            } else if(e.getRawStatusCode() == 429) {
                return getLongitudeLatitudeByAddress(address);
            } else {
                throw new LocationBadRequestException(e.getResponseBodyAsString());
            }
        }
    }

    public String getAddress(String longitude, String latitude) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("apiKey", API_KEY);
        vars.put("latitude", latitude);
        vars.put("longitude", longitude);
        try{
            ResponseEntity<AddressResource> response =
                    restTemplate.getForEntity(LOCATION_IQ_URL_REVERSE, AddressResource.class, vars);
            AddressResource addressResource = response.getBody();
            return addressResource.getDisplay_name();
        } catch (RestClientResponseException e) {
            if(e.getRawStatusCode() == 400) {
                throw new LocationNotFoundException("Location was not found");
            } else if(e.getRawStatusCode() == 429) {
                return getAddress(longitude, latitude);
            } else {
                throw new LocationBadRequestException(e.getResponseBodyAsString());
            }
        }
    }
}
