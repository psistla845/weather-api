package com.weather.sixteen_day_forecast.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.sixteen_day_forecast.model.ForecastResponse;
import com.weather.sixteen_day_forecast.model.response.WeatherResponse;
import com.weather.sixteen_day_forecast.provider.ForecastProvider;
import com.weather.sixteen_day_forecast.transformer.WeatherResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SixteenDayForecastService {

  ForecastProvider forecastProvider;
  WeatherResponseTransformer weatherResponseTransformer;

  @Autowired
  public SixteenDayForecastService(ForecastProvider forecastProvider, WeatherResponseTransformer weatherResponseTransformer) {
    this.forecastProvider = forecastProvider;
    this.weatherResponseTransformer = weatherResponseTransformer;
  }

  public WeatherResponse getForecastData() {
    ForecastResponse forecastResponse = forecastProvider.callSixteenDayForecast();
    WeatherResponse weatherResponse = weatherResponseTransformer.apply(forecastResponse);
    try {
      System.out.println(new ObjectMapper().writeValueAsString(weatherResponse));
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException(e);
    }
    return weatherResponse;
  }
}
