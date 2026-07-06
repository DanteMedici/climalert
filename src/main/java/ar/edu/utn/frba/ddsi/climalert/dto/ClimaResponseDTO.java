package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClimaResponseDTO(
    @JsonProperty("temp_c") Double temperatura,
    @JsonProperty("humidity") Integer humedad
) {
}
