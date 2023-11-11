package az.baxtiyargil.demoldapsecurity.controller;

import az.baxtiyargil.demoldapsecurity.model.dto.request.CreateUserRequestDto;
import az.baxtiyargil.demoldapsecurity.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Example endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public String getById(@Valid @PathVariable String id) {
        return "Hello!";
    }

    @PostMapping
    @Operation(summary = "Example endpoint create user", security = @SecurityRequirement(name = "bearerAuth"))
    public void create(@Valid @RequestBody CreateUserRequestDto request) {
        userService.create(request);
    }

}
