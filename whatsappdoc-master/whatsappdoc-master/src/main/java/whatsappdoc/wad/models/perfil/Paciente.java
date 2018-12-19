package whatsappdoc.wad.models.perfil;

import lombok.*;
import whatsappdoc.wad.models.calendario.Atendimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Paciente extends Perfil {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "paciente")
    private Set<Atendimento> atendimentos = new HashSet<>();
}
