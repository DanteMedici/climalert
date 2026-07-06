package ar.edu.utn.frba.ddsi.climalert.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MockCorreoAdapter implements CorreoAdapter {
  private static final Logger log = LoggerFactory.getLogger(MockCorreoAdapter.class);

  @Override
  public ResultadoEnvio enviar(Alerta alerta) {
    log.info("MOCK - Simulando envío SMTP a: {}", alerta.getDestinatarios());
    log.info("MOCK - Asunto: {}", alerta.getAsunto());
    log.info("MOCK - Cuerpo del mensaje: {}", alerta.getMensaje());
    return ResultadoEnvio.exito();
  }
}
