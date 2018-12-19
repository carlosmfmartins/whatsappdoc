package whatsappdoc.wad.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatsappdoc.wad.models.perfil.TipoProfSaude;
import whatsappdoc.wad.repositories.TipoProfSaudeRepoInt;
import whatsappdoc.wad.service.TipoProfSaudeServiceIF;

import java.util.Optional;

@Service
public class TipoProfSaudeServiceImpl implements TipoProfSaudeServiceIF {
    @Autowired
    private TipoProfSaudeRepoInt tipoPS_Repo;

    @Override
    public Iterable<TipoProfSaude> findAll() {
        return tipoPS_Repo.findAll();
    }

    @Override
    public TipoProfSaude findTipoProfSaudeById(Long id) {
        Optional<TipoProfSaude> optionalTPS = tipoPS_Repo.findById(id);
        if (optionalTPS.isPresent()) {
            return optionalTPS.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean insertTipoProfSaude(TipoProfSaude tipoPS) {
        Optional<TipoProfSaude> optionalTPS = tipoPS_Repo.findByNome(tipoPS.getNome());
        if (!optionalTPS.isPresent()) {
            tipoPS_Repo.save(tipoPS);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeTipoProfSaude(Long id) {
        tipoPS_Repo.deleteById(id);
        Optional<TipoProfSaude> testRemoved = tipoPS_Repo.findById(id);
        return !testRemoved.isPresent();
    }
}
