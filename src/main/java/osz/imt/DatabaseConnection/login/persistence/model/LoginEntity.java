package osz.imt.DatabaseConnection.login.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "login")
public class LoginEntity {

    @Column(name = "username")
    @Id
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
}
