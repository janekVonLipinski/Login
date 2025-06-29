package osz.imt.DatabaseConnection.login.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import osz.imt.DatabaseConnection.login.service.LoginService;
import osz.imt.DatabaseConnection.login.web.model.Login;

@RestController("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public Login login(Login login) {
        return loginService.login(login);
    }

    @PostMapping("/login")
    public Login createAccount(Login login) {
        return loginService.createAccount(login);
    }
}
