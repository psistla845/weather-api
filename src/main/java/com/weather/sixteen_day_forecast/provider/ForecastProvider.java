package com.weather.sixteen_day_forecast.provider;

import com.weather.sixteen_day_forecast.model.ForecastResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ForecastProvider {

  RestTemplate restTemplate;

  public ForecastProvider(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ForecastResponse callSixteenDayForecast() {
    return restTemplate.getForObject("https://api.openweathermap.org/data/3.0/onecall/timemachine?lat=39.099724&lon=-94.578331&dt=1643803200&appid=3272903d21174ea93d08623ea3405c1d", ForecastResponse.class);
  }
}
