package az.baxtiyargil.demoldapsecurity.model.dto.request;

import lombok.Data;

@Data
public class CreateUserRequestDto {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;

}
