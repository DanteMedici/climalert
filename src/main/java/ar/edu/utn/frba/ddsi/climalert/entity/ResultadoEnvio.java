package ar.edu.utn.frba.ddsi.climalert.entity;

public record ResultadoEnvio(
    boolean exitoso,
    String motivoFalla
) {
  public static ResultadoEnvio exito() {
    return new ResultadoEnvio(true, null);
  }

  public static ResultadoEnvio falla(String motivo) {
    return new ResultadoEnvio(false, motivo);
  }
}

