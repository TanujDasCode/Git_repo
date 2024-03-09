package com.weather.weather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherResponse {

    private float temp;
    private float minTemp;
    private float maxTemp;
    private float humidity;
    private float windSpeed;
    private float windDeg;
}
