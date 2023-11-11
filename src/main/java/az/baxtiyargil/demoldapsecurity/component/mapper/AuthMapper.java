package az.baxtiyargil.demoldapsecurity.component.mapper;

import az.baxtiyargil.demoldapsecurity.model.dto.TokenDto;
import org.mapstruct.Mapper;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    default TokenDto mapToTokenDto(OAuth2AuthorizedClient authorizedClient) {
        if (Objects.isNull(authorizedClient)) {
            return null;
        }
        return TokenDto.builder()
                .accessToken(authorizedClient.getAccessToken().getTokenValue())
                .refreshToken(authorizedClient.getRefreshToken().getTokenValue())
                .build();
    }

}
