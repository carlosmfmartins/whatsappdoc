package whatsappdoc.wad.service;

import whatsappdoc.wad.models.calendario.Horario;

public interface HorarioServiceIF {
    Iterable<Horario> finAll();
    boolean removeHorario(Long id);
    Horario insertHorario(Long id, Horario newHorario);
    Horario updateHorario(Long id, Horario updateHorario);
    Horario getHorario(Long id);

}
