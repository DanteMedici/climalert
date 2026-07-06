package ar.edu.utn.frba.ddsi.climalert.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class SmtpAdapter implements CorreoAdapter {
  private final JavaMailSender mailSender;
  private static final Logger log = LoggerFactory.getLogger(SmtpAdapter.class);

  public SmtpAdapter(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public ResultadoEnvio enviar(Alerta alerta) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(alerta.getDestinatarios().toArray(new String[0]));
      message.setSubject(alerta.getAsunto());
      message.setText(alerta.getMensaje());
      mailSender.send(message);
      return ResultadoEnvio.exito();
    } catch (Exception e) {
      log.error("Error al enviar el correo: {}", e.getMessage());
      return ResultadoEnvio.falla(e.getMessage());
    }
  }
}
