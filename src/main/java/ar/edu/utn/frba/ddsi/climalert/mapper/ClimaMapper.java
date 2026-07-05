package ar.edu.utn.frba.ddsi.climalert.mapper;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.entity.RegistroClimatico;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClimaMapper {
  public RegistroClimatico aEntidad(ClimaResponseDTO dto) {
    if (dto == null) {
      return null;
    }

    return new RegistroClimatico(
        LocalDateTime.now(),
        dto.humedad(),
        dto.temperatura()
    );
  }
}
