package com.project.passwordmanager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.*;

import org.json.*;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class controller {

    @GetMapping("/")
    public String index() {
        return "frontend/index";
    }

    @GetMapping("/home")
    public String home() {
        return "frontend/index";
    }

    @GetMapping("/passtester")
    public String passTester() {
        return "frontend/passtester";
    }

    @GetMapping("/about/kevin")
    public String kevin(@RequestParam(name="artist", required=false, defaultValue="NOTD") String artist, Model model) throws IOException, InterruptedException, ParseException, JSONException {

        List<String> artistList = new ArrayList<String>();
        String [] a = artist.split(" ");

        StringBuilder artistName = new StringBuilder();

        String prefix = "";

        for (String i : a) {
            artistName.append(prefix);
            artistName.append(i);
            prefix = "%20";
        }


        System.out.println(artistName);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://genius.p.rapidapi.com/search?q=" + artistName))
                .header("x-rapidapi-host", "genius.p.rapidapi.com")
                .header("x-rapidapi-key", "4190a7eb73msh31b7a3a5e4814d3p1ffd18jsn5e2c346f8d63")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        JSONObject jo = new JSONObject(response.body());
//        System.out.println(jo);
        JSONObject response_jo = jo.getJSONObject("response");
        JSONArray hitsArray = response_jo.getJSONArray("hits");

        JSONObject firstHit = hitsArray.getJSONObject(0);
//        System.out.println("first hit:" + firstHit.toString());

        JSONObject firstHitResult = (JSONObject) firstHit.get("result");

        String song_art_url = firstHitResult.get("song_art_image_url").toString();
        String song_name = firstHitResult.get("full_title").toString();

        List<Map<String, String>> mapsList = new ArrayList<Map<String, String>>();

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("Profile", "https://github.com/kevin-dough");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("Issues", "https://github.com/wrachel/TaxEvaders/issues?q=assignee%3Akevin-dough");
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("Scrum Board", "https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3Akevin-dough");
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("Commits", "https://github.com/wrachel/TaxEvaders/commits?author=kevin-dough");
        Map<String, String> map5 = new HashMap<String, String>();
        map5.put("Journal", "https://docs.google.com/document/d/16_k_1SHg_x8uD2hea02EN_f5rCSypD75EXhMNy_6yiI/edit?usp=sharing");

        mapsList.add(map1);
        mapsList.add(map2);
        mapsList.add(map3);
        mapsList.add(map4);
        mapsList.add(map5);

        model.addAttribute("song_art_url", song_art_url);
        model.addAttribute("song_name", song_name);
        model.addAttribute("mapsList", mapsList);

        return "frontend/about-kevin";
    }

    @GetMapping("/about/harry")
    public String harry() {
        return "frontend/harryabout";
    }


}

