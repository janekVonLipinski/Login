package osz.imt.DatabaseConnection.login.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import osz.imt.DatabaseConnection.login.service.LoginService;
import osz.imt.DatabaseConnection.login.web.model.Login;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public Login login(@ModelAttribute  Login login) {
        return loginService.login(login);
    }

    @PostMapping("/login")
    public Login createAccount(@RequestBody  Login login) {
        return loginService.createAccount(login);
    }
}
