package whatsappdoc.wad.service;

import whatsappdoc.wad.models.perfil.Especialidade;
import whatsappdoc.wad.models.request.EspecialidadeRequestUpdate;

public interface EspecialidadeServiceIF {
    Iterable<Especialidade> findAll();
    Especialidade findEspecialidadeById(Long id);
    Especialidade findEspecialidadeByNome(String nome);
    boolean insertEspecialidade(Especialidade especialidade);
    Especialidade updateEspecialidade(Long id, EspecialidadeRequestUpdate especialidadeUpdateInfo);
    boolean removeEspecialidade(Long id);
}
