package com.weather.sixteen_day_forecast.model.response;

import java.util.List;
import lombok.Data;

@Data
public class WeatherResponse {
  private String timezone;
  private double dewPoint;
  private List<Description> descriptions;
}
