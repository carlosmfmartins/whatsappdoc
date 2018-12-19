package whatsappdoc.wad.models.perfil;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import whatsappdoc.wad.models.calendario.Horario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfSaude extends Perfil {
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Especialidade especialidade;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private TipoProfSaude tipoProfSaude;
    @EqualsAndHashCode.Exclude
    @OneToOne
    private Conta conta;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "profSaude")
    private Set<Horario> horarios = new HashSet<>();

    public ProfSaude(String nome, String apelido, String titulo, int nif, Especialidade especialidade, TipoProfSaude tipoProfSaude, Conta conta) {
        super(nome, apelido, titulo, nif);
        this.especialidade = especialidade;
        this.especialidade.addProfSaude(this);
        this.tipoProfSaude = tipoProfSaude;
        this.conta = conta;
        this.conta.setProfSaude(this);
    }

    @JsonGetter(value = "especialidade")
    public Especialidade toJsonEspecialidade() {
        Especialidade esp = new Especialidade();
        esp.setId(this.getEspecialidade().getId());
        esp.setNome(this.getEspecialidade().getNome());
        esp.setPreco(this.getEspecialidade().getPreco());
        return esp;
    }
}
