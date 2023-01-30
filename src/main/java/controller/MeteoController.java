package controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.Cordinates;
import model.Forecast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Controller
public class MeteoController {
    final String token = "e06d5dd72af3f9c83c1a30a60046bb19324ae896298065e934765ad39157a7ff";

    @RequestMapping(value = "/meteo", method = RequestMethod.POST)
    public String showMeteo(@RequestBody String address, Model model) throws Exception {

        System.out.println(address);
        Cordinates c = coordonne(address);
        Forecast forecast =forecast(c);
        model.addAttribute("forecast", forecast);
        return "Meteo";
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Cordinates coordonne(String add) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String cor = restTemplate.getForObject(
                "https://api-adresse.data.gouv.fr/search/?q=" + add + "&limit=1", String.class);
        System.out.println("https://api-adresse.data.gouv.fr/search/?q=" + add + "&limit=1");
        System.out.println("///:recuperer les coordonnées stings");
        JSONObject root = new JSONObject(cor);

        JSONArray features = root.getJSONArray("features");
        JSONObject result = features.getJSONObject(0);

        JSONObject geometry = result.getJSONObject("geometry");
        JSONArray cordinates = geometry.getJSONArray("coordinates");
        Cordinates c = new Cordinates();
        System.out.println("contenu Longitude =    " + cordinates.getBigDecimal(0));
        c.setLongitude(cordinates.getBigDecimal(0).toString());
        System.out.println("contenu Latitude =    " + cordinates.getBigDecimal(1));
        c.setLatitude(cordinates.getBigDecimal(1).toString());
        System.out.println();
        System.out.println("end cord");
        return c;


    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Forecast forecast(Cordinates c) throws IOException {
        System.out.println("begin forecast");
        String url = new String("https://api.meteo-concept.com/api/forecast/daily?token=" + token + "&latlng=" + c.getLatitude() + "," + c.getLongitude());
        System.out.println(url);
       RestTemplate restTemplate = new RestTemplate();
       /* HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        RestTemplate restTemplate = new RestTemplate();*/

//http headers
        HttpHeaders headers = new HttpHeaders();

// set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
// build the request
        HttpEntity request = new HttpEntity(headers);
        Forecast ff = new Forecast();
// make an HTTP GET request with headers
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
       /* System.out.println("test response");
        System.out.println(response.getBody());
        System.out.println("end test response");
        System.out.println(" test etity");
        System.out.println(ff.toString());
        System.out.println("end test entity");
*/
// check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }


        // con.setRequestProperty("Accept", "application/json");


        JSONObject root = new JSONObject(response.getBody());

       /* System.out.println("test");
        System.out.println(root.toString());
        System.out.println("end test");*/
        JSONArray forecast = root.getJSONArray("forecast");
       /* System.out.println("test forecast");
        System.out.println(forecast.toString());
        System.out.println("end test forecast");*/
        JSONObject weather = forecast.getJSONObject(0);

        Forecast f = new Forecast();

        //f.setDay(weather.getBigDecimal("Day").toString());
        System.out.println( "weather test for get json att = "+weather.getBigInteger("day").toString());


        f.setDay(weather.getBigInteger("day").toString());
        f.setDatetime(weather.getString("datetime"));
        f.setWeather(weather.getBigInteger("weather").toString());
        f.setWind(weather.getBigInteger("wind10m").toString());
        f.setTmax(weather.getBigInteger("tmax").toString());
        System.out.println("entity test");
        System.out.println("DAY === " + f.getDay());
        System.out.println(f.toString());
        System.out.println("end test entity");

        return f;
    }


}






