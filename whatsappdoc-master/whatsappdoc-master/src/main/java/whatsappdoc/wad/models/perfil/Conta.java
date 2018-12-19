package whatsappdoc.wad.models.perfil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import whatsappdoc.wad.models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Conta extends BaseModel {
    private String username;
    private String password;
    @EqualsAndHashCode.Exclude
    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    private ProfSaude profSaude;

    public Conta(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
