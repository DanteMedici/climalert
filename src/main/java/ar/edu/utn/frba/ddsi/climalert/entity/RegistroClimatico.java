package ar.edu.utn.frba.ddsi.climalert.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class RegistroClimatico {
  @Getter @Setter
  private Long id;
  private LocalDateTime fecha;
  @Getter
  private Integer humedad;
  @Getter
  private Double temperatura;

  public RegistroClimatico(LocalDateTime fecha, Integer humedad, Double temperatura) {
    this.fecha = fecha;
    this.humedad = humedad;
    this.temperatura = temperatura;
  }

  public boolean cumpleCondicionAlerta() {
    if(humedad == null || temperatura == null)
      return false;
    return humedad > 60 && temperatura >35;
  }
}
