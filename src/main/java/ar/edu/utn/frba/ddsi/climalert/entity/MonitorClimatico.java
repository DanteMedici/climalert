package ar.edu.utn.frba.ddsi.climalert.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MonitorClimatico {
  private CorreoAdapter adapter;
  public MonitorClimatico(CorreoAdapter adapter) {
    this.adapter = adapter;
  }

  public ResultadoEnvio gestionarAlerta(RegistroClimatico registro, List<String> destinatarios) {
    String mensaje = "Peligro: Temperatura de " + registro.getTemperatura() + "°C y Humedad de " + registro.getHumedad() + "%";
    String asunto = "Alerta Meteorológica Crítica";
    Alerta alerta = new Alerta (destinatarios, asunto, mensaje);

    return this.adapter.enviar(alerta);
  }
}
