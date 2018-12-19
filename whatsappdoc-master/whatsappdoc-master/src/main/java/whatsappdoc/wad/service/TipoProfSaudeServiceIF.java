package whatsappdoc.wad.service;

import whatsappdoc.wad.models.perfil.TipoProfSaude;

public interface TipoProfSaudeServiceIF {
    Iterable<TipoProfSaude> findAll();
    TipoProfSaude findTipoProfSaudeById(Long id);
    boolean insertTipoProfSaude(TipoProfSaude tipoPS);
    boolean removeTipoProfSaude(Long id);
}
