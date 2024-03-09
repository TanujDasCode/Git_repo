package com.weather.weather.interfaces;

import com.weather.weather.config.CustomFeignConfiguration;
import com.weather.weather.domain.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "${open.weather.name}",
        url = "${open.weather.url}",
        configuration = CustomFeignConfiguration.class
)
public interface OpenWeatherMapApi {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "${open.weather.request.value}",
            produces = "${open.weather.request.produces}"
    )
    Weather getWeather(@PathVariable("searchQuery") String searchQuery);
}