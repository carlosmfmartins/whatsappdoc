package whatsappdoc.wad.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatsappdoc.wad.models.perfil.Especialidade;
import whatsappdoc.wad.models.request.EspecialidadeRequestUpdate;
import whatsappdoc.wad.repositories.EspecialidadeRepoIF;
import whatsappdoc.wad.service.EspecialidadeServiceIF;

import java.util.Optional;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeServiceIF {
    @Autowired
    private EspecialidadeRepoIF especialidade_Repo;

    @Override
    public Iterable<Especialidade> findAll() {
        return especialidade_Repo.findAll();
    }

    @Override
    public Especialidade findEspecialidadeById(Long id) {
        Optional<Especialidade> optionalEsp = especialidade_Repo.findById(id);
        if (optionalEsp.isPresent()) {
            return optionalEsp.get();
        } else {
            return null;
        }
    }

    @Override
    public Especialidade findEspecialidadeByNome(String nome) {
        Optional<Especialidade> optionalEsp = especialidade_Repo.findByNome(nome);
        if (optionalEsp.isPresent()) {
            return optionalEsp.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean insertEspecialidade(Especialidade especialidade) {
        Optional<Especialidade> optionalEsp = especialidade_Repo.findByNome(especialidade.getNome());
        if (!optionalEsp.isPresent()) {
            especialidade_Repo.save(especialidade);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Especialidade updateEspecialidade(Long id, EspecialidadeRequestUpdate especialidadeUpdateInfo) {
        Optional<Especialidade> especialidadeDB = especialidade_Repo.findById(id);
        if (especialidadeDB.isPresent()) {
            especialidadeDB.get().setPreco(especialidadeUpdateInfo.getPreco());
            especialidade_Repo.save(especialidadeDB.get());
            return especialidadeDB.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean removeEspecialidade(Long id) {
        especialidade_Repo.deleteById(id);
        Optional<Especialidade> testRemoved = especialidade_Repo.findById(id);
        return !testRemoved.isPresent();
    }
}
