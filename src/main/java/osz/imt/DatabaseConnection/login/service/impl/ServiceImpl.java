package osz.imt.DatabaseConnection.login.service.impl;

import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import osz.imt.DatabaseConnection.login.persistence.LoginRepository;
import osz.imt.DatabaseConnection.login.persistence.model.LoginEntity;
import osz.imt.DatabaseConnection.login.service.LoginService;
import osz.imt.DatabaseConnection.login.web.model.Login;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public Login createAccount(Login login) {

        if (login.getUsername() == null || login.getUsername().equals(" ")) {
            throw new RuntimeException();
        }

        if (login.getPassword() == null || login.getPassword().equals(" ")) {
            throw new RuntimeException();
        }

        String username = login.getUsername();
        Optional<LoginEntity> loginOrEmpty = loginRepository.findById(username);

        if (loginOrEmpty.isPresent()) {
            throw new RuntimeException();
        }

        String salt = UUID.randomUUID().toString();
        String saltedPassword = Hashing.sha256()
                .hashString(login.getPassword() + salt, StandardCharsets.UTF_8)
                .toString();

        LoginEntity entity = new LoginEntity(username, saltedPassword, salt);
        LoginEntity savedEntity = loginRepository.save(entity);
        return new Login(savedEntity.getUsername(), savedEntity.getPassword());
    }

    @Override
    public Login login(Login login) {

        if (login.getUsername() == null || login.getUsername().equals(" ")) {
            throw new RuntimeException();
        }

        if (login.getPassword() == null || login.getPassword().equals(" ")) {
            throw new RuntimeException();
        }

        Optional<LoginEntity> loginEntity = loginRepository.findById(login.getUsername());

        if (loginEntity.isEmpty()) {
            throw new RuntimeException();
        }

        LoginEntity entity = loginEntity.get();
        String savedPassword = entity.getPassword();
        String savedSalt = entity.getSalt();

        String receivedPassword = login.getPassword();
        String hashedPassword = Hashing.sha256()
                .hashString(receivedPassword + savedSalt, StandardCharsets.UTF_8)
                .toString();

        if (hashedPassword.equals(savedPassword)) {
            return new Login(entity.getUsername(), entity.getPassword());
        }

        return null;
    }
}
