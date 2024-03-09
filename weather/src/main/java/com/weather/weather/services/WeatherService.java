package com.weather.weather.services;

import com.weather.weather.domain.Weather;
import com.weather.weather.interfaces.OpenWeatherMapApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final OpenWeatherMapApi openWeatherMapApi;

    @Cacheable(cacheNames = {"weather"}, key = "#searchQuery")
    public Weather getWeather(final String searchQuery) {
        return openWeatherMapApi.getWeather(searchQuery);
    }
}
