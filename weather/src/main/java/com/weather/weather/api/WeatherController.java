package com.weather.weather.api;

import com.weather.weather.domain.Weather;
import com.weather.weather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("")
    public ResponseEntity getWeather(
            @RequestParam(name = "searchQuery") String searchQuery
    ) {
        try {
            Weather weather = weatherService.getWeather(searchQuery);
            return ResponseEntity.status(HttpStatus.OK).body(weather);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
