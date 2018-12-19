package whatsappdoc.wad.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatsappdoc.wad.models.calendario.Horario;
import whatsappdoc.wad.models.perfil.Clinica;
import whatsappdoc.wad.models.perfil.ProfSaude;
import whatsappdoc.wad.repositories.ClinicaRepoIF;
import whatsappdoc.wad.repositories.HorarioRepoIF;
import whatsappdoc.wad.repositories.ProfSaudeRepoInt;
import whatsappdoc.wad.service.HorarioServiceIF;

import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioServiceIF {
    @Autowired
    private ClinicaRepoIF clinica_repo;

    @Autowired
    private ProfSaudeRepoInt profsaude_repo;

    @Autowired
    private HorarioRepoIF horario_Repo;

    @Override
    public Iterable<Horario> finAll() {
        return horario_Repo.findAll();
    }

    @Override
    public boolean removeHorario(Long id) {
        Optional <Horario> tempHorario =  horario_Repo.findById(id);
        if(tempHorario.isPresent()){
           if(tempHorario.get().getAtendimentos() == null){
               horario_Repo.deleteById(id);
               return true;
           }
        }
        return false;
    }

    @Override
    public Horario insertHorario(Long id, Horario newHorario) {
        Optional<ProfSaude> tempPerfil = profsaude_repo.findById(id);
        Optional<Clinica> tempClinica =  clinica_repo.findById(id);

        if(tempPerfil.isPresent()){
            for (Horario h: tempPerfil.get().getHorarios()) {
                if(h.getData().compareTo(newHorario.getData()) == 0){
                    return null;
                }
            }
            tempPerfil.get().getHorarios().add(newHorario);
            profsaude_repo.save(tempPerfil.get());
        }
        else if(tempClinica.isPresent()){
            for (Horario h: tempClinica.get().getHorarios()) {
                if(h.getData().compareTo(newHorario.getData()) == 0){
                    return null;
                }
            }
            tempClinica.get().getHorarios().add(newHorario);
            clinica_repo.save(tempClinica.get());
        }
        return null;
    }

    @Override
    public Horario updateHorario(Long id, Horario updateHorario) {
        Optional<ProfSaude> tempPerfil = profsaude_repo.findById(id);
        Optional<Clinica> tempClinica =  clinica_repo.findById(id);

        if(tempPerfil.isPresent()){
            for (Horario h: tempPerfil.get().getHorarios()) {
                if(h.getData().compareTo(updateHorario.getData()) == 0){
                    h.setHoraInicio(updateHorario.getHoraInicio());
                    h.setHoraFim(updateHorario.getHoraFim());
                    h.setAtendimentos(updateHorario.getAtendimentos());
                    h.setData(updateHorario.getData());
                    h.setDiaSemana(updateHorario.getDiaSemana());
                    h.setProfSaude(updateHorario.getProfSaude());
                    profsaude_repo.save(h.getProfSaude());
                    return h;
                }
            }
        }
        else if(tempClinica.isPresent()){
            for (Horario h: tempClinica.get().getHorarios()) {
                if(h.getData().compareTo(updateHorario.getData()) == 0){
                    h.setHoraInicio(updateHorario.getHoraInicio());
                    h.setHoraFim(updateHorario.getHoraFim());
                    h.setData(updateHorario.getData());
                    h.setDiaSemana(updateHorario.getDiaSemana());
                    h.setClinica(updateHorario.getClinica());
                    clinica_repo.save(h.getClinica());
                    return h;
                }
            }
        }

        return null;
    }

    @Override
    public Horario getHorario(Long id) {
        if(horario_Repo.findById(id).isPresent())return horario_Repo.findById(id).get();
        else return null;
    }

}
