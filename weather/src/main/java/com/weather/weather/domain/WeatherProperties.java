package com.weather.weather.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherProperties {
    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float humidity;
}
