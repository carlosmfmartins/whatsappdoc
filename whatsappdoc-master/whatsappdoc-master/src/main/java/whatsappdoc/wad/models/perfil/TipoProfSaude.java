package whatsappdoc.wad.models.perfil;

import lombok.*;
import whatsappdoc.wad.models.BaseModel;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TipoProfSaude extends BaseModel {
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    public TipoProfSaude(String nome) {
        this.nome = nome;
    }
}
