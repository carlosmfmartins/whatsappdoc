package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whatsappdoc.wad.models.perfil.TipoProfSaude;

import java.util.Optional;

@Repository
public interface TipoProfSaudeRepoInt extends CrudRepository<TipoProfSaude, Long> {
    Optional<TipoProfSaude> findByNome(String nome);
}
