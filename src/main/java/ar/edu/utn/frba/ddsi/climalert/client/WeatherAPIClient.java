package ar.edu.utn.frba.ddsi.climalert.client;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.dto.WeatherAPIResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Profile("prod")
public class WeatherAPIClient implements WeatherClient {
  private final RestTemplate restTemplate;
  @Value("${weather.api.url}")
  private String urlBase;
  @Value("${weather.api.key}")
  private String apiKey;
  @Value("${weather.api.location}")
  private String location;

  public WeatherAPIClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public ClimaResponseDTO obtenerClimaActual() {
    URI uri = UriComponentsBuilder.fromUriString(urlBase)
        .queryParam("key", apiKey)
        .queryParam("q", location)
        .build()
        .toUri();

    WeatherAPIResponseDTO response = restTemplate.getForObject(uri, WeatherAPIResponseDTO.class);

    if (response == null || response.current() == null)
      throw new RuntimeException("La API devolvió un body vacío o mal estructurado");

    return response.current();
  }
}
