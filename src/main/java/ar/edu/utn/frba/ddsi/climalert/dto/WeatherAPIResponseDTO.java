package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherAPIResponseDTO(
  @JsonProperty("current") ClimaResponseDTO current
) {
}
