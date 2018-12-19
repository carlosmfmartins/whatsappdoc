package whatsappdoc.wad.models.perfil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import whatsappdoc.wad.models.calendario.Horario;

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
public class Clinica extends Perfil {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "clinica")
    private Set<Horario> horarios = new HashSet<>();
}
