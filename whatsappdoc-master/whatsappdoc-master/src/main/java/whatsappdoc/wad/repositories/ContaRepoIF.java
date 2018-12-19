package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whatsappdoc.wad.models.perfil.Conta;
import whatsappdoc.wad.models.perfil.ProfSaude;

import java.util.Optional;

@Repository
public interface ContaRepoIF extends CrudRepository<Conta, Long> {
    Optional<Conta> findByUsername(String username);
    Optional<Conta> findByProfSaude(ProfSaude profSaude);
}
