package ar.edu.utn.frba.ddsi.climalert.repository.inmemory;

import ar.edu.utn.frba.ddsi.climalert.entity.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.repository.RegistroClimaticoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRegistroClimaticoRepository implements RegistroClimaticoRepository {
  private final List<RegistroClimatico> registros = new ArrayList<>();
  private final AtomicLong idGenerator = new AtomicLong(1);

  @Override
  public RegistroClimatico guardar(RegistroClimatico registroClimatico) {
    if(registroClimatico.getId() == null) {
      registroClimatico.setId(idGenerator.getAndIncrement());
      registros.add(registroClimatico);
    }
    return registroClimatico;
  }

  @Override
  public RegistroClimatico obtenerUltimo() {
    if(registros.isEmpty())
      return null;
    return registros.getLast();
  }
}
