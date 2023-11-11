package az.baxtiyargil.demoldapsecurity.controller;

import az.baxtiyargil.demoldapsecurity.model.dto.request.LoginRequestDto;
import az.baxtiyargil.demoldapsecurity.model.dto.response.LoginResponseDto;
import az.baxtiyargil.demoldapsecurity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request) {
        return authService.login(request);
    }

}
