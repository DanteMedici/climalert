package ar.edu.utn.frba.ddsi.climalert.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Alerta {
  @Getter @Setter
  private Long id;
  private List<String> destinatarios;
  private String asunto;
  private String mensaje;

  public Alerta(List<String> destinatarios, String asunto, String mensaje) {
    this.destinatarios = destinatarios;
    this.asunto = asunto;
    this.mensaje = mensaje;
  }
}
