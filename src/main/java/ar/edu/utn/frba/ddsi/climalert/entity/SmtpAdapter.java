package ar.edu.utn.frba.ddsi.climalert.entity;

public class SmtpAdapter implements CorreoAdapter {
  private JavaMailSenderAdapter adapter;

  public SmtpAdapter(JavaMailSenderAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public ResultadoEnvio enviar(Alerta alerta) {
    return this.adapter.enviar(alerta);
  }
}
