package whatsappdoc.wad.models.request;

import lombok.*;
import whatsappdoc.wad.models.perfil.Perfil;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfSaudeRequest extends Perfil {
    @NotNull(message = "O username não pode ser nulo")
    private String username;
    @NotNull(message = "A password não pode ser nula")
    private String password;
    @NotNull(message = "O nome da especialidade não pode ser nulo")
    private String nomeEspecialidade;
    @NotNull(message = "O nome do tipo de profissional de saúde não pode ser nulo")
    private String nomeTipoProfSaude;
}
