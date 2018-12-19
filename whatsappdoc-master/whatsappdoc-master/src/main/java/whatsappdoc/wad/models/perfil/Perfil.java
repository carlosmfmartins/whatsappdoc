package whatsappdoc.wad.models.perfil;

import lombok.*;
import whatsappdoc.wad.models.BaseModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo_Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Perfil extends BaseModel {
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;
    @NotNull(message = "O apelido não pode ser nulo.")
    private String apelido;
    @NotNull(message = "O titulo não pode ser nulo.")
    private String titulo;
    @NotNull(message = "O nif não pode ser nulo.")
    private int nif;
}
