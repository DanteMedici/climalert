package ar.edu.utn.frba.ddsi.climalert.scheduler;

import ar.edu.utn.frba.ddsi.climalert.service.ClimaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
  private final ClimaService climaService;
  private static final Logger log = LoggerFactory.getLogger(ClimaScheduler.class);
  public ClimaScheduler(ClimaService climaService) {
    this.climaService = climaService;
  }

  @Scheduled(cron = "${scheduler.cron.analisis}")
  public void evaluarClima() {
    try {
      this.climaService.analizarAlertaMeteorologica();
    } catch (Exception e) {
      log.error("Error al analizar el clima: {}", e.getMessage());
    }
  }

  @Scheduled(cron = "${scheduler.cron.descarga}")
  public void monitorearClima() {
    try {
      log.info("Monitoreando el clima");
      this.climaService.procesarClimaActual();
    } catch (Exception e) {
      log.error("Fallo al intentar obtener el clima: ", e);
    }
  }
}
