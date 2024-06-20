package com.weather.sixteen_day_forecast.transformer;

import com.weather.sixteen_day_forecast.model.ForecastResponse;
import com.weather.sixteen_day_forecast.model.response.Description;
import com.weather.sixteen_day_forecast.model.response.WeatherResponse;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WeatherResponseTransformer implements Function<ForecastResponse, WeatherResponse> {

  @Override
  public WeatherResponse apply(ForecastResponse forecastResponse) {
    WeatherResponse weatherResponse = new WeatherResponse();
    weatherResponse.setTimezone(forecastResponse.getTimezone());

//    double dewPoint = forecastResponse.getData().get(0).getDew_point();
    double dewPoint = forecastResponse.getData().stream().findFirst().isPresent()
        ? forecastResponse.getData().stream().findFirst().get().getDew_point() : 0.0;
    weatherResponse.setDewPoint(dewPoint);

    List<Description> descriptionList = forecastResponse.getData()
        .stream()
        .flatMap(eachWeatherData -> eachWeatherData
            .getWeather()
            .stream()
            .map(eachWeather -> {
              Description description = new Description();
              description.setDescription(eachWeather.getDescription());
              return description;
            }))
        .collect(Collectors.toList());
    weatherResponse.setDescriptions(descriptionList);

    return weatherResponse;
  }
}
