package whatsappdoc.wad.repositories;

import org.springframework.data.repository.CrudRepository;
import whatsappdoc.wad.models.perfil.Clinica;

public interface ClinicaRepoIF extends CrudRepository<Clinica,Long> {
    Clinica findByNome(String nome);
}
