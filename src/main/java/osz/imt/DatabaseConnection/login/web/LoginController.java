package osz.imt.DatabaseConnection.login.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osz.imt.DatabaseConnection.login.service.LoginService;
import osz.imt.DatabaseConnection.login.web.model.Login;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute  Login login) {

        Login attemptedLogin;
        try {
            attemptedLogin = loginService.login(login);
        } catch (RuntimeException r) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        if (attemptedLogin == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(401));
        }

        return new ResponseEntity<>(attemptedLogin, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAccount(@RequestBody Login login) {
        Login createdLogin;
        try {
            createdLogin = loginService.createAccount(login);
        } catch (RuntimeException r) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        return new ResponseEntity<>(createdLogin, HttpStatusCode.valueOf(201));
    }
}
