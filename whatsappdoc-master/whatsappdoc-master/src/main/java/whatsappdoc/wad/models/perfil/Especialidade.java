package whatsappdoc.wad.models.perfil;

import lombok.*;
import whatsappdoc.wad.models.BaseModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Especialidade extends BaseModel {
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @NotNull(message = "O preço não pode ser nulo")
    private double preco;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "especialidade")
    private Set<ProfSaude> profSaudes = new HashSet<>();

    public Especialidade(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void addProfSaude(ProfSaude profSaude) {
        this.profSaudes.add(profSaude);
    }

    public void removeProfSaude(ProfSaude profSaude) {this.profSaudes.remove(profSaude);}
}
