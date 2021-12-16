package com.project.passwordmanager.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.passwordmanager.controllers.kevin.LightSequence;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

import org.json.*;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.frqs.bryant.LightSequence.calculate_sequence;
import static com.project.frqs.bryant.draw.get_coordinates;
import static com.project.frqs.bryant.RSVP.get_result;
import static com.project.frqs.rachel.LightSequence.display_everything;

import com.project.passwordmanager.sql_helper;

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

    @GetMapping("/passmanager")
    public String passManager() {
        return "frontend/passmanager";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "frontend/signin";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "frontend/signup";
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

        return "frontend/kevin/about-kevin";
    }


    @GetMapping("/about/harry")
    public String harry(@RequestParam(name="player", required=false, defaultValue="22") String player, Model play) throws IOException, InterruptedException, ParseException, JSONException {


        List<String> playerid = new ArrayList<String>();
        String [] a = player.split(" ");

        StringBuilder person = new StringBuilder();

        String prefix = "";

        for (String i : a) {
            person.append(prefix);
            person.append(i);
            prefix = "%20";
        }

        //spacing between first and last name
        String space =" ";
        play.addAttribute("space", space);

    //API request, gets NBA player

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://free-nba.p.rapidapi.com/players/" + player))
                    .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                    .header("x-rapidapi-key", "6644298cbfmsh5ae57041a36c826p198b3ajsne9fb5389efdd")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //uses hashmapping or JSON
            //var map = new ObjectMapper().readValue(response.body(), HashMap.class); works but doesn't update
            var map = new ObjectMapper().readValue(response.body(), HashMap.class);


            //don't know how this works, just copied off of mort


            //   model.addAttribute("jo", jo);
            play.addAttribute("map", map);
            play.addAttribute("team", map.get("team"));

            return "frontend/harryabout";
        }
    @GetMapping("/harry/frq2")
    public String hfrq2(@RequestParam(name="sequence", required = false, defaultValue = "0101 0101 0101") String sequence,
                        @RequestParam(name="change", required = false, defaultValue = "0011 0011 0011") String change,
                        @RequestParam(name="insertion", required = false, defaultValue = "1111 1111") String insertion,
                        @RequestParam(name="index1", required = false, defaultValue = "4") int index1,
                        @RequestParam(name="segment", required = false, defaultValue = "11") String segment,
                        @RequestParam(name="oldseq", required = false, defaultValue = "1100000111") String oldseq,
                        @RequestParam(name="height", required = false, defaultValue = "4") double height,
                        @RequestParam(name="width", required = false, defaultValue = "3") double width ,Model model) throws IOException, InterruptedException {

        //FRQ answer a
            String a = "LightSequence gradShow = new LightSequence(\"" + sequence + "\");";

        LightSequence gradShow = new LightSequence(sequence);

        //question b
        gradShow.display();

        //question c
       gradShow.changeSequence(change);

       //question d
        String resultSeq = gradShow.insertSegment(insertion, index1);



       //question e
        if(segment.length()>oldseq.length()){
            String swap = segment;
            segment = oldseq;
            oldseq= swap;
        }
        int index = oldseq.indexOf(segment);
        String newSeq = oldseq.substring(0, index) + oldseq.substring(index + segment.length());

        //question f
        double partf = Math.sqrt(width*width + height*height);

        model.addAttribute("a", a);
       model.addAttribute("b",sequence);
        model.addAttribute("c", "\"" + change +"\"" );
      model.addAttribute("d", resultSeq);
      model.addAttribute("command", "\"" + insertion+"," + index +"\"" );
      model.addAttribute("e", newSeq) ;
      model.addAttribute("f", partf);

        return "frontend/harryfrq2";
    }


    @GetMapping("/about/bryant")
    public String bryant(@RequestParam(name = "uuid", required = true, defaultValue = "c93c8573bc6a49b4ade069a9f909c895") String uuid, Model model) throws JSONException, IOException, InterruptedException {
        String url = "jdbc:sqlite:test.db";
        sql_helper database = new sql_helper();
        String[][] work = database.get_work(url);

        model.addAttribute("work", work);

        String base = "https://api.hypixel.net/player";
        String API_KEY = "e515dfcd-214d-4388-91d6-03b5b80c8b77";

        String uri = base + "?key=" + API_KEY + "&uuid=" + uuid;




        // shamelessly stolen code because i don't want to write my own http request handling
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject resp = new JSONObject(response.body()).getJSONObject("player").getJSONObject("stats").getJSONObject("Bedwars");

        String[] keys = {"eight_one_final_kills_bedwars", "eight_one_final_deaths_bedwars", "eight_two_final_kills_bedwars", "eight_two_final_deaths_bedwars", "four_three_final_kills_bedwars", "four_three_final_deaths_bedwars", "four_four_final_kills_bedwars", "four_four_final_deaths_bedwars"};
        String[] normalized_names = {"Solos", "Duos", "Threes", "Fours", "Total"};

        int totalKills, totalDeaths;
        totalKills = totalDeaths = 0;

        int[][] values = new int[5][2];

        for (int i = 0; i < keys.length; i += 2) {
            try { // make sure connection can be established
                values[i/2] = new int[] {resp.getInt(keys[i]), resp.getInt(keys[i+1])};
                totalKills += resp.getInt(keys[i]);
                totalDeaths += resp.getInt(keys[i+1]);
            }
            catch (JSONException e) {
                values[i] = new int[] {0, 0};
            }
        }

        values[4] = new int[] {totalKills, totalDeaths};

        double fkdr = (totalKills / (double) totalDeaths);

        model.addAttribute("names", normalized_names);
        model.addAttribute("data", values);
        model.addAttribute("fkdr", fkdr);

        return "frontend/BryantAbout";
    }

    // remove later
    @GetMapping("/frq2")
    public String nerd(@RequestParam(name = "a", required = false, defaultValue = "3") int a, @RequestParam(name = "b", required = false, defaultValue = "4") int b, @RequestParam(name = "initSeq", required = false, defaultValue = "0101 0101 0101") String initSeq, @RequestParam(name = "changeSeq", required = false, defaultValue = "0011 0011 0011") String changeSeq, @RequestParam(name = "segment", required = false, defaultValue = "1100000111") String segment, @RequestParam(name = "oldSeq", required = false, defaultValue = "00") String oldSeq, @RequestParam(name = "insertSeg", required = false, defaultValue = "1111 1111") String insertSeg, Model light_model) {
        light_model.addAttribute("data", calculate_sequence(a, b, initSeq, changeSeq, segment, oldSeq, insertSeg));
        light_model.addAttribute("desc", new String[]{"Initial display", "Changed display", "Display after insertion", "Replaced segment", "Distance between lights"});
        return "frqs/frq2"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/about/rachel")
    public String rachel(@RequestParam(name = "location", required = false, defaultValue = "8583955216") String location, Model phonemodel) throws IOException, InterruptedException, ParseException, JSONException{

        /*List<String> locationList = new ArrayList<String>();
        String [] a = location.split(" ");

        StringBuilder locationName = new StringBuilder();

        String prefix = "";

        for (String i : a) {
            locationName.append(prefix);
            locationName.append(i);
            prefix = "%20";
        }

        System.out.println(location);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/weather?q="+ locationName))
                .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .header("x-rapidapi-key", "8211d43935msh926990e704c2717p15ea0fjsn8c393a17973a")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        var map = new ObjectMapper().readValue(response.body(), HashMap.class);
        weathermodel.addAttribute("map", map);
        weathermodel.addAttribute("main", map.get("main"));
        */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://veriphone.p.rapidapi.com/verify?phone="+ location))
                .header("x-rapidapi-host", "veriphone.p.rapidapi.com")
                .header("x-rapidapi-key", "8211d43935msh926990e704c2717p15ea0fjsn8c393a17973a")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        var map = new ObjectMapper().readValue(response.body(), HashMap.class);
        phonemodel.addAttribute("map", map);
        phonemodel.addAttribute("phone_region", map.get("phone_region"));
        return "frontend/about-rachel";
    }




    @GetMapping("/frq3")
    public String frq3(@RequestParam(name = "rsvp", required = false, defaultValue = "false") boolean rsvp, @RequestParam(name = "selection", required = false, defaultValue = "1") int selection, @RequestParam(name = "check", required = false, defaultValue = "Sorry you can't make it.") String option2, @RequestParam(name = "initx", required = false, defaultValue = "0") int initx, @RequestParam(name = "inity", required = false, defaultValue = "0") int inity, @RequestParam(name = "side", required = false, defaultValue = "10") int side, Model model) {
        model.addAttribute("data", get_result(rsvp, selection, option2));
        model.addAttribute("desc", new String[]{"Attending?", "Custom message", "Message matches debug value?"});

        int[] coordinate_values = get_coordinates(initx, inity, side);
        model.addAttribute("initx", coordinate_values[0]);
        model.addAttribute("inity", coordinate_values[1]);
        model.addAttribute("side", coordinate_values[2]);
        return "frqs/frq3";
    }
    @GetMapping("/rachel/frq2")
    public String frqunit2(@RequestParam(name = "vertical", required = false, defaultValue = "7")int vertical, @RequestParam(name = "horizontal", required = false, defaultValue = "7")int horizontal, @RequestParam(name = "initSeq", required = false, defaultValue = "0101 0101 0101")String initSeq,@RequestParam(name = "changeSeq", required = false, defaultValue = "0011 0011 0011")String changeSeq,@RequestParam(name = "insertSeq", required = false, defaultValue = "1111 1111")String insertSeg, @RequestParam(name = "oldSeq", required = false, defaultValue = "00")String oldSeq, @RequestParam(name = "segment", required = false, defaultValue = "00")String segment, Model lightseqmodel){
        lightseqmodel.addAttribute("data", display_everything(vertical, horizontal, initSeq, changeSeq, insertSeg, oldSeq, segment));
        return "frqs/rachelfrq2";
    }
    @GetMapping("/harry/frq3")
    public String hfrq3(@RequestParam(name="attending", required = false, defaultValue = "Yes") String attending ,
                        @RequestParam(name="select", required = false, defaultValue = "1") int select,
                        @RequestParam(name="option1", required = false, defaultValue = "") String option1,
                        @RequestParam(name="option2", required = false, defaultValue = "") String option2, Model model) throws IOException, InterruptedException {
        //question a
        boolean rsvp;
        if (attending.equals("on")) {
            rsvp = true;
        } else {
            rsvp = false;
        }
        if (rsvp) {
            System.out.println("Attending");
            model.addAttribute("a", "Attending");
        } else {
            System.out.println("Not attending");
            model.addAttribute("a", "Not attending");
        }

        String food="";
       switch(select){
           case 1:
               food = "beef";
               break;
           case 2:
               food = "chicken";
               break;
           case 3:
               food = "pasta";
               break;
       }
       model.addAttribute("b", food);

       //question c
        String message = "";

        if(rsvp) {
            switch(select) {
                case 1:
                    food = "beef";
                    break;
                case 2:
                    food = "chicken";
                    break;
                case 3:
                    food = "pasta";
                    break;
            }
            message = "Thanks for attending. You will be served " + food + ".";
        } else {
            message = "Sorry you can't make it.";
        }
        model.addAttribute("c", message);
//question d
        if(Objects.equals(option1, option2)){
            model.addAttribute("d", "True");
        }
        else{
            model.addAttribute("d", "False");
        }

        return "frqs/harryfrq3";

    }

    @GetMapping("/api/getPasswords")
    public ResponseEntity<String> get_passwords() throws JSONException {
        String url = "jdbc:sqlite:db/passwords.db";
        sql_helper database = new sql_helper();
        String[][] passwords = database.get_passwords(url);

        Gson gson = new GsonBuilder().create();
        return new ResponseEntity<>(gson.toJson(passwords), HttpStatus.OK);
    }

}

