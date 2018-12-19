package whatsappdoc.wad.models.calendario;

import lombok.*;
import whatsappdoc.wad.models.BaseModel;
import whatsappdoc.wad.models.perfil.Clinica;
import whatsappdoc.wad.models.perfil.ProfSaude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Horario extends BaseModel {
    private Date Data;
    private String DiaSemana;
    private Time HoraInicio;
    private Time HoraFim;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private ProfSaude profSaude;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Clinica clinica;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "horario")
    private Set<Atendimento> atendimentos = new HashSet<>();

    public Horario (Date data, String DiaSemana, Time HoraInicio, Time HoraFim){
        this.Data = data;
        this.DiaSemana = DiaSemana;
    }
}
