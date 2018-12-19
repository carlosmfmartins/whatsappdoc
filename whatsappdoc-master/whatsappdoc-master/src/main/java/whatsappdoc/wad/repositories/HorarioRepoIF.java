package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whatsappdoc.wad.models.calendario.Horario;

@Repository
public interface HorarioRepoIF extends CrudRepository<Horario,Long> {

}
