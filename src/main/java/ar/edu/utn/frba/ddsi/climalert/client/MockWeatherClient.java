package ar.edu.utn.frba.ddsi.climalert.client;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MockWeatherClient implements WeatherClient {
  @Override
  public ClimaResponseDTO obtenerClimaActual() {
    return new ClimaResponseDTO(45.0, 95);
  }
}
