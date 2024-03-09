package com.weather.weather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {

    @JsonProperty("coord")
    Location location;

    @JsonProperty("main")
    WeatherProperties weatherProperties;

    Wind wind;
}
