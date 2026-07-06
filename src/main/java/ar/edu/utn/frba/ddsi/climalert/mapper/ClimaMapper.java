package ar.edu.utn.frba.ddsi.climalert.mapper;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.entity.RegistroClimatico;
import org.springframework.stereotype.Component;

@Component
public class ClimaMapper {
  public RegistroClimatico aEntidad(ClimaResponseDTO dto) {
    if (dto == null) {
      return null;
    }

    return new RegistroClimatico(
        dto.humedad(),
        dto.temperatura()
    );
  }
}
