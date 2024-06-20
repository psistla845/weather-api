package com.weather.sixteen_day_forecast.controller;

import com.weather.sixteen_day_forecast.model.ForecastResponse;
import com.weather.sixteen_day_forecast.model.response.WeatherResponse;
import com.weather.sixteen_day_forecast.service.SixteenDayForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SixteenDayForecastController {

  private SixteenDayForecastService sixteenDayForecastService;

  @Autowired
  public SixteenDayForecastController(SixteenDayForecastService sixteenDayForecastService) {
    this.sixteenDayForecastService = sixteenDayForecastService;
  }

  @GetMapping("/sixteendayforecast")
  public WeatherResponse sixteenDayForecastController() {
    return sixteenDayForecastService.getForecastData();
  }
}
