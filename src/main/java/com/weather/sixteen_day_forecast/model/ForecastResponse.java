package com.weather.sixteen_day_forecast.model;

import java.util.List;
import lombok.Data;

@Data
public class ForecastResponse {
  private String lat;
  private String lon;
  private String timezone;
  private String timezone_offset;
  private List<WeatherData> data;
}
