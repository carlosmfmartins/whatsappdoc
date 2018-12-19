package whatsappdoc.wad.service;

import whatsappdoc.wad.models.perfil.ProfSaude;
import whatsappdoc.wad.models.request.ProfSaudeRequest;
import whatsappdoc.wad.models.request.ProfSaudeRequestUpdate;

public interface ProfSaudeServiceIF {
    Iterable<ProfSaude> findAll();
    ProfSaude findProfSaudeById(Long id);
    ProfSaude insertProfSaude(ProfSaudeRequest profSaudeRequest);
    ProfSaude updateProfSaude(Long id, ProfSaudeRequestUpdate psUpdateInfo);
    boolean removeProfSaude(Long id);
}
