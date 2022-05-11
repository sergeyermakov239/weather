package com.example.weather;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class Weather {
    public String request (String city){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response=restTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?q=" + city+"&appid=052bcd470ad59e1693830b6819643398", Map<String>.class);
        String s=response.getBody();
        JSONObject obj=new JSONObject(s);

        return response.getBody();


    }
}
