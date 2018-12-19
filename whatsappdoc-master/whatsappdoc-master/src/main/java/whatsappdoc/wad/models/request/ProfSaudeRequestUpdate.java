package whatsappdoc.wad.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import whatsappdoc.wad.models.perfil.Especialidade;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfSaudeRequestUpdate {
    private Especialidade especialidade;
}
