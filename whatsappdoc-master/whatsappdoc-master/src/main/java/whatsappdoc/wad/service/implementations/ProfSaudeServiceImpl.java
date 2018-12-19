package whatsappdoc.wad.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatsappdoc.wad.models.perfil.Conta;
import whatsappdoc.wad.models.perfil.Especialidade;
import whatsappdoc.wad.models.perfil.ProfSaude;
import whatsappdoc.wad.models.perfil.TipoProfSaude;
import whatsappdoc.wad.models.request.ProfSaudeRequest;
import whatsappdoc.wad.models.request.ProfSaudeRequestUpdate;
import whatsappdoc.wad.repositories.ContaRepoIF;
import whatsappdoc.wad.repositories.EspecialidadeRepoIF;
import whatsappdoc.wad.repositories.ProfSaudeRepoInt;
import whatsappdoc.wad.repositories.TipoProfSaudeRepoInt;
import whatsappdoc.wad.service.ProfSaudeServiceIF;

import java.util.Optional;

@Service
public class ProfSaudeServiceImpl implements ProfSaudeServiceIF {
    @Autowired
    private ProfSaudeRepoInt profSaude_Repo;
    @Autowired
    private EspecialidadeRepoIF especialidade_Repo;
    @Autowired
    private TipoProfSaudeRepoInt tipoPS_Repo;
    @Autowired
    private ContaRepoIF conta_Repo;

    @Override
    public Iterable<ProfSaude> findAll() {
        return profSaude_Repo.findAll();
    }

    @Override
    public ProfSaude findProfSaudeById(Long id) {
        Optional<ProfSaude> optionalPS = profSaude_Repo.findById(id);
        if (optionalPS.isPresent()) {
            return optionalPS.get();
        } else {
            return null;
        }
    }

    @Override
    public ProfSaude insertProfSaude(ProfSaudeRequest profSaudeRequest) {
        Optional<Especialidade> optionalEsp = especialidade_Repo.findByNome(profSaudeRequest.getNomeEspecialidade());
        Optional<TipoProfSaude> optionalTipoPS = tipoPS_Repo.findByNome(profSaudeRequest.getNomeTipoProfSaude());

        if (optionalEsp.isPresent() && optionalTipoPS.isPresent()) {
            Conta conta = new Conta(profSaudeRequest.getUsername(), profSaudeRequest.getPassword());
            conta_Repo.save(conta);
            ProfSaude profSaude = new ProfSaude(profSaudeRequest.getNome(), profSaudeRequest.getApelido(), profSaudeRequest.getTitulo(), profSaudeRequest.getNif(), optionalEsp.get(), optionalTipoPS.get(), conta);
            profSaude_Repo.save(profSaude);
            return profSaude;
        } else {
            return null;
        }
    }

    @Override
    public ProfSaude updateProfSaude(Long id, ProfSaudeRequestUpdate psUpdateInfo) {
        Optional<ProfSaude> profSaudeDB = profSaude_Repo.findById(id);
        if (profSaudeDB.isPresent()) {
            profSaudeDB.get().setEspecialidade(psUpdateInfo.getEspecialidade());
            profSaude_Repo.save(profSaudeDB.get());
            return profSaudeDB.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean removeProfSaude(Long id) {
        Optional<ProfSaude> optionalPS = profSaude_Repo.findById(id);
        if (optionalPS.isPresent()) {
            Conta conta = optionalPS.get().getConta();
            optionalPS.get().setConta(null);
            conta.setProfSaude(null);

            conta_Repo.deleteById(conta.getId());
            optionalPS.get().getEspecialidade().removeProfSaude(optionalPS.get());
        }

        profSaude_Repo.deleteById(id);
        Optional<ProfSaude> testRemoved = profSaude_Repo.findById(id);
        return !testRemoved.isPresent();
    }
}
