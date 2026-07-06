package ar.edu.utn.frba.ddsi.climalert.client;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;

public interface WeatherClient {
  ClimaResponseDTO obtenerClimaActual();
}
