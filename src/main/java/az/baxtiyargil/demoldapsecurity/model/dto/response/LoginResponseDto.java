package az.baxtiyargil.demoldapsecurity.model.dto.response;

import az.baxtiyargil.demoldapsecurity.model.dto.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private TokenDto token;

}
