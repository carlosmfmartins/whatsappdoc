package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whatsappdoc.wad.models.perfil.Especialidade;

import java.util.Optional;

@Repository
public interface EspecialidadeRepoIF extends CrudRepository<Especialidade, Long> {
    Optional<Especialidade> findByNome(String nome);
}
