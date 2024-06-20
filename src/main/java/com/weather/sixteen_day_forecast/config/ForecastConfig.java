package com.weather.sixteen_day_forecast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ForecastConfig {

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
