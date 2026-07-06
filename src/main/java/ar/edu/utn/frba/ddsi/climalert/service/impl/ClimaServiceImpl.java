package ar.edu.utn.frba.ddsi.climalert.service.impl;

import ar.edu.utn.frba.ddsi.climalert.client.WeatherClient;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.entity.MonitorClimatico;
import ar.edu.utn.frba.ddsi.climalert.entity.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.mapper.ClimaMapper;
import ar.edu.utn.frba.ddsi.climalert.repository.RegistroClimaticoRepository;
import ar.edu.utn.frba.ddsi.climalert.service.ClimaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaServiceImpl implements ClimaService {
  private final RegistroClimaticoRepository repository;
  private final MonitorClimatico monitorClimatico;
  private final ClimaMapper mapper;
  private final WeatherClient cliente;
  @Value("${alertas.destinatarios}")
  private List<String> destinatarios;
  private Long idUltimoRegistroAlertado = -1L;

  public ClimaServiceImpl(RegistroClimaticoRepository repository, MonitorClimatico monitorClimatico, ClimaMapper mapper, WeatherClient cliente) {
    this.repository = repository;
    this.monitorClimatico = monitorClimatico;
    this.mapper = mapper;
    this.cliente = cliente;
  }

  @Override
  public void procesarClimaActual() {
    ClimaResponseDTO response = this.cliente.obtenerClimaActual();
    RegistroClimatico registroActual = mapper.aEntidad(response);
    repository.guardar(registroActual);
  }

  @Override
  public void analizarAlertaMeteorologica() {
    RegistroClimatico ultimoRegistro = repository.obtenerUltimo();
    if (ultimoRegistro != null && ultimoRegistro.cumpleCondicionAlerta() && !ultimoRegistro.getId().equals(idUltimoRegistroAlertado)) {
      this.monitorClimatico.gestionarAlerta(ultimoRegistro, destinatarios);
      idUltimoRegistroAlertado = ultimoRegistro.getId();
    }
  }
}
