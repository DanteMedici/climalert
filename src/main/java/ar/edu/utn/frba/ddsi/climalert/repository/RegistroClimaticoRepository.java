package ar.edu.utn.frba.ddsi.climalert.repository;

import ar.edu.utn.frba.ddsi.climalert.entity.RegistroClimatico;

public interface RegistroClimaticoRepository {
  RegistroClimatico guardar(RegistroClimatico registroClimatico);
  RegistroClimatico obtenerUltimo();
}
