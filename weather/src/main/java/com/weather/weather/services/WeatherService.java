package com.weather.weather.services;

import com.weather.weather.domain.Weather;
import com.weather.weather.domain.WeatherResponse;
import com.weather.weather.interfaces.OpenWeatherMapApi;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final OpenWeatherMapApi openWeatherMapApi;

    @Cacheable(value = "weather", key = "#searchQuery")
    public WeatherResponse getWeather(final String searchQuery) {
        logger.info("Fetching Weather Info From API for {}", searchQuery);
        String isCached = "true";
        Weather weather = openWeatherMapApi.getWeather(searchQuery);
        return WeatherResponse.builder()
                .temp(weather.getWeatherProperties().getTemp())
                .minTemp(weather.getWeatherProperties().getTemp_min())
                .maxTemp(weather.getWeatherProperties().getTemp_max())
                .humidity(weather.getWeatherProperties().getHumidity())
                .windSpeed(weather.getWind().getSpeed())
                .windDeg(weather.getWind().getDeg())
                .build();
    }
}
