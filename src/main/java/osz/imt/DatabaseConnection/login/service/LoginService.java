package osz.imt.DatabaseConnection.login.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import osz.imt.DatabaseConnection.login.web.model.Login;

@Service
@Transactional
public interface LoginService {

    Login createAccount(Login login);
    Login login(Login login);
}
