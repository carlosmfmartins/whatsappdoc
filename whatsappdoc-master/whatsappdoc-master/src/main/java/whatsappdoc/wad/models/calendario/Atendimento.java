package whatsappdoc.wad.models.calendario;

import lombok.*;
import whatsappdoc.wad.models.BaseModel;
import whatsappdoc.wad.models.perfil.Paciente;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Atendimento extends BaseModel {
    private Date dataHoraInicio;
    private String descricao;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Horario horario;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Paciente paciente;
    private String estado;
    private boolean pago;
}
