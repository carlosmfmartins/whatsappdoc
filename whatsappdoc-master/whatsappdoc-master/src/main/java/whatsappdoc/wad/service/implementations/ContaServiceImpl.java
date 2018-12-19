package whatsappdoc.wad.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatsappdoc.wad.models.perfil.Conta;
import whatsappdoc.wad.repositories.ContaRepoIF;
import whatsappdoc.wad.service.ContaServiceIF;

@Service
public class ContaServiceImpl implements ContaServiceIF {
    @Autowired
    private ContaRepoIF conta_Repo;

    @Override
    public Iterable<Conta> findAll() {
        return conta_Repo.findAll();
    }
}
