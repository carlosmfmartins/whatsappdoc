package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whatsappdoc.wad.models.perfil.ProfSaude;

@Repository
public interface ProfSaudeRepoInt extends CrudRepository<ProfSaude, Long> {
    ProfSaude findByNome(String nome);
}
