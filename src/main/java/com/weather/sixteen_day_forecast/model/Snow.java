package com.weather.sixteen_day_forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snow {
  @JsonProperty("1h")
  private double oneH;
}
