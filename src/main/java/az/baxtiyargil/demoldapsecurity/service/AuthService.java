package az.baxtiyargil.demoldapsecurity.service;

import az.baxtiyargil.demoldapsecurity.model.dto.request.LoginRequestDto;
import az.baxtiyargil.demoldapsecurity.model.dto.response.LoginResponseDto;
import az.baxtiyargil.demoldapsecurity.component.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${spring.security.oauth2.client.registration.keycloak.provider}")
    private String registrationId;
    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String principal;

    private final AuthMapper authMapper;
    private final OAuth2AuthorizedClientManager manager;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(registrationId)
                .principal(principal)
                .attributes(attrs -> attrs.put(LoginRequestDto.class.getName(), loginRequestDto))
                .build();

        OAuth2AuthorizedClient authorizedClient = manager.authorize(authorizeRequest);
        return LoginResponseDto.builder()
                .token(authMapper.mapToTokenDto(authorizedClient))
                .build();
    }

}
