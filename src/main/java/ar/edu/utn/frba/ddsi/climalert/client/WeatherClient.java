package ar.edu.utn.frba.ddsi.climalert.client;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import org.springframework.web.client.RestTemplate;

public class WeatherClient {
  private final RestTemplate restTemplate;
  private final String urlApi = "https://api.weatherapi.com/v1/current.json?key=TU_API_KEY&q=BuenosAires";

  public WeatherClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ClimaResponseDTO obtenerClimaActual() {
    return restTemplate.getForObject(urlApi, ClimaResponseDTO.class);
  }
}
