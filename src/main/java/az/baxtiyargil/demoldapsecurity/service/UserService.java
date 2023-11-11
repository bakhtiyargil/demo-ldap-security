package az.baxtiyargil.demoldapsecurity.service;

import az.baxtiyargil.demoldapsecurity.component.mapper.UserMapper;
import az.baxtiyargil.demoldapsecurity.model.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void create(CreateUserRequestDto requestDto) {
        var userRepresentation = userMapper.toUserRepresentation(requestDto);
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .grantType(OAuth2Constants.PASSWORD)
                .realm("master")
                .username("admin")
                .password("admin")
                .clientId("admin-cli")
                .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                .build();

        Response response = keycloak.realm("OsixiaLdapSpring").users().create(userRepresentation);
        response.getStatus();

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue("newuser-password");
        credential.setTemporary(false);

        keycloak.realm("OsixiaLdapSpring").users().get(userRepresentation.getId()).resetPassword(credential);
        System.out.println("YES!");
    }

}
