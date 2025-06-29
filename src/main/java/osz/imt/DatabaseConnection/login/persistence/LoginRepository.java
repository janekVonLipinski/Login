package osz.imt.DatabaseConnection.login.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import osz.imt.DatabaseConnection.login.persistence.model.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, String> {
}
