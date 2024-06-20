package com.weather.sixteen_day_forecast.model;

import lombok.Data;

@Data
public class Weather {
  private int id;
  private String main;
  private String description;
  private String icon;
}
