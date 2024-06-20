package com.weather.sixteen_day_forecast.model;

import java.util.List;
import lombok.Data;

@Data
public class WeatherData {
  private long dt;
  private long sunrise;
  private long sunset;
  private double temp;
  private double feels_like;
  private int pressure;
  private int humidity;
  private double dew_point;
  private int clouds;
  private int visibility;
  private double wind_speed;
  private int wind_deg;
  private double wind_gust;
  private List<Weather> weather;
  private Snow snow;
}
